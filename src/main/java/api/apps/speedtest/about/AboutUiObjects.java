package api.apps.speedtest.about;

import core.UiObject;
import core.UiSelector;

/**
 * Created by Colin on 3/22/2017.
 */
public class AboutUiObjects {
    private static UiObject
    privacyPolicy,
    termsOfUse,
    logo;

    public UiObject privacyPolicy()
    {
        if (privacyPolicy == null ) privacyPolicy = new UiSelector().description("Privacy Policy").makeUiObject();
        return privacyPolicy;
    }

    public UiObject termsOfUse()
    {
        if (termsOfUse == null ) termsOfUse = new UiSelector().description("Terms of Use").makeUiObject();
        return termsOfUse;
    }

    public UiObject logo()
    {
        if (logo == null ) logo = new UiSelector().description("Speedtest.net").makeUiObject();
        return logo;
    }
}
