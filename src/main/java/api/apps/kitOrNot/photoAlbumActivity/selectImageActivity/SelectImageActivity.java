package api.apps.kitOrNot.photoAlbumActivity.selectImageActivity;

import api.android.Android;
import api.apps.kitOrNot.userHomeActivity.UserHomeActivity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Colin on 3/28/2017.
 */
public class SelectImageActivity {

    public SelectImageUiObjects uiObject = new SelectImageUiObjects();

    public SelectImageActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Photo Album activity");
            uiObject.selectAlbumTitle().waitToAppear(10);
            return Android.app.kitTest.selectImageActivity;
        }catch (AssertionError e)
        {
            throw new AssertionError("Photo Album activity failed to load/open");
        }
    }

    public UserHomeActivity tapSelectImage()
    {
        try{
            MyLogger.log.info("Tapping on select image button");
            uiObject.mainScreen().tap();
            return Android.app.kitTest.userHomeActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap select image button, element absent or blocked");
        }
    }
}
