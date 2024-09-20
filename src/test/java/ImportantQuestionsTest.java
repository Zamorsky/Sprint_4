//Класс для тестирования главной страницы, здесь код проверки выпадающего списка в разделе "Вопросы о Важном"

/*
Выпадающий список в разделе «Вопросы о важном». Тебе нужно проверить: когда нажимаешь на стрелочку, открывается соответствующий текст.
 */

import pageobject.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.assertEquals;
import static pageobject.constants.ExpectedAnswers.*;


@RunWith(Parameterized.class)
public class ImportantQuestionsTest extends BeforeAndAfterParent {

    private final By question;
    private final By answer;
    private final String expectedText;

    public ImportantQuestionsTest(By question, By answer, String expectedText) {

        this.question = question;
        this.answer = answer;
        this.expectedText = expectedText;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {MainPage.QUESTION_1, MainPage.ANSWER_1, EXPECTED_ANSWER_1},
                {MainPage.QUESTION_2, MainPage.ANSWER_2, EXPECTED_ANSWER_2},
                {MainPage.QUESTION_3, MainPage.ANSWER_3, EXPECTED_ANSWER_3},
                {MainPage.QUESTION_4, MainPage.ANSWER_4, EXPECTED_ANSWER_4},
                {MainPage.QUESTION_5, MainPage.ANSWER_5, EXPECTED_ANSWER_5},
                {MainPage.QUESTION_6, MainPage.ANSWER_6, EXPECTED_ANSWER_6},
                {MainPage.QUESTION_7, MainPage.ANSWER_7, EXPECTED_ANSWER_7},
                {MainPage.QUESTION_8, MainPage.ANSWER_8, EXPECTED_ANSWER_8},
        };
    }


    @Test
    public void importantQuestionsTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.waitForLoadMainPage();
        objMainPage.scrollDownToLastQuestion();

        driver.findElement(question).click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(answer));

        assertEquals(expectedText, driver.findElement(answer).getText());
    }


}
