package api.apps.speedtest.menu;

import api.android.Android;
import api.apps.speedtest.about.About;
import api.apps.speedtest.home.Home;
import api.apps.speedtest.results.Results;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Colin on 3/22/2017.
 */
public class Menu implements Activity {

    public MenuUiObjects uiObject = new MenuUiObjects();

    public Home tapSpeedTest()
    {
        try{
            MyLogger.log.info("Tapping on Speedtest menu button");
            uiObject.speedtest().tap();
            return Android.app.speedtest.home.waitToLoad();
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Speedtest Button, element absent or blocked");
        }
    }

    public Results tapResults()
    {
        try{
            MyLogger.log.info("Tapping on Results menu button");
            uiObject.results().tap();
            return Android.app.speedtest.results.waitToLoad();
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Results Button, element absent or blocked");
        }
    }

    public void tapSettings()
    {
        try{
            MyLogger.log.info("Tapping on Settings menu button");
            uiObject.settings().tap();
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Settings Button, element absent or blocked");
        }
    }

    public About tapAbout()
    {
        try{
            MyLogger.log.info("Tapping on About menu button");
            uiObject.about().tap();
            return Android.app.speedtest.about.waitToLoad();
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap About Button, element absent or blocked");
        }
    }

    public Object waitToLoad() {
        try{
            MyLogger.log.info("Waiting for menu activity");
            uiObject.about().waitToAppear(10);
            return Android.app.speedtest.menu;
        }catch (AssertionError e){
            throw new AssertionError("Menu activity failed to load/open");
        }
    }
}
