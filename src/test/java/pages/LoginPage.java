package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.clickabilityWait;

/**
 * Класс для работы со страницей авторизации
 * Идентифицирует поля для ввода логина и пароля, кнопки для продолжения/завершения авторизации
 * Содержит методы для ввода логина и пароля, нажатия соответствующих кнопок продолжения/завершения авторизации
 */
public class LoginPage {
    public WebDriver driver;

    /**
     * Конструктор класса
     * Инициализирует активный экземпляр веб-драйвера и элементы на веб-странице
     *
     * @param driver - активный экземпляр веб-драйвера
     */
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Идентификация элементов веб-страницы по соответствующим css-селекторам
     */

    /**
     * Поле для ввода логина
     */
    @FindBy(css = "#identifierId")
    private WebElement loginField;

    /**
     * Кнопка продолжения авторизации
     */
    @FindBy(css = "#identifierNext button")
    private WebElement nextBtn;

    /**
     * Поле для ввода пароля
     */
    @FindBy(css = "#password input")
    private WebElement passwdField;

    /**
     * Кнопка завершения(подтверждения) авторизации
     */
    @FindBy(css = "#passwordNext button")
    private WebElement loginBtn;

    /**
     * Метод ввода логина в соответствующее поле ввода
     *
     * @param login - логин пользователя для ввода
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    /**
     * Метод нажатия на кнопку продолжения авторизации
     */
    public void nextBtnClick() {
        nextBtn.click();
    }

    /**
     * Метод ввода пароля в соответствующее поле ввода
     *
     * @param passwd - пароль пользователя для ввода
     */
    public void inputPasswd(String passwd) {
        clickabilityWait(this.driver, 5, passwdField);
        passwdField.sendKeys(passwd);
    }

    /**
     * Метод нажатия на кнопку завершения(подтверждения) авторизации
     */
    public void loginBtnClick() {
        loginBtn.click();
    }
}
