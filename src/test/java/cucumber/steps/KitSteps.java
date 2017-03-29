package cucumber.steps;

import core.TestInfo;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.support.Hooks;
import cucumber.support.Support;

import java.io.InputStream;

/**
 * Created by Colin on 3/29/2017.
 */
public class KitSteps {
    private Support kitTest = new Support();
    TestInfo testinfo = new TestInfo();

    @Given("^test info id \"([^\"]*)\" and name \"([^\"]*)\"$")
    public void testInfoIdAndName(String id, String name) throws Throwable {
        testinfo.id(id).name(name).suite(Hooks.scenario.getSourceTagNames().toString());
    }

    @Given("^I am on the login screen")
    public void IAmOnTheLoginScreen()
    {
        kitTest.loginScreen();
    }

    @Given("^I log in with user \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void ILogInWithUserAndPassword(String username, String password)
    {
        kitTest.login(username, password);
    }

    @Then("^I am on the user home screen")
    public void IAmOnTheUserHomeScreen()
    {
        kitTest.verifyUserHome();
    }

    @Then("^I am on the rating activity screen$")
    public void iAmOnTheRatingActivityScreen() throws Throwable {
        kitTest.verifyRatingActivity();
    }

    @Then("^I am on the top cats activity screen$")
    public void iAmOnTheTopCatsActivityScreen() throws Throwable {
        kitTest.verifyTopCats();
    }

    @Then("^I can add and remove an image$")
    public void iCanAddAndRemoveAnImage() throws Throwable {
        kitTest.verifyImageAdd();
        kitTest.verifyImageDelete();
    }
}
