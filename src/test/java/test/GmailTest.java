package test;

import helpers.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;

public class GmailTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeTest
    public static void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver",ConfProperties.getProperty("chromedriverPath"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.get(ConfProperties.getProperty("startPage"));

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void gmailTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.nextBtnClick();

        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        loginPage.loginBtnClick();

        profilePage.searchParamBtnClick();
        profilePage.inputSearch(ConfProperties.getProperty("theme"));
        profilePage.searchBtnClick();

        profilePage.newLetterBtnClick();
        profilePage.inputToField(ConfProperties.getProperty("login"));
        profilePage.topicFieldClick();
        profilePage.inputTopicField(ConfProperties.getProperty("theme"));
        profilePage.letterFieldClick();
        String letter = profilePage.getSearchRes();
        profilePage.inputLetter("Найдено писем с темой " + ConfProperties.getProperty("theme") + ": " + letter);
        profilePage.sendBtnClick();
    }

    @AfterTest
    public static void tearDown() {
        driver.quit();
    }

}
