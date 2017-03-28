package api.apps.kitOrNot.photoAlbumActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/28/2017.
 */
public class PhotoAlbumUiObjects {

    private static UiObject
            selectAlbumTitle,
            mainCameraImg;

    public UiObject selectAlbumTitle()
    {
        if (selectAlbumTitle == null ) selectAlbumTitle = new UiSelector().text("Select album").makeUiObject();
        return selectAlbumTitle;
    }

    public UiObject mainCameraImg()
    {
        if (mainCameraImg == null ) mainCameraImg = new UiSelector().className("android.view.View").makeUiObject();
        return mainCameraImg;
    }

}
