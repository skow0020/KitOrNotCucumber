package api.apps.kitOrNot.userHomeActivity;

import api.android.Android;
import api.apps.kitOrNot.photoAlbumActivity.PhotoAlbumActivity;
import api.apps.kitOrNot.ratingActivity.RatingActivity;
import api.apps.kitOrNot.topCatsActivity.TopCatsActivity;
import api.apps.kitOrNot.userCatDetailsActivity.UserCatDetailsActivity;
import api.interfaces.Activity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Colin on 3/27/2017.
 */
public class UserHomeActivity implements Activity {

    public UserHomeActivityUiObjects uiObject = new UserHomeActivityUiObjects();

    public UserHomeActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for User home activity");
            uiObject.gridImage0().waitToAppear(10);
            return Android.app.kitTest.userHomeActivity;
        }catch (AssertionError e)
        {
            throw new AssertionError("User Home activity failed to load/open");
        }
    }

    public RatingActivity tapRatingActivityBtn()
    {
        try{
            MyLogger.log.info("Tapping on Rating Activity button");
            uiObject.ratingActivityBtn().tap();
            return Android.app.kitTest.ratingActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Rating activity button, element absent or blocked");
        }
    }

    public TopCatsActivity tapTopCatsBtn()
    {
        try{
            MyLogger.log.info("Tapping on Top Cats button");
            uiObject.topCatsBtn().tap();
            return Android.app.kitTest.topCatsActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Top Cats activity button, element absent or blocked");
        }
    }

    public PhotoAlbumActivity tapAddCatImageBtn()
    {
        try{
            MyLogger.log.info("Tapping on Add Cat image button");
            uiObject.addImageBtn().tap();
            return Android.app.kitTest.photoAlbumActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap Add Image Button, element absent or blocked");
        }
    }

    public UserHomeActivity longClickTopLeftImg()
    {
        try{
            MyLogger.log.info("Long click on top left image");
            uiObject.gridImage0().longClick();
            return Android.app.kitTest.userHomeActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't long click top left image, element absent or blocked");
        }
    }

    public UserCatDetailsActivity tapTopLeftImg()
    {
        try{
            MyLogger.log.info("Tapping on top left image");
            uiObject.gridImage0().tap();
            return Android.app.kitTest.userCatDetailsActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap top left image, element absent or blocked");
        }
    }
}
