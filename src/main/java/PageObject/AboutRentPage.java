//Класс для POM страницы на которую мы попадаем после нажатия на кнопку заказать, здесь будут локаторы элементов и методы


package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AboutRentPage {
    private static WebDriver driver;

    //локатор поля когда привезти самокат
    private static final By DateOfScooterDelivery = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор срока аренды
    private static final By rentTime = By.xpath("//*[contains(text(), 'Срок аренды')]");
    //локатор поля "Комментарий для курьера"
    private static final By Comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор кнопки заказать
    private static final By buttonOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //локатор кнопки посмотреть заказ
    private static final By buttonWatchStatus = By.xpath("//*[contains(text(), 'Посмотреть статус')]");

    //локатор текста об успешном заказе
    private static final By TextOfSuccessOrder = By.xpath("//*[contains(text(), 'Заказ оформлен')]");

    //локатор кнопки Яндекс
    private static final By buttonYandex = By.xpath(".//*[@alt='Yandex']");

    //локатор кнопки самокат
    private static final By buttonScooter = By.xpath(".//*[@alt='Scooter']");



    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }


    //метод ожидания загрузки страницы "про аренду"
    public void waitForLoadAboutRentPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(text(), 'Про аренду')]"))));
    }

    //метод ввода даты привоза самоката
    public void inputDateOfScooterDelivery(String newDateOfScooterDelivery) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(DateOfScooterDelivery));
        driver.findElement(DateOfScooterDelivery).click();
        driver.findElement(DateOfScooterDelivery).sendKeys(newDateOfScooterDelivery);
        driver.findElement(By.xpath("//*[contains(text(), 'Про аренду')]")).click();
    }

    //метод ввода времени срока аренды
    public void inputRentTime(String newRentTime) {
        driver.findElement(rentTime).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + newRentTime + "')]")).click();
    }

    //метод для ввода цвета самоката
    public void inputColorOfScooter(String newColorOfScooter) {
        driver.findElement(By.xpath("//*[contains(text(), '" + newColorOfScooter + "')]")).click();
    }

    //метод ввода комментария для курьера
    public void inputComment(String newComment) {
        driver.findElement(Comment).click();
        driver.findElement(Comment).clear();
        driver.findElement(Comment).sendKeys(newComment);
    }

    //метод нажатия на кнопку заказать
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    //метод подтверждения желания оформить заказ
    public void clickButtonAccept() {
        driver.findElement(By.xpath("//*[contains(text(), 'Да')]")).click();
    }



    //метод для получения текста Заказ оформлен
    public String getTextOfSuccessOrder() {
        return driver.findElement(TextOfSuccessOrder).getText();
    }

    public void clickButtonScooter() {
        driver.findElement(buttonScooter).click();
    }

    public void clickButtonYandex() {
        driver.findElement(buttonYandex).click();
    }

}