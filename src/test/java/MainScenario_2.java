//Класс для проверки полного позитивного флоу заказа самоката

/*
Заказ самоката. Нужно проверить весь флоу позитивного сценария с двумя наборами данных. Проверить точки входа в сценарий, их две: кнопка «Заказать» вверху страницы и внизу.
Из чего состоит позитивный сценарий:
Нажать кнопку «Заказать». На странице две кнопки заказа.
Заполнить форму заказа.
Проверить, что появилось всплывающее окно с сообщением об успешном создании заказа.
 */

import PageObject.AboutRentPage;
import PageObject.Constants.URLs;
import PageObject.ForWhoScooterPage;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

import PageObject.MainPage;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.concurrent.TimeUnit;



@RunWith(Parameterized.class)
public class MainScenario_2 {
    private WebDriver driver;

    private final By choisedOrderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metrostation;
    private final String telephone;
    private final String dateOfScooterDelivery;
    private final String rentTime;
    private final String colorOfScooter;
    private final String inputComment;
    private final String expectedTextInFinalPopup;

    public MainScenario_2(By choisedOrderButton, String name, String surname, String address, String metrostation,
                          String telephone, String dateOfScooterDelivery, String rentTime, String colorOfScooter,
                          String inputComment, String expectedTextInFinalPopup) {
        this.choisedOrderButton = choisedOrderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metrostation = metrostation;
        this.telephone = telephone;
        this.dateOfScooterDelivery = dateOfScooterDelivery;
        this.rentTime = rentTime;
        this.colorOfScooter = colorOfScooter;
        this.inputComment = inputComment;
        this.expectedTextInFinalPopup = expectedTextInFinalPopup;
    }

    @Parameterized.Parameters
    public static Object[][] TestData() {
        return new Object[][]{
                {MainPage.topOrderButton, "Антон", "Заморский", "ул. Тестервская34 дом 0.123, кв 1,3,4", "Перово", "+79265949591", "22.09.2024", "сутки","чёрный жемчуг","дам хорошие чаевые","Заказ оформлен"},
                {MainPage.bottomOrderButton, "Заморский", "Антон", "ул. Тестеровщинская 3.1423, 0.123, кв 000", "Выхино", "+79265843618", "17.09.2024", "семеро суток","серая безысходность","чаевых не дам","Заказ оформлен"}
        };
    }



    @Before
     public void getMainPage() {
         ChromeOptions options = new ChromeOptions();
         options.addArguments(); //"--no-sandbox", "--headless", "--disable-dev-shm-usage"
         driver = new ChromeDriver(options);
         // переход на страницу тестового приложения
         driver.get(URLs.URL_QA_SCOOTER);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


/*
     //скрытый комментарий для проверки на Firefox
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
*/

    @Test
    public void MainScenario_2_test() {

        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        objMainPage.clickOrderButton(choisedOrderButton);

        objForWhoScooterPage.inputName(name);
        objForWhoScooterPage.inputSurname(surname);
        objForWhoScooterPage.inputAddress(address);
        objForWhoScooterPage.inputTelephone(telephone);
        objForWhoScooterPage.inputMetrostation(metrostation);
        objForWhoScooterPage.clickButtonNext();

        objAboutRentPage.waitForLoadAboutRentPage();
        objAboutRentPage.inputDateOfScooterDelivery(dateOfScooterDelivery);
        objAboutRentPage.inputRentTime(rentTime);
        objAboutRentPage.inputColorOfScooter(colorOfScooter);
        objAboutRentPage.inputComment(inputComment);
        objAboutRentPage.clickButtonOrder();
        objAboutRentPage.clickButtonAccept();

        MatcherAssert.assertThat("Ошибка! Итоговый попап с текстом об успехе не выведен. ",
                objAboutRentPage.getTextOfSuccessOrder(),
                containsString(expectedTextInFinalPopup));
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
