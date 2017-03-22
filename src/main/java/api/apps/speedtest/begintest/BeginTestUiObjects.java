package api.apps.speedtest.begintest;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/22/2017.
 */
public class BeginTestUiObjects {

    private static UiObject beginTestButton;

    public UiObject beginTestButton()
    {
        if (beginTestButton == null) beginTestButton = new UiSelector().text("Begin Test").makeUiObject();
        return beginTestButton;
    }
}
