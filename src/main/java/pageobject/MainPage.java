package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class MainPage {
    private WebDriver driver;

    // Локатор для верхней кнопки "Заказать"
    public static final By TOP_ORDER_BUTTON = By.className("Button_Button__ra12g");

    // Локатор для нижней кнопки "Заказать"
    public static final By BOTTOM_ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локаторы для вопросов
    public static final By QUESTION_1 = By.id("accordion__heading-0");
    public static final By QUESTION_2 = By.id("accordion__heading-1");
    public static final By QUESTION_3 = By.id("accordion__heading-2");
    public static final By QUESTION_4 = By.id("accordion__heading-3");
    public static final By QUESTION_5 = By.id("accordion__heading-4");
    public static final By QUESTION_6 = By.id("accordion__heading-5");
    public static final By QUESTION_7 = By.id("accordion__heading-6");
    public static final By QUESTION_8 = By.id("accordion__heading-7");

    // Локатор кнопки Яндекс
    public static final By BUTTON_YANDEX = By.xpath(".//*[@alt='Yandex']");

    // Локатор кнопки самокат
    public static final By BUTTON_SCOOTER = By.xpath(".//*[@alt='Scooter']");

    // Локаторы для ответов на вопросы
    public static final By ANSWER_1 = By.xpath("//*[@id=\"accordion__panel-0\"]");
    public static final By ANSWER_2 = By.xpath("//*[@id=\"accordion__panel-1\"]");
    public static final By ANSWER_3 = By.xpath("//*[@id=\"accordion__panel-2\"]");
    public static final By ANSWER_4 = By.xpath("//*[@id=\"accordion__panel-3\"]");
    public static final By ANSWER_5 = By.xpath("//*[@id=\"accordion__panel-4\"]");
    public static final By ANSWER_6 = By.xpath("//*[@id=\"accordion__panel-5\"]");
    public static final By ANSWER_7 = By.xpath("//*[@id=\"accordion__panel-6\"]");
    public static final By ANSWER_8 = By.xpath("//*[@id=\"accordion__panel-7\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для ожидания загрузки главной страницы
    public void waitForLoadMainPage() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(TOP_ORDER_BUTTON)));
    }

    // Метод скролла вниз для отображения последнего вопроса
    public void scrollDownToLastQuestion() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(QUESTION_8));
    }

    // Метод скролла вниз для отображения нижней кнопки "Заказать"
    public void scrollDownToBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(BOTTOM_ORDER_BUTTON));
    }

    // Метод нажатия на верхнюю кнопку "Заказать"
    public void clickTopOrderButton() {
        driver.findElement(TOP_ORDER_BUTTON).click();
    }

    // Метод нажатия на нижнюю кнопку "Заказать"
    public void clickBottomOrderButton() {
        scrollDownToBottomOrderButton();
        driver.findElement(BOTTOM_ORDER_BUTTON).click();
    }

    // Метод нажатия на выбранную кнопку "Заказать"
    public void clickOrderButton(By chosenOrderButton) {
        if (chosenOrderButton.equals(TOP_ORDER_BUTTON)) {
            clickTopOrderButton();
        } else {
            clickBottomOrderButton();
        }
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
