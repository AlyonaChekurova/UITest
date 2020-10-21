package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.clickabilityWait;


public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#identifierId")
    private WebElement loginField;

    @FindBy (css = "#identifierNext button")
    private WebElement nextBtn;

    @FindBy(css = "#password input")
    private WebElement passwdField;

    @FindBy (css = "#passwordNext button")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public void inputPasswd(String passwd) {
        clickabilityWait(this.driver, 5, passwdField);
        passwdField.sendKeys(passwd);
    }

    public void loginBtnClick() {
        loginBtn.click();
    }
}
