package api.apps.kitOrNot.photoAlbumActivity.selectImageActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/28/2017.
 */
public class SelectImageUiObjects {

    private static UiObject
            selectAlbumTitle,
            mainScreen;

    public UiObject selectAlbumTitle()
    {
        if (selectAlbumTitle == null ) selectAlbumTitle = new UiSelector().text("Select image").makeUiObject();
        return selectAlbumTitle;
    }

    public UiObject mainScreen()
    {
        if (mainScreen == null ) mainScreen = new UiSelector().className("android.view.View").makeUiObject();
        return mainScreen;
    }
}
