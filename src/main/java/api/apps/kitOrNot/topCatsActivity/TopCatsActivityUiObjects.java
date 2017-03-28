package api.apps.kitOrNot.topCatsActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/27/2017.
 */
public class TopCatsActivityUiObjects {

    private static UiObject
            topCatTitle,
            gridview,
            gridImage0,
            gridImage1;

    public UiObject topCatTitle()
    {
        if (topCatTitle == null ) topCatTitle = new UiSelector().resourceID("com.skow.kitornot:id/topCatsLabel").makeUiObject();
        return topCatTitle;
    }

    public UiObject gridview()
    {
        if (gridview == null ) gridview = new UiSelector().resourceID("com.skow.kitornot:id/topCats").makeUiObject();
        return gridview;
    }

    public UiObject gridImage0()
    {
        if (gridImage0 == null ) gridImage0 = new UiSelector().className("android.widget.ImageView").index(0).makeUiObject();
        return gridImage0;
    }

    public UiObject gridImage1()
    {
        if (gridImage1 == null ) gridImage1 = new UiSelector().className("android.widget.ImageView").index(1).makeUiObject();
        return gridImage1;
    }
}
