package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class Login {

    WebDriver driver;

    @FindBy(name = "login")
    private WebElement searchBox;

    @FindBy(name = "password")
    private WebElement passwordBox;


    public Login(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        assertTrue(searchBox.isDisplayed());
    }

    public void setUserName(String userName) {
        searchBox.sendKeys(userName);
    }

    public void setPassword(String password) {
        passwordBox.sendKeys(password);
    }
    public void submit()
    {
        passwordBox.submit();
    }
}
