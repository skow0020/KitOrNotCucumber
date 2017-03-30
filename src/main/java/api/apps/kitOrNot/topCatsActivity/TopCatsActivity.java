package api.apps.kitOrNot.topCatsActivity;

import api.android.Android;
import api.apps.kitOrNot.topCatDetailsActivity.TopCatDetailsActivity;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

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

    public TopCatDetailsActivity tapCatInGrid()
    {
        try{
            MyLogger.log.info("Tapping on Add Cat image button");
            uiObject.gridImage1().tap();
            return Android.app.kitTest.topCatDetailsActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap image in Top Cats grid, element absent or blocked");
        }
    }
}
