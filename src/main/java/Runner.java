import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import core.UiSelector;

/**
 * Created by Colin on 3/12/2017.
 */
public class Runner {
    public static void main(String[] args) {

    //LEFT OFF ON PART 8

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
