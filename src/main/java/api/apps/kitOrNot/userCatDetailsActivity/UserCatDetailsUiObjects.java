package api.apps.kitOrNot.userCatDetailsActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/27/2017.
 */
public class UserCatDetailsUiObjects {

    private static UiObject
            catImage,
            percentage;

    public UiObject catImage()
    {
        if (catImage == null ) catImage = new UiSelector().description("catImage").makeUiObject();
        return catImage;
    }

    public UiObject percentage()
    {
        if (percentage == null ) percentage = new UiSelector().resourceID("com.skow.kitornot:id/percent").makeUiObject();
        return percentage;
    }
}
