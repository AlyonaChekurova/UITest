package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.clickabilityWait;
import static helpers.Waiters.visabilityWait;

/**
 * Класс для работы со страницей профиля пользователя после успешной авторизации
 * Содержит методы для открытия панели расширенного поиска, заполнения поля "Тема" на панели поиска, нажатия кнопки "Поиск",
 * получения результатов поиска, нажатия кнопки "Написать", заполнения полей "Кому" и "Тема" при написании нового электронного письма,
 * а также для ввода текста электоронного письма и нажатия кнопки "Отправить"
 */
public class ProfilePage {
    public WebDriver driver;

    /**
     * Конструктор класса
     * Инициализирует активный экземпляр веб-драйвера и элементы на веб-странице
     *
     * @param driver - активный экземпляр веб-драйвера
     */
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * Идентификация элементов веб-страницы по соответствующим css-селекторам и xpath-локаторам
     */
    /**
     * Кнопка для открытия параметров расширенного поиска
     */
    @FindBy(css = "#aso_search_form_anchor button[aria-label = \"Расширенный поиск\"]")
    private WebElement searchParamBtn;

    /**
     * Поле для ввода темы искомого письма
     */
    @FindBy(xpath = "//*[contains(text(), 'Тема')]/parent::node()/parent::node()/span/input")
    private WebElement themeField;

    /**
     * Кнопка "Поиск"
     */
    @FindBy(css = "div[aria-label = \"Поиск почты\"]")
    private WebElement searchBtn;

    /**
     * Кнопка "Написать" для создания нового электронного письма
     */
    @FindBy(xpath = "//*[contains(text(), \"Написать\")]")
    private WebElement newLetterBtn;

    /**
     * Поле "Кому" на панели создания нового электронного письма
     */
    @FindBy(css = "div[role=\"region\"] textarea[aria-label = \"Кому\"]")
    private WebElement toField;

    /**
     * Поле "Тема" на панели создания нового электронного письма
     */
    @FindBy(css = "div[role=\"region\"] input[aria-label = \"Тема\"]")
    private WebElement topicField;

    /**
     * Поле для ввода текста письма на панели создания нового электронного письма
     */
    @FindBy(css = "div[role=\"region\"] div[aria-label = \"Тело письма\"]")
    private WebElement letterField;

    /**
     * Кнопка "Отправить" на панели создания нового электронного письма
     */
    @FindBy(css = "div[role=\"region\"] div[aria-label *= \"Отправить\"]")
    private WebElement sendBtn;

    /**
     * Метод нажатия на кнопку открытия расширенных параметров поиска
     * Ожидает кликабельности соответствующего элемента страницы и выполняет нажатие
     */
    public void searchParamBtnClick() {
        clickabilityWait(this.driver, 10, searchParamBtn);
        searchParamBtn.click();
    }

    /**
     * Метод для ввода параметра поиска
     * Ожидает кликабельности соответсвующего поля ввода, переводит в него курсор и заполняет текстом
     *
     * @param search - текст параметра поиска
     */
    public void inputSearch(String search) {
        clickabilityWait(this.driver, 5, themeField);
        themeField.sendKeys(search);
    }

    /**
     * Метод нажатия на кнопку поиска
     * Ожидает кликабельности соответствующего элемента страницы и выполняет нажатие
     */
    public void searchBtnClick() {
        clickabilityWait(this.driver, 5, searchBtn);
        searchBtn.click();
    }

    /**
     * Метод получения результатов поиска
     * Подсчитывает количество найденных писем по заданному параметру поиска
     *
     * @return количество найденных писем по заданному параметру поиска
     */
    public String getSearchRes() {
        int count = (driver.findElements(By.cssSelector("div[role=\"main\"] div table tr")).size());
        return String.valueOf(count);
    }

    /**
     * Метод нажатия на кнопку создания нового электронного письма
     * Ожидает кликабельности соответствующего элемента страницы и выполняет нажатие
     */
    public void newLetterBtnClick() {
        newLetterBtn.click();
    }

    /**
     * Метод для заполнения поля "Кому" на панели создания нового электронного письма
     * Ожидает кликабельности соответствующего поля ввода и заполняет его текстом
     *
     * @param recipient - электронный адрес получателя письма
     */
    public void toFieldInput(String recipient) {
        clickabilityWait(this.driver, 5, toField);
        toField.sendKeys(recipient + Keys.ENTER);
    }

    /**
     * Метод перевода курсора в поле ввода темы письма
     * Выполняет нажатие в соответствующем поле ввода
     */
    public void topicFieldClick() {
        topicField.click();
    }

    /**
     * Метод для заполнения поля "Тема" на панели создания нового электронного письма
     * Ожидает кликабельности соответствующего поля ввода и заполняет его текстом
     *
     * @param topic - тема письма
     */
    public void topicFieldInput(String topic) {
        topicField.sendKeys(topic);
    }

    /**
     * Метод перевода курсора в поле ввода темы письма
     * Выполняет нажатие в соответствующем поле ввода
     */
    public void letterFieldClick() {
        letterField.click();
    }

    /**
     * Метод ввода текста письма
     * Заполняет текстом соответствующее поле ввода
     *
     * @param letter - текст письма
     */
    public void letterInput(String letter) {
        letterField.sendKeys(letter);
    }

    /**
     * Метод нажатия кнопки "Отправить" на панели создания нового электронного письма
     * Выполняет нажатие и ожидает появления сообщения об успешной отправке
     */
    public void sendBtnClick() {
        sendBtn.click();
        visabilityWait(this.driver, 10, "//*[contains(text(), 'Письмо отправлено')]");
    }

}

