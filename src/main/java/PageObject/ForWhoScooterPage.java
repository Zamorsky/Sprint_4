//Класс для POM страницы на которую мы попадаем после нажатия на кнопку "Заказать", здесь будут локаторы элементов и методы

package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;


public class ForWhoScooterPage {
    private static WebDriver driver;

    //локатор поля имя
    private static final By Name = By.xpath(".//input[@placeholder='* Имя']");
    //локатор поля фамилия
    private static final By Surname = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор поля адрес
    private static final By Address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор поля станция метро
    private static final By Metrostation = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор поля телефон
    private static final By telephone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки далее
    private static final By buttonNext = By.xpath(".//button[text()='Далее']");
    //локатор кнопки Яндекс
    private static final By buttonYandex = By.xpath(".//*[@alt='Yandex']");
    //локатор кнопки самокат
    private static final By buttonScooter = By.xpath(".//*[@alt='Scooter']");



    public ForWhoScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод дождаться загрузки поля Имя
    public static void waitForLoadForWhoScooterPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(Name)));
    }

    //метод ввода имя
    public static void inputName(String newName) {
        driver.findElement(Name).sendKeys(newName);
    }

    //метод ввода фамилия
    public static void inputSurname(String newSurname) {
        driver.findElement(Surname).sendKeys(newSurname);
    }

    //метод ввода адрес
    public static void inputAddress(String newAddress) {
        driver.findElement(Address).sendKeys(newAddress);
    }

    //метод выбрать станцию метро
    public static void inputMetrostation(String newMetrostation) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(Metrostation));
        driver.findElement(Metrostation).click();
        driver.findElement(By.xpath("//*[contains(text(), '" + newMetrostation + "')]")).click();
    }

    //метод ввода телефона
    public static void inputTelephone(String newTelephone) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(telephone));
        driver.findElement(telephone).sendKeys(newTelephone);
    }

    //метод нажатия на кнопку далее
    public static void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public static void clickButtonScooter() {
        driver.findElement(buttonScooter).click();
    }

    public void clickButtonYandex() {
        driver.findElement(buttonYandex).click();
    }

}

