package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waiters.clickabilityWait;
import static helpers.Waiters.visabilityWait;

public class ProfilePage {
    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#aso_search_form_anchor button[aria-label = \"Расширенный поиск\"]")
    private WebElement searchParamBtn;

    @FindBy(css = "div.ZF-Av div:nth-child(3) span input")
    private WebElement searchField;

    @FindBy(css = "div.ZF-Av [aria-label = \"Поиск почты\"]")
    private WebElement searchBtn;

    @FindBy(css = "div.nM div[role=\"button\"]") //
    private WebElement newLetterBtn;

    @FindBy(css = "div[role=\"region\"] textarea[aria-label = \"Кому\"]")
    private WebElement toField;

    @FindBy(css = "div[role=\"region\"] input[aria-label = \"Тема\"]")
    private WebElement topicField;

    @FindBy(css = "div[role=\"region\"] div[aria-label = \"Тело письма\"]")
    private WebElement letterField;

    @FindBy(css = "div[role=\"region\"] div[aria-label *= \"Отправить\"]")
    private WebElement sendBtn;

    public void searchParamBtnClick() {
        clickabilityWait(this.driver, 10, searchParamBtn);
        searchParamBtn.click();
    }

    public void inputSearch(String search) {
        clickabilityWait(this.driver, 5, searchField);
        searchField.sendKeys(search);
    }

    public void searchBtnClick() {
        clickabilityWait(this.driver, 5, searchBtn);
        searchBtn.click();
    }

    public String getSearchRes() {
        int count = (driver.findElements(By.cssSelector("div[role=\"main\"] div.Cp table tr")).size());
        return String.valueOf(count);
    }

    public void newLetterBtnClick() {
        newLetterBtn.click();
    }

    public void inputToField(String recipient) {
        clickabilityWait(this.driver, 5, toField);
        toField.sendKeys(recipient + Keys.ENTER);
    }

    public void topicFieldClick() {
        topicField.click();
    }

    public void inputTopicField(String topic) {
        topicField.sendKeys(topic);
    }

    public void letterFieldClick() {
        letterField.click();
    }

    public void inputLetter(String letter) {
        letterField.sendKeys(letter);
    }

    public void sendBtnClick() {
        sendBtn.click();
        visabilityWait(this.driver, 10, "span span.bAq");
    }

}

