import api.android.Android;
import core.UiObject;
import core.managers.DriverManager;
import core.UiSelector;
import core.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Level;

/**
 * Created by Colin on 3/12/2017.
 */
public class Runner {
    public static void main(String[] args) {
        MyLogger.log.setLevel(Level.DEBUG); //Enable different logging levels : INFO, DEBUG, ERRROR, etc
        AndroidDriver driver = null;
        try {
            DriverManager.createDriver();

            Android.adb.openAppsActivity("org.zwanoo.android.speedtest", "com.ookla.speedtest.softfacade.MainActivity");

            UiObject testAgainButton = new UiSelector().resourceID("org.zwanoo.android.speedtest:id/o2_button_text").makeUiObject();
            UiObject ping = new UiSelector().resourceID("org.zwanoo.android.speedtest:id/pingSpeed").makeUiObject();
            UiObject download = new UiSelector().resourceID("org.zwanoo.android.speedtest:id/downloadSpeed").makeUiObject();
            UiObject upload = new UiSelector().resourceID("org.zwanoo.android.speedtest:id/uploadSpeed").makeUiObject();

            testAgainButton.waitToAppear(5);
            testAgainButton.tap();
            testAgainButton.waitToDisappear(5);
            testAgainButton.waitToAppear(120);

            MyLogger.log.info("Ping : " + ping.getText());
            MyLogger.log.info("Download : " + download.getText());
            MyLogger.log.info("Upload : " + upload.getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            if (driver != null) driver.quit();
            Android.adb.uninstallApp("io.appium.unlock");
        }
    }
}












        //-----------------------------------------------Intro Tutorial Stuff------------------------------------------
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("deviceName", "VS9854G9e1c8906");
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("app", "C:\\Program Files (x86)\\Appium\\node_modules\\appium\\build\\unlock_apk\\unlock_apk-debug.apk");
//        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
//
//        driver.pressKeyCode(AndroidKeyCode.HOME);
////
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Apps\")").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Settings\")").click();
//        driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Wi\").textContains(\"Fi\")").click();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        String ssid = driver.findElementByXPath("//android.widget.TextView[@text=\"Connected\"]/preceding::android.widget.TextView[1]").getAttribute("name");
//
//        System.out.println("Connected to: " + ssid);
////
////        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Habits\")").click();
////        driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Bike to work\")").click();
////        driver.findElementByAndroidUIAutomator("new UiSelector().description(\"Navigate up\")").click();
//
//        //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"org.isoron.uhabits:id/action_edit_habit\").checked(true)").click();
//        driver.quit();
//    }
//}
