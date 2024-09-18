//Класс для тестирования главной страницы, здесь код проверки выпадающего списка в разделе "Вопросы о Важном"

/*
Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
 */

import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static PageObject.Constants.ExpectedAnswers.*;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class MainScenario_1 {

    private WebDriver driver;

    private final By question;
    private final By answer;
    private final String expectedText;

    public MainScenario_1(By question, By answer, String expectedText) {
        this.question = question;
        this.answer = answer;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] TestData() {
        return new Object[][]{
                {MainPage.question1, MainPage.answer1, expectedAnswer1},
                {MainPage.question2, MainPage.answer2, expectedAnswer2},
                {MainPage.question3, MainPage.answer3, expectedAnswer3},
                {MainPage.question4, MainPage.answer4, expectedAnswer4},
                {MainPage.question5, MainPage.answer5, expectedAnswer5},
                {MainPage.question6, MainPage.answer6, expectedAnswer6},
                {MainPage.question7, MainPage.answer7, expectedAnswer7},
                {MainPage.question8, MainPage.answer8, expectedAnswer8},
        };
    }

    @Before
    public void GetMainPage () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(); //"--no-sandbox", "--headless", "--disable-dev-shm-usage"
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkAnswerText() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPAge();
        objMainPage.scrollDownToLastQuestion();

        driver.findElement(question).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(answer));

        assertEquals(expectedText, driver.findElement(answer).getText());
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
