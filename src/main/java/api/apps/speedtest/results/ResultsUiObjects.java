package api.apps.speedtest.results;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/22/2017.
 */
public class ResultsUiObjects {

    private static UiObject
    logo,
    sortByType,
    sortByTime,
    sortByDownload,
    sortByUpload,
    sortByPing,
    toolsButton,
    resultsLabel;

    public UiObject logo()
    {
        if (logo == null) logo = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/typeLayout").makeUiObject();
        return logo;
    }

    public UiObject sortByType()
    {
        if (sortByType == null) sortByType = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/timeLayout").makeUiObject();
        return sortByType;
    }

    public UiObject sortByTime()
    {
        if (sortByTime == null) sortByTime = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/logo").makeUiObject();
        return sortByTime;
    }

    public UiObject sortByDownload()
    {
        if (sortByDownload == null) sortByDownload = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/downloadLayout").makeUiObject();
        return sortByDownload;
    }

    public UiObject sortByUpload()
    {
        if (sortByUpload == null) sortByUpload = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/uploadLayout").makeUiObject();
        return sortByUpload;
    }

    public UiObject sortByPing()
    {
        if (sortByPing == null) sortByPing = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/pingLayout").makeUiObject();
        return sortByPing;
    }

    public UiObject toolsButton()
    {
        if (toolsButton == null) toolsButton = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/toolsButton").makeUiObject();
        return toolsButton;
    }

    public UiObject resultsLabel()
    {
        if (resultsLabel == null) resultsLabel = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/resultsCoutText").makeUiObject();
        return resultsLabel;
    }
}
