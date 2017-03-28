package api.apps.kitOrNot.ratingActivity;

import api.android.Android;
import api.apps.speedtest.home.Home;
import api.interfaces.Activity;
import core.MyLogger;

/**
 * Created by Colin on 3/27/2017.
 */
public class RatingActivity implements Activity {

    public RatingActivityUiObjects uiObject = new RatingActivityUiObjects();

    public RatingActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Rating activity");
            uiObject.catImage().waitToAppear(10);
            return Android.app.kitTest.ratingActivity.waitToLoad();
        }catch (AssertionError e)
        {
            throw new AssertionError("Rating activity failed to load/open");
        }
    }
}
