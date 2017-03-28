package api.apps.kitOrNot.userCatDetailsActivity;

import api.android.Android;
import core.MyLogger;

/**
 * Created by Colin on 3/27/2017.
 */
public class UserCatDetailsActivity {

    public UserCatDetailsUiObjects uiObject = new UserCatDetailsUiObjects();

    public UserCatDetailsActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for User Cat Details activity");
            uiObject.catImage().waitToAppear(10);
            return Android.app.kitTest.userCatDetailsActivity.waitToLoad();
        }catch (AssertionError e)
        {
            throw new AssertionError("User Cat Details activity failed to load/open");
        }
    }
}
