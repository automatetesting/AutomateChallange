package se.ff.cc.stepDef;


import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import se.ff.cc.pages.ValtechPage;
import se.ff.cc.webDriver.Driver;

public class ValtechSteps {

    @When("^I am on the Valtech home page and login using \"([^\"]*)\"$")
    public void iAmOnTheValtechHomePageAndLoginUsing(String browser) throws Throwable {
        ValtechPage login = new ValtechPage(Driver.getCurrentDriver(browser));
        login.navigateToHomePage();
    }

    @Then("^The recent blog section is displayed$")
    public void theRecentBlogSectionIsDisplayed() throws Throwable {
        ValtechPage checkext = new ValtechPage(Driver.webdriver);
        checkext.AssertBlog();

    }

    @When("^I click on the \"([^\"]*)\"$")
    public void iClickOnThe(String page) throws Throwable {
        ValtechPage selectabout = new ValtechPage(Driver.webdriver);
        selectabout.ClickAbout();

    }

    @Then("^The \"([^\"]*)\" is dispalyed$")
    public void theIsDispalyed(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
