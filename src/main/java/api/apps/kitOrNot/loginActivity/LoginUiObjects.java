package api.apps.kitOrNot.loginActivity;

import core.UiObject;
import core.UiSelector;

public class LoginUiObjects {

    private static UiObject
            logo,
            userName,
            password,
            login_signup_button,
            login_signup_text,
            contact;

    public UiObject logo()
    {
        if (logo == null ) logo = new UiSelector().description("Cat Backside").makeUiObject();
        return logo;
    }

    public UiObject userName()
    {
        if (userName == null ) userName = new UiSelector().resourceID("com.skow.kitornot:id/username").makeUiObject();
        return userName;
    }

    public UiObject password()
    {
        if (password == null ) password = new UiSelector().resourceID("com.skow.kitornot:id/password").makeUiObject();
        return password;
    }

    public UiObject login_signup_button()
    {
        if (login_signup_button == null ) login_signup_button = new UiSelector().resourceID("com.skow.kitornot:id/login_signup_btn").makeUiObject();
        return login_signup_button;
    }

    public UiObject login_signup_text()
    {
        if (login_signup_text == null ) login_signup_text = new UiSelector().resourceID("com.skow.kitornot:id/login_signup_txt").makeUiObject();
        return login_signup_text;
    }

    public UiObject contact()
    {
        if (contact == null ) contact = new UiSelector().resourceID("com.skow.kitornot:id/contact_txt").makeUiObject();
        return contact;
    }
}
