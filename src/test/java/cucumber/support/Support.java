package cucumber.support;

import api.android.Android;
import api.apps.kitOrNot.KitTest;
import core.Timer;
import org.junit.Assert;

/**
 * Created by Colin on 3/27/2017.
 */
public class Support {
    private static KitTest kitTest = Android.app.kitTest;

    public void loginScreen()
    {
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

    public void login(String username, String password)
    {
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.userName(), kitTest.login.uiObject.userName().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.password(), kitTest.login.uiObject.password().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.login_signup_button(), kitTest.login.uiObject.login_signup_button().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.login_signup_text(), kitTest.login.uiObject.login_signup_text().exists());
        Assert.assertTrue("Could not find element: " + kitTest.login.uiObject.logo(), kitTest.login.uiObject.logo().exists());

        if (kitTest.login.uiObject.login_signup_text().getText().equals("Log In")) kitTest.login.uiObject.login_signup_text().tap();
        kitTest.login.uiObject.userName().clearText();
        kitTest.login.uiObject.userName().typeText(username);
        kitTest.login.uiObject.password().clearText();
        kitTest.login.uiObject.password().typeText(password);
        kitTest.login.uiObject.login_signup_button().tap();
    }

    public void verifyUserHome()
    {
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.userCatsTitle().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.addImageBtn().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridView().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridImage0().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridImage1().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.ratingActivityBtn().exists());
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.topCatsBtn().exists());
    }

    public void verifyRatingActivity()
    {
        Assert.assertTrue(kitTest.ratingActivity.uiObject.catImage().exists());
        Assert.assertTrue(kitTest.ratingActivity.uiObject.thumbDown().exists());
        Assert.assertTrue(kitTest.ratingActivity.uiObject.thumbUp().exists());
    }

    public void verifyTopCats()
    {
        Assert.assertTrue(kitTest.topCatsActivity.uiObject.topCatTitle().exists());
        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridview().exists());
        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridImage0().exists());
        Assert.assertTrue(kitTest.topCatsActivity.uiObject.gridImage1().exists());
    }

    public void verifyImageAdd()
    {
        Assert.assertTrue(kitTest.photoAlbumActivity.uiObject.selectAlbumTitle().exists());
        kitTest.photoAlbumActivity.tapMainImage().waitToLoad();
        Assert.assertTrue(kitTest.selectImageActivity.uiObject.selectAlbumTitle().exists());
        kitTest.selectImageActivity.tapSelectImage().waitToLoad();
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.gridImage0().exists());
    }

    public void verifyImageDelete()
    {
        kitTest.userHomeActivity.uiObject.gridImage0().longClick();
        Assert.assertTrue(kitTest.userHomeActivity.uiObject.deleteBtn().exists());
        kitTest.userHomeActivity.uiObject.deleteBtn().tap();
        Assert.assertTrue(!kitTest.userHomeActivity.uiObject.gridImage0().exists());
    }

    public void verifyInvalidLogin()
    {
        Assert.assertTrue("Login worked on invalid credentials!", !kitTest.userHomeActivity.uiObject.ratingActivityBtn().exists());
        Assert.assertTrue(kitTest.login.uiObject.userName().exists());
        Assert.assertTrue(kitTest.login.uiObject.userName().exists());
    }

    public void verifyTopCatDetails()
    {
        Assert.assertTrue(kitTest.topCatDetailsActivity.uiObject.catImage().exists());
        Assert.assertTrue(kitTest.topCatDetailsActivity.uiObject.percentage().exists());
    }

    public void verifyUserCatDetails()
    {
        Assert.assertTrue(kitTest.userCatDetailsActivity.uiObject.catImage().exists());
        Assert.assertTrue(kitTest.userCatDetailsActivity.uiObject.percentage().exists());
    }
}
