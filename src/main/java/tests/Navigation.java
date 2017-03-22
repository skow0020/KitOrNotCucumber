package tests;

import api.android.Android;
import api.apps.speedtest.Speedtest;
import core.managers.TestManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Colin on 3/22/2017.
 */
public class Navigation extends TestManager{
    private static Speedtest speedtest = Android.app.speedtest;

    @BeforeClass
    public static void beforeClass()
    {
        speedtest.open();
    }

    @Before
    public void before()
    {
        testinfo.suite("Navigation");
    }

    @Test
    public void test1()
    {
        testinfo.id("Test1").name("Verify that Home Activity has all elements");
        Assert.assertTrue(speedtest.home.uiObject.ping().exists());
        Assert.assertTrue(speedtest.home.uiObject.pingSpeed().exists());
        Assert.assertTrue(speedtest.home.uiObject.download().exists());
        Assert.assertTrue(speedtest.home.uiObject.downloadSpeed().exists());
        Assert.assertTrue(speedtest.home.uiObject.upload().exists());
        Assert.assertTrue(speedtest.home.uiObject.uploadSpeed().exists());
        Assert.assertTrue(speedtest.home.uiObject.shareButton().exists());
        Assert.assertTrue(speedtest.home.uiObject.removeAdsButton().exists());
        Assert.assertTrue(speedtest.home.uiObject.testAgainButton().exists());
        Assert.assertTrue(speedtest.home.uiObject.logo().exists());
    }

    @Test
    public void test2()
    {
        testinfo.id("Test2").name("Verify that Results has sorting buttons");
        speedtest.menu.tapResults();
        Assert.assertTrue(speedtest.results.uiObject.toolsButton().exists());
        Assert.assertTrue(speedtest.results.uiObject.resultsLabel().exists());
        Assert.assertTrue(speedtest.results.uiObject.sortByDownload().exists());
        Assert.assertTrue(speedtest.results.uiObject.sortByPing().exists());
        Assert.assertTrue(speedtest.results.uiObject.sortByTime().exists());
        Assert.assertTrue(speedtest.results.uiObject.sortByType().exists());
        Assert.assertTrue(speedtest.results.uiObject.sortByUpload().exists());
        Assert.assertTrue(speedtest.results.uiObject.logo().exists());
    }

    @Test
    public void test3()
    {
        testinfo.id("test3").name("Verify the About activitiy has PP and ToU links");
        speedtest.menu.tapAbout();
        Assert.assertTrue(speedtest.about.uiObject.privacyPolicy().exists());
        Assert.assertTrue(speedtest.about.uiObject.termsOfUse().exists());
    }
}
