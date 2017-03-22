package api.apps.speedtest.home;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/22/2017.
 */
public class HomeUiObjects {

    private static UiObject
    ping,
    download,
    upload,
    pingSpeed,
    downloadSpeed,
    uploadSpeed,
    testAgainButton,
    removeAdsButton,
    shareButton,
    logo;

    public UiObject ping()
    {
        if (ping == null) ping = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/ping").makeUiObject();
        return ping;
    }

    public UiObject download()
    {
        if (download == null) download = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/download").makeUiObject();
        return download;
    }

    public UiObject upload()
    {
        if (upload == null) upload = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/upload").makeUiObject();
        return upload;
    }
    public UiObject pingSpeed()
    {
        if (pingSpeed == null) pingSpeed = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/pingSpeed").makeUiObject();
        return pingSpeed;
    }

    public UiObject downloadSpeed()
    {
        if (downloadSpeed == null) downloadSpeed = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/downloadSpeed").makeUiObject();
        return downloadSpeed;
    }

    public UiObject uploadSpeed()
    {
        if (uploadSpeed == null) uploadSpeed = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/uploadSpeed").makeUiObject();
        return uploadSpeed;
    }

    public UiObject testAgainButton()
    {
        if (testAgainButton == null) testAgainButton = new UiSelector().text("Test Again").makeUiObject();
        return testAgainButton;
    }

    public UiObject removeAdsButton()
    {
        if (removeAdsButton == null) removeAdsButton = new UiSelector().text("Remove Ads").makeUiObject();
        return removeAdsButton;
    }

    public UiObject shareButton()
    {
        if (shareButton == null) shareButton = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/shareButton").makeUiObject();
        return shareButton;
    }

    public UiObject logo()
    {
        if (logo == null) logo = new UiSelector().resourceID(Android.app.speedtest.packageID() + ":id/logo").makeUiObject();
        return logo;
    }

}
