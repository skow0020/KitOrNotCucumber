package api.apps.kitOrNot.userHomeActivity;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/27/2017.
 */
public class UserHomeActivityUiObjects {

    private static UiObject
            deleteBtn,
            userCatsTitle,
            addImageBtn,
            ratingActivityBtn,
            topCatsBtn,
            gridView,
            gridImage0,
            gridImage1;

    public UiObject deleteBtn()
    {
        if (deleteBtn == null ) deleteBtn = new UiSelector().text("Delete").makeUiObject();
        return deleteBtn;
    }

    public UiObject userCatsTitle()
    {
        if (userCatsTitle == null ) userCatsTitle = new UiSelector().resourceID("com.skow.kitornot:id/userPage").makeUiObject();
        return userCatsTitle;
    }

    public UiObject addImageBtn()
    {
        if (addImageBtn == null ) addImageBtn = new UiSelector().resourceID("com.skow.kitornot:id/addCat").makeUiObject();
        return addImageBtn;
    }

    public UiObject ratingActivityBtn()
    {
        if (ratingActivityBtn == null ) ratingActivityBtn = new UiSelector().resourceID("com.skow.kitornot:id/ratingBtn").makeUiObject();
        return ratingActivityBtn;
    }

    public UiObject topCatsBtn()
    {
        if (topCatsBtn == null ) topCatsBtn = new UiSelector().resourceID("com.skow.kitornot:id/topCatsBtn").makeUiObject();
        return topCatsBtn;
    }

    public UiObject gridView()
    {
        if (gridView == null ) gridView = new UiSelector().resourceID("com.skow.kitornot:id/userCats").makeUiObject();
        return gridView;
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
