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

/**
 * Тестовый класс для проверки работы UI ресурса gmail.com
 */
public class GmailTest {
    /**
     * Объект для работы со страницей авторизации ресурса
     */
    public static LoginPage loginPage;

    /**
     * Объект для работы со страницей профиля пользователя ресурса
     */
    public static ProfilePage profilePage;

    /**
     * Объект для работы с веб-драйвером
     */
    public static WebDriver driver;

    /**
     * Метод инициализации экземпляра веб-драйвера
     * Создает новый экземпляр веб-драйвера, осуществляет запуск соответствующего драйвера, инициализирует объекты для работы
     * со страницами ресурса, осуществляет открытие стартовой страницы ресурса, инициализирует неявные ожидания для созданного
     * экземпляра драйвера
     */
    @BeforeTest
    public static void setup() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriverPath"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.get(ConfProperties.getProperty("startPage"));

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    /**
     * Метод, содержащий реализацию теста
     * Осуществляет авторизацию пользователя: ввод логина и пароля, нажатие кнопок для продолжения/завершения авторизации
     * После успешного завершения авторизации открывает расширенные параметра поиска в почте, заполняет поле "Тема" и запускает
     * поиск, обрабатывает результаты поиска
     * Затем выпоняет нажатие на кнопку создания нового письма, заполняет поля "Кому" и "Тема" на панели создания нового электронного
     * письма, заполняет поле текста письма с использованием результатов поиска,сосуществляет отправку письма
     */
    @Test
    public void gmailTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.nextBtnClick();

        loginPage.inputPasswd(ConfProperties.getProperty("passwd"));
        loginPage.loginBtnClick();

        profilePage.searchParamBtnClick();
        profilePage.inputSearch(ConfProperties.getProperty("theme"));
        profilePage.searchBtnClick();
        String letter = profilePage.getSearchRes();

        profilePage.newLetterBtnClick();
        profilePage.toFieldInput(ConfProperties.getProperty("login"));
        profilePage.topicFieldClick();
        profilePage.topicFieldInput(ConfProperties.getProperty("theme"));
        profilePage.letterFieldClick();

        profilePage.letterInput("Найдено писем с темой " + ConfProperties.getProperty("theme") + ": " + letter);
        profilePage.sendBtnClick();
    }

    /**
     * Метод, завершающий работу активного экземпляра веб-драйвера
     */
    @AfterTest
    public static void tearDown() {
        driver.quit();
    }
}