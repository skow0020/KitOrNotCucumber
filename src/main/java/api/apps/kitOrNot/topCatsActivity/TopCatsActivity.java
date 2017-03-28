package api.apps.kitOrNot.topCatsActivity;

import api.android.Android;
import api.interfaces.Activity;
import core.MyLogger;

/**
 * Created by Colin on 3/27/2017.
 */
public class TopCatsActivity implements Activity {
    public TopCatsActivityUiObjects uiObject = new TopCatsActivityUiObjects();

    public TopCatsActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Top Cats activity");
            uiObject.gridImage1().waitToAppear(10);
            return Android.app.kitTest.topCatsActivity;
        }catch (AssertionError e)
        {
            throw new AssertionError("Top Cats activity failed to load/open");
        }
    }
}
