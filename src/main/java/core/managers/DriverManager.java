package core.managers;

import api.android.Android;
import core.ADB;
import core.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import org.apache.xpath.operations.And;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Colin on 3/20/2017.
 */
public class DriverManager {

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";

    private static DesiredCapabilities getCaps(String deviceID)
    {
        MyLogger.log.info("Creating driver caps for device: " + deviceID);
        DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", deviceID);
            caps.setCapability("platformName", "Android");
            caps.setCapability("app", "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\build\\unlock_apk\\unlock_apk-debug.apk");
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

    public static void createDriver() throws MalformedURLException
    {
        ArrayList<String> devices = getAvailableDevices();
        for (String device : devices)
        {
            try {
                MyLogger.log.info("Trying to create new Driver for device: " + device);
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
        }
        else
        {
            MyLogger.log.info("Android Driver is not initialized, nothing to kill");
        }
    }
}
