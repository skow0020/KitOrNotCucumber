package cucumber.steps;

import api.android.Android;
import api.apps.kitOrNot.KitTest;
import api.apps.kitOrNot.topCatsActivity.TopCatsActivity;
import api.apps.kitOrNot.userHomeActivity.UserHomeActivity;
import core.TestInfo;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.support.Hooks;
import cucumber.support.Support;

/**
 * Created by Colin on 3/29/2017.
 */
public class KitSteps {
    private Support support = new Support();
    private static KitTest kitTest = Android.app.kitTest;
    private UserHomeActivity userhome = kitTest.userHomeActivity;
    private TopCatsActivity topCats = kitTest.topCatsActivity;
    TestInfo testinfo = new TestInfo();

    @Given("^test info id \"([^\"]*)\" and name \"([^\"]*)\"$")
    public void testInfoIdAndName(String id, String name) throws Throwable {
        testinfo.id(id).name(name).suite(Hooks.scenario.getSourceTagNames().toString());
    }

    @Given("^I am on the login screen")
    public void IAmOnTheLoginScreen()
    {
        support.loginScreen();
    }

    @Given("^I log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void ILogInWithUserAndPassword(String username, String password)
    {
        support.login(username, password);
    }

    @Then("^I am on the user home screen")
    public void IAmOnTheUserHomeScreen()
    {
        support.verifyUserHome();
    }

    @Then("^I am on the rating activity screen$")
    public void iAmOnTheRatingActivityScreen() throws Throwable {
        support.verifyRatingActivity();
    }

    @Then("^I am on the top cats activity screen$")
    public void iAmOnTheTopCatsActivityScreen() throws Throwable {
        support.verifyTopCats();
    }

    @When("^I tap the rating activitiy button$")
    public void iTapTheRatingActivitiyButton() throws Throwable {
        userhome.tapRatingActivityBtn().waitToLoad();
    }

    @When("^I tap the top cats activitiy button$")
    public void iTapTheTopCatsActivitiyButton() throws Throwable {
        userhome.tapTopCatsBtn().waitToLoad();
    }

    @When("^I tap the add cat image button$")
    public void iTapTheAddCatImageButton() throws Throwable {
        userhome.tapAddCatImageBtn().waitToLoad();
    }

    @Then("^I can add an image$")
    public void iCanAddAnImage() throws Throwable {
        support.verifyImageAdd();
    }

    @And("^I can remove an image$")
    public void iCanRemoveAnImage() throws Throwable {
        support.verifyImageDelete();
    }

    @Then("^login fails$")
    public void loginFails() throws Throwable {
        support.verifyInvalidLogin();
    }

    @And("^I tap a cat in the top cats list$")
    public void iTapACatInTheTopCatsList() throws Throwable {
        topCats.tapCatInGrid().waitToLoad();
    }

    @Then("^I am on the top cats details activity screen$")
    public void iAmOnTheTopCatsDetailsActivityScreen() throws Throwable {
        support.verifyTopCatDetails();
    }

    @When("^I tap a user cat image in the list$")
    public void iTapAUserCatImageInTheList() throws Throwable {
        userhome.tapTopLeftImg().waitToLoad();
    }

    @Then("^I am on the user cat details activity screen$")
    public void iAmOnTheUserCatDetailsActivityScreen() throws Throwable {
        support.verifyUserCatDetails();
    }
}
