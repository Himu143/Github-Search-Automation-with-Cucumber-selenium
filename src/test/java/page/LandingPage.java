package page;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage {
    @FindBy(name = "q")
    WebElement txtSearch;
    @FindBy(tagName = "h1")
    WebElement lblDashboard;
    @FindBy(tagName = "h3")
    WebElement txtResult;

    @FindBy(tagName = "h3")
    List<WebElement> txtSearchResult;
    @FindBy(className = "mb-1")
    List<WebElement> txtFirstSearchResult;

    @FindBy(className = "Link--secondary")
    List<WebElement> btnAbout;
    @FindBy(tagName = "f2-mktg")
    WebElement verifyAboutPage;

    public LandingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doSearch(){
        txtSearch.sendKeys("create-react-app");
        txtSearch.sendKeys(Keys.ENTER);
    }

    public void assetTitle(){
        Assert.assertEquals(lblDashboard.getText(),"Let’s build from here");
    }

    public void assertResult(){
        Assert.assertEquals(txtFirstSearchResult.get(1).getText(),"Set up a modern web app by running one command.");
    }

    public void clickAboutBtn(){
        btnAbout.get(45).click();
    }



}
