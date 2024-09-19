//Класс для POM главной страницы, здесь будут локаторы элементов и методы

package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.JavascriptExecutor;


public class MainPage {
    public static WebDriver driver;

    //локатор для кнопки заказать верхней
    public static By topOrderButton = By.className("Button_Button__ra12g");

    //локатор для кнопки заказать нижней
    public static By bottomOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор стрелочки вопроса 1
    public static By question1 = By.id("accordion__heading-0");

    //локатор стрелочки вопроса 2
    public static By question2 = By.id("accordion__heading-1");

    //локатор стрелочки вопроса 3
    public static By question3 = By.id("accordion__heading-2");

    //локатор стрелочки вопроса 4
    public static By question4 = By.id("accordion__heading-3");

    //локатор стрелочки вопроса 5
    public static By question5 = By.id("accordion__heading-4");

    //локатор стрелочки вопроса 6
    public static By question6 = By.id("accordion__heading-5");

    //локатор стрелочки вопроса 7
    public static By question7 = By.id("accordion__heading-6");

    //локатор стрелочки вопроса 8
    public static By question8 = By.id("accordion__heading-7");

    //локатор кнопки Яндекс
    public static By buttonYandex = By.xpath(".//*[@alt='Yandex']");

    //локатор кнопки самокат
    public static By buttonScooter = By.xpath(".//*[@alt='Scooter']");


    //локатор ответа на вопрос 1
    public static By answer1 = By.xpath("//*[@id=\"accordion__panel-0\"]");

    //локатор текста ответа на вопрос 2
    public static By answer2 = By.xpath("//*[@id=\"accordion__panel-1\"]");

    //локатор текста ответа на вопрос 3
    public static By answer3 = By.xpath("//*[@id=\"accordion__panel-2\"]");

    //локатор текста ответа на вопрос 4
    public static By answer4 = By.xpath("//*[@id=\"accordion__panel-3\"]");

    //локатор текста ответа на вопрос 5
    public static By answer5 = By.xpath("//*[@id=\"accordion__panel-4\"]");

    //локатор текста ответа на вопрос 6
    public static By answer6 = By.xpath("//*[@id=\"accordion__panel-5\"]");

    //локатор текста ответа на вопрос 7
    public static By answer7 = By.xpath("//*[@id=\"accordion__panel-6\"]");

    //локатор текста ответа на вопрос 8
    public static By answer8 = By.xpath("//*[@id=\"accordion__panel-7\"]");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для ожидания загрузки главной страницы
    public static void waitForLoadMainPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(topOrderButton)));
    }

    //метод скролла вниз для отображения последнего вопроса
    public void scrollDownToLastQuestion() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(question8));
    }

    //метод скролла вниз для отображения нижней кнопки заказать
    public void scrollDownToBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));
    }

    //метод нажатия на верхнюю кнопку заказать
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    //метод нажатия на нижнюю кнопку заказать
    public void clickBottomOrderButton() {
        scrollDownToBottomOrderButton();
        driver.findElement(bottomOrderButton).click();
    }

    public void clickOrderButton(By choisedOrderButton){
        if (choisedOrderButton == topOrderButton){
            clickTopOrderButton();
        }
        else
        {
            clickBottomOrderButton();
        }

    }
    public static void clickButtonScooter() {
        driver.findElement(buttonScooter).click();
    }

    public void clickButtonYandex() {
        driver.findElement(buttonYandex).click();
    }

}