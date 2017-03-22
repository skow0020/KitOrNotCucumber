package api.apps.speedtest.menu;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/22/2017.
 */
public class MenuUiObjects {

    private static UiObject
            speedtest,
            results,
            settings,
            about;

    public UiObject speedtest()
    {
        if (speedtest == null) speedtest = new UiSelector().text("SPEEDTEST").makeUiObject();
        return speedtest;
    }

    public UiObject results()
    {
        if (results == null) results = new UiSelector().text("RESULTS").makeUiObject();
        return results;
    }

    public UiObject settings()
    {
        if (settings == null) settings = new UiSelector().text("SETTINGS").makeUiObject();
        return settings;
    }

    public UiObject about()
    {
        if (about == null) about = new UiSelector().text("ABOUT").makeUiObject();
        return about;
    }
}
