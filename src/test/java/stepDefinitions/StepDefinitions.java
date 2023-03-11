package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import page.LandingPage;
import setup.Setup;

public class StepDefinitions extends Setup {
    @Given("user can visit portal")
    public void user_can_visit_portal() {
      driver.get("https://github.com/");
    }
    @When("user put valid input")
    public void user_put_valid_input() {
            LandingPage landingPage =new LandingPage(driver);
            landingPage.doSearch();
    }
    @Then("user can verify input")
    public void userCanVerifyInput() {
        LandingPage landingPage =new LandingPage(driver);
        landingPage.assetTitle();
    }



    @Then("User find facebook\\/create-react-app project as the first result")
    public void userFindFacebookCreateReactAppProjectAsTheFirstResult() {
        LandingPage landingPage =new LandingPage(driver);
        landingPage.assertResult();
    }

    @When("Go to landing page footer and click about button")
    public void goToLandingPageFooterAndClickAboutButton() {
        LandingPage landingPage =new LandingPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        landingPage.clickAboutBtn();


    }

    @Then("verify you are on about page")
    public void verifyYouAreOnAboutPage() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));
    }

}
