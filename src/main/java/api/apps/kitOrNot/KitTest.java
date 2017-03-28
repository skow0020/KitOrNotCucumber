package api.apps.kitOrNot;

import api.android.Android;
import api.apps.kitOrNot.loginActivity.Login;
import api.apps.kitOrNot.ratingActivity.RatingActivity;
import api.apps.kitOrNot.topCatDetailsActivity.TopCatDetailsActivity;
import api.apps.kitOrNot.topCatsActivity.TopCatsActivity;
import api.apps.kitOrNot.userCatDetailsActivity.UserCatDetailsActivity;
import api.apps.kitOrNot.userHomeActivity.UserHomeActivity;
import api.interfaces.Application;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by Colin on 3/27/2017.
 */
public class KitTest implements Application {
    public Login login = new Login();
    public UserHomeActivity userHomeActivity = new UserHomeActivity();
    public RatingActivity ratingActivity = new RatingActivity();
    public TopCatsActivity topCatsActivity = new TopCatsActivity();
    public TopCatDetailsActivity topCatDetailsActivity = new TopCatDetailsActivity();
    public UserCatDetailsActivity userCatDetailsActivity = new UserCatDetailsActivity();

    public void forceStop() {
        Android.adb.forceStopApp(packageID());
    }

    public Object open() {
        Android.adb.openAppsActivity(packageID(), activityID());
        return null;
    }

    public void clearData() {
        Android.adb.clearAppsData(packageID());
    }

    public String packageID() {
        return "com.skow.kitornot";
    }

    public String activityID() {
        return "com.skow.kitornot.MainActivity";
    }

    public void clickBack() { Android.driver.pressKeyCode(AndroidKeyCode.BACK); }
}
