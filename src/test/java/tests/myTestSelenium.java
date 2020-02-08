package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Login;
import pages.StartPage;

public class myTestSelenium {
    //how to create correct profile https://stackoverflow.com/questions/50635087/how-to-open-a-chrome-profile-through-user-data-dir-argument-of-selenium
// profil will works only when all instances of chrome will be closed
    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional. If not specified, WebDriver searches the PATH for chromedriver.
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kamil\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions chOption = new ChromeOptions();
//        chOption.addArguments("user-data-dir=C:\\Users\\Kamil\\AppData\\Local\\Google\\Chrome\\User Data");
//        chOption.addArguments("profile-directory=Profile 3");
//        chOption.addArguments("--disable-extensions");
        chOption.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chOption);
        //    driver.manage().window().maximize();
        //    JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.get("https://github.com/");
        Thread.sleep(5000);  // Let the user actually see something!
        WebElement logInLink = driver.findElement(By.linkText("Sign in"));
        logInLink.click();
//        WebElement button = driver.findElement(By.className("ws__skipButton"));
//        button.click();
//
        WebElement searchBox = driver.findElement(By.name("login"));
        searchBox.sendKeys("gitkamil");
        searchBox.submit();

        WebElement passwordBox = driver.findElement(By.name("password"));
        passwordBox.sendKeys("Ktoscos123@");
        passwordBox.submit();
//
//
//        driver.quit();
    }

    //https://www.pluralsight.com/guides/getting-started-with-page-object-pattern-for-your-selenium-tests
    //https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html

    @Test
    public void testGoogleSearch2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kamil\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions chOption = new ChromeOptions();
//        chOption.addArguments("user-data-dir=C:\\Users\\Kamil\\AppData\\Local\\Google\\Chrome\\User Data");
//        chOption.addArguments("profile-directory=Profile 3");
//        chOption.addArguments("--disable-extensions");
        chOption.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chOption);
        //    driver.manage().window().maximize();
        //    JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.get("https://github.com/");
        StartPage startPage = new StartPage(driver);
        Login loginPage = startPage.submit();

        loginPage.setUserName("gitKamil");
        loginPage.setPassword("Ktoscos123@");
        loginPage.submit();

    }
}
