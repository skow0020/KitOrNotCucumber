package api.apps.kitOrNot.photoAlbumActivity;

import api.android.Android;
import api.apps.kitOrNot.photoAlbumActivity.selectImageActivity.SelectImageActivity;
import core.MyLogger;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Colin on 3/28/2017.
 */
public class PhotoAlbumActivity {

    public PhotoAlbumUiObjects uiObject = new PhotoAlbumUiObjects();

    public PhotoAlbumActivity waitToLoad() {
        try{
            MyLogger.log.info("Waiting for Photo Album activity");
            uiObject.selectAlbumTitle().waitToAppear(10);
            return Android.app.kitTest.photoAlbumActivity;
        }catch (AssertionError e)
        {
            throw new AssertionError("Photo Album activity failed to load/open");
        }
    }

    public SelectImageActivity tapMainImage()
    {
        try{
            MyLogger.log.info("Tapping on main image button");
            uiObject.mainCameraImg().tap();
            return Android.app.kitTest.selectImageActivity;
        }catch (NoSuchElementException e)
        {
            throw new AssertionError("Can't tap main image button, element absent or blocked");
        }
    }
}
