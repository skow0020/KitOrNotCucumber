package api.apps.kitOrNot.ratingActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/27/2017.
 */
public class RatingActivityUiObjects{
    private static UiObject
            catImage,
            thumbUp,
            thumbDown;

    public UiObject catImage()
    {
        if (catImage == null ) catImage = new UiSelector().description("catImage").makeUiObject();
        return catImage;
    }

    public UiObject thumbUp()
    {
        if (thumbUp == null ) thumbUp = new UiSelector().description("Thumbs up").makeUiObject();
        return thumbUp;
    }

    public UiObject thumbDown()
    {
        if (thumbDown == null ) thumbDown = new UiSelector().description("Thumbs down").makeUiObject();
        return thumbDown;
    }
}
