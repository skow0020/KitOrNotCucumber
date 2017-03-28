package api.apps.kitOrNot.topCatDetailsActivity;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;

/**
 * Created by Colin on 3/27/2017.
 */
public class TopCatDetailsActivity implements Activity {

    public TopCatDetailsUiObjects uiObject = new TopCatDetailsUiObjects();

    public TopCatDetailsActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Top Cat Details activity");
            uiObject.catImage().waitToAppear(10);
            return Android.app.kitTest.topCatDetailsActivity.waitToLoad();
        }catch (AssertionError e)
        {
            throw new AssertionError("Top Cat Details activity failed to load/open");
        }
    }
}
