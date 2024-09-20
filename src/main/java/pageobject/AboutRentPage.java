package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutRentPage {
    private WebDriver driver;

    // Локатор поля "Когда привезти самокат"
    private static final By DATE_OF_SCOOTER_DELIVERY = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Локатор срока аренды
    private static final By RENT_TIME = By.xpath("//*[contains(text(), 'Срок аренды')]");
    // Локатор поля "Комментарий для курьера"
    private static final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Локатор кнопки "Заказать"
    private static final By BUTTON_ORDER = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Локатор кнопки "Посмотреть статус"
    private static final By BUTTON_WATCH_STATUS = By.xpath("//*[contains(text(), 'Посмотреть статус')]");
    // Локатор текста об успешном заказе
    private static final By TEXT_OF_SUCCESS_ORDER = By.xpath("//*[contains(text(), 'Заказ оформлен')]");
    // Локатор кнопки Яндекс
    private static final By BUTTON_YANDEX = By.xpath(".//*[@alt='Yandex']");
    // Локатор кнопки самоката
    private static final By BUTTON_SCOOTER = By.xpath(".//*[@alt='Scooter']");

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы "Про аренду"
    public void waitForLoadAboutRentPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Про аренду')]"))));
    }

    // Метод ввода даты привоза самоката
    public void inputDateOfScooterDelivery(String newDateOfScooterDelivery) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(DATE_OF_SCOOTER_DELIVERY));
        driver.findElement(DATE_OF_SCOOTER_DELIVERY).click();
        driver.findElement(DATE_OF_SCOOTER_DELIVERY).sendKeys(newDateOfScooterDelivery);
        driver.findElement(By.xpath("//*[contains(text(), 'Про аренду')]")).click();
    }

    // Метод ввода времени срока аренды
    public void inputRentTime(String newRentTime) {
        driver.findElement(RENT_TIME).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + newRentTime + "')]")).click();
    }

    // Метод для ввода цвета самоката
    public void inputColorOfScooter(String newColorOfScooter) {
        driver.findElement(By.xpath("//*[contains(text(), '" + newColorOfScooter + "')]")).click();
    }

    // Метод ввода комментария для курьера
    public void inputComment(String newComment) {
        driver.findElement(COMMENT).click();
        driver.findElement(COMMENT).clear();
        driver.findElement(COMMENT).sendKeys(newComment);
    }

    // Метод нажатия на кнопку "Заказать"
    public void clickButtonOrder() {
        driver.findElement(BUTTON_ORDER).click();
    }

    // Метод подтверждения желания оформить заказ
    public void clickButtonAccept() {
        driver.findElement(By.xpath("//*[contains(text(), 'Да')]")).click();
    }

    // Метод для получения текста об успешном заказе
    public String getTextOfSuccessOrder() {
        return driver.findElement(TEXT_OF_SUCCESS_ORDER).getText();
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
