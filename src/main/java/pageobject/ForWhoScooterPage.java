package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForWhoScooterPage {
    private WebDriver driver;

    // Локатор поля имя
    private static final By NAME = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор поля фамилия
    private static final By SURNAME = By.xpath(".//input[@placeholder='* Фамилия']");
    // Локатор поля адрес
    private static final By ADDRESS = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор поля станция метро
    private static final By METROSTATION = By.xpath(".//input[@placeholder='* Станция метро']");
    // Локатор поля телефон
    private static final By TELEPHONE = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор кнопки "Далее"
    private static final By BUTTON_NEXT = By.xpath(".//button[text()='Далее']");
    // Локатор кнопки Яндекс
    private static final By BUTTON_YANDEX = By.xpath(".//*[@alt='Yandex']");
    // Локатор кнопки самокат
    private static final By BUTTON_SCOOTER = By.xpath(".//*[@alt='Scooter']");

    public ForWhoScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод дождаться загрузки поля "Имя"
    public void waitForLoadForWhoScooterPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(NAME)));
    }

    // Метод ввода имени
    public void inputName(String newName) {
        driver.findElement(NAME).sendKeys(newName);
    }

    // Метод ввода фамилии
    public void inputSurname(String newSurname) {
        driver.findElement(SURNAME).sendKeys(newSurname);
    }

    // Метод ввода адреса
    public void inputAddress(String newAddress) {
        driver.findElement(ADDRESS).sendKeys(newAddress);
    }

    // Метод выбора станции метро
    public void inputMetrostation(String newMetrostation) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(METROSTATION));
        driver.findElement(METROSTATION).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + newMetrostation + "')]")).click();
    }

    // Метод ввода телефона
    public void inputTelephone(String newTelephone) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(TELEPHONE));
        driver.findElement(TELEPHONE).sendKeys(newTelephone);
    }

    // Метод нажатия на кнопку "Далее"
    public void clickButtonNext() {
        driver.findElement(BUTTON_NEXT).click();
    }

    // Метод нажатия на кнопку "Самокат"
    public void clickButtonScooter() {
        driver.findElement(BUTTON_SCOOTER).click();
    }

    // Метод нажатия на кнопку "Яндекс"
    public void clickButtonYandex() {
        driver.findElement(BUTTON_YANDEX).click();
    }
}
