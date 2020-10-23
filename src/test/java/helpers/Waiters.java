package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс для работы с ожиданиями драйвера
 * Содержит метод для ожидания кликабельности (активности) элемента на веб-странице и метод для ожидания появления
 * (видимости) элемента на странице
 */
public class Waiters {
    public WebDriver driver;

    /**
     * Метод для ожидания кликабельности (активности) элемента на веб-странице
     *
     * @param driver - активный экземпляр веб-драйвера
     * @param time   - время ожидания в секундах
     * @param element     - элемент на странице, кликабельность которого ожидается
     */
    public static void clickabilityWait(WebDriver driver, int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Метод для ожидания появления (видимости) элемента на веб-странице
     *
     * @param driver  - активный экземпляр веб-драйвера
     * @param time    - время ожидания в секундах
     * @param locator - локатор элемента на странице, видимость которого ожидается
     */
    public static void visabilityWait(WebDriver driver, int time, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

}

