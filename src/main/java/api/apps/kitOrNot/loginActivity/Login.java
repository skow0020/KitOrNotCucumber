package api.apps.kitOrNot.loginActivity;

import api.android.Android;

import api.interfaces.Activity;
import core.MyLogger;

/**
 * Created by Colin on 3/27/2017.
 */
public class Login implements Activity {

    public LoginUiObjects uiObject = new LoginUiObjects();

    public Login waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Login activity");
            uiObject.login_signup_button().waitToAppear(10);
            return Android.app.kitTest.login;
        }catch (AssertionError e)
        {
            throw new AssertionError("Login activity failed to load/open");
        }
    }
}
