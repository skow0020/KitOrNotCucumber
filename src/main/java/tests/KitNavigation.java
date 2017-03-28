package tests;

import api.android.Android;
import api.apps.kitOrNot.KitTest;
import core.Timer;
import core.managers.TestManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Colin on 3/27/2017.
 */
public class KitNavigation extends TestManager {
    private static KitTest kitTest = Android.app.kitTest;

    @BeforeClass
    public static void beforeClass(){ kitTest.open(); }

    @Before
    public void before()
    {
        testinfo.suite("KitNavigation");

        Timer timer = new Timer();
        timer.start();
        while(!timer.expired(10))
        {
            try {
                Thread.sleep(500);
                if (!kitTest.login.uiObject.userName().exists()) kitTest.clickBack();
            } catch (InterruptedException e) {}
        }
    }

    @Test
    public void login()
    {
        testinfo.id("Test1").name("Verify that login works correctly");
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.userName(), kitTest.login.uiObject.userName().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.password(), kitTest.login.uiObject.password().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.login_signup_button(), kitTest.login.uiObject.login_signup_button().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.login_signup_text(), kitTest.login.uiObject.login_signup_text().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.logo(), kitTest.login.uiObject.logo().exists());

        kitTest.login.uiObject.userName().clearText();
        kitTest.login.uiObject.userName().typeText("Callie");
        kitTest.login.uiObject.password().clearText();
        kitTest.login.uiObject.password().typeText("333");
        kitTest.login.uiObject.login_signup_button().tap();
    }

    @Test
    public void test2()
    {
        login();
        testinfo.id("Test2").name("Verify that User Home Activity has all elements");
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.userCatsTitle().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.addImageBtn().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridView().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridImage0().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridImage1().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.ratingActivityBtn().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.topCatsBtn().exists());
    }

//    @Test
//    public void test3()
//    {
//        testinfo.id("Test3").name("Verify that Rating Activity has all elements");
//        kitTest.userHomeActivity.tapRatingActivityBtn().waitToLoad();
//        Assert.assertTrue(kitTest.ratingActivity.uiObject.catImage().exists());
//        Assert.assertTrue(kitTest.ratingActivity.uiObject.thumbDown().exists());
//        Assert.assertTrue(kitTest.ratingActivity.uiObject.thumbUp().exists());
//    }
//
//    @Test
//    public void test4()
//    {
//        testinfo.id("Test4").name("Verify that Top Cats Activity has all elements");
//        kitTest.userHomeActivity.tapTopCatsBtn().waitToLoad();
//        Assert.assertTrue(kitTest.topCatsActivity.uiObject.topCatTitle().exists());
//        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridview().exists());
//        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridImage0().exists());
//        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridImage1().exists());
//    }


}
