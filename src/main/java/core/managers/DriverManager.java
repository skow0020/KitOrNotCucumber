package core.managers;

import api.android.Android;
import core.ADB;
import core.MyLogger;
import core.Timer;
import core.constants.Arg;
import core.constants.Resources;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Colin on 3/20/2017.
 */
public class DriverManager {

    private static String nodeJS = System.getenv("APPIUM_HOME") + "/node.exe";
    private static String appiumJS = System.getenv("APPIUM_HOME") + "/node_modules/appium/bin/appium.js";
    private static DriverService service;
    private static String deviceID;

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";

    private static DesiredCapabilities getCaps(String deviceID)
    {
        MyLogger.log.info("Creating driver caps for device: " + deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", deviceID);
            caps.setCapability("platformName", "Android");
            caps.setCapability("app", "C:/webdrivers/unlock_apk-debug.apk");
        return caps;
    }

    private static URL host(String deviceID) throws MalformedURLException
    {
        if (hosts == null)
        {
            hosts = new HashMap<String, URL>();
            hosts.put("VS9854G9e1c8906", new URL("http://0.0.0.0:4723/wd/hub"));
            //For running tests in parallel on different appium servers
//            hosts.put("deviceID", new URL("http://0.0.0.1:4724/wd/hub"));
//            hosts.put("deviceID", new URL("http://0.0.0.2:4725/wd/hub"));
        }
        return hosts.get(deviceID);
    }

    private static ArrayList<String> getAvailableDevices()
    {
        MyLogger.log.info("Checking for available devices");
        ArrayList<String> availableDevices = new ArrayList<String>();
        ArrayList connectedDevices = ADB.getConnectedDevices();

        //Check if package is installed on the device
        for (Object connectedDevice : connectedDevices) {
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if (!apps.contains(unlockPackage)) availableDevices.add(device);
            else
                MyLogger.log.info("Device: " + device + " has " + unlockPackage + " installed, assuming it is under testing");
        }
        if (availableDevices.size() == 0) throw new RuntimeException("Not a single device is available for testing at this time");
        return availableDevices;
    }

    private static DriverService createService() throws MalformedURLException
    {
        String[] parts = host(deviceID).toString().split(":");
        service = new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS))
                .withIPAddress(parts[1].replace("//", ""))
                .usingPort(Integer.parseInt(parts[2].replace("/wd/hub", "")))
                .withArgument(Arg.TIMEOUT, "120")
                .build();
        return service;
    }

    public static void createDriver() throws MalformedURLException
    {
        ArrayList<String> devices = getAvailableDevices();
        for (String device : devices)
        {
            try {
                deviceID = device;
                MyLogger.log.info("Trying to create new Driver for device: " + device);
                createService().start();
                Android.driver = new AndroidDriver(host(device), getCaps(device));
                Android.adb = new ADB(device);
                break;
            } catch (Exception e) {
                e.printStackTrace();
                //Ignore and try next device
            }
        }
    }

    public static void killDriver()
    {
        if (Android.driver != null)
        {
            MyLogger.log.info("Killing Android Driver");
            Android.driver.quit();
            Android.adb.uninstallApp(unlockPackage);
            service.stop();
        }
        else
        {
            MyLogger.log.info("Android Driver is not initialized, nothing to kill");
        }
    }

    //--------------------------STUFF FOR PARALLEL TESTING ON MULTIPLE DEVICES (CURRENTLY NOT USED, SEE TTUTORIAL PART 20)----------------------
    private static void queueUp()
    {
        try {
            MyLogger.log.info("Queueing Up: " + deviceID);
            JSONObject json = new JSONObject();
            json.put("queued_at", Timer.getTimeStamp());
            JSONObject jsonQueue = Resources.getQueue();
            jsonQueue.put(deviceID, json);
            MyLogger.log.info("JSON Queue: " +jsonQueue);
            ServerManager.write(new File(Resources.QUEUE), jsonQueue.toString());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean useDevice(String deviceID)
    {
        try {
            JSONObject json = Resources.getQueue();
            if (json.containsKey(deviceID))
            {
                JSONObject deviceJson = (JSONObject) json.get(deviceID);
                long time = (long) deviceJson.get("queued_at");
                int diff = Timer.getDifference(time, Timer.getTimeStamp());
                if (diff >=30) return true;
                else return false;
            }else return true;
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static void gracePeriod()
    {
        int waitTime = 0;
        try {
            JSONObject json = Resources.getQueue();
            Set keys = json.keySet();

            JSONObject ourDeviceJson = (JSONObject) json.get(deviceID);
            json.remove(deviceID);
            long weQueuedAt = (long) ourDeviceJson.get("queued_at");

            for (Object key : keys)
            {
                JSONObject deviceJson = (JSONObject) json.get(key);
                long theyQueuedAt = (long) deviceJson.get("queued_at");
                //If we did not queue first we need to wait for the other device to initialize driver so there is no collision
                if (weQueuedAt > theyQueuedAt)
                {
                    //But only if device queued first and recently, otherwise we can assume device we already initialized or no longer being used
                    int diff = Timer.getDifference(theyQueuedAt, Timer.getTimeStamp());
                    if (diff < 50){
                        MyLogger.log.info("Device : " + key + " queued first, I will need to give it extra time to initialize");
                        waitTime += 15;
                    }
                }
            }
            try {Thread.sleep(waitTime);} catch (InterruptedException e) {e.printStackTrace();}
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void leaveQueue()
    {
        try {
            JSONObject jsonQueue = Resources.getQueue();
            jsonQueue.remove(deviceID);
            ServerManager.write(new File(Resources.QUEUE), jsonQueue.toString());
        }  catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
