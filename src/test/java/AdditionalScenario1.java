import PageObject.AboutRentPage;
import PageObject.ForWhoScooterPage;
import PageObject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static PageObject.MainPage.topOrderButton;
import static org.junit.Assert.assertEquals;

public class AdditionalScenario1 {
    WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";

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
    public void clickScooterFromMainPage() {
        MainPage objMainPage = new MainPage(driver);

        MainPage.waitForLoadMainPAge();

        MainPage.clickButtonScooter();

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromForWhoScooterPage() {
        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);

        MainPage.waitForLoadMainPAge();
        objMainPage.ClickOrderButton(topOrderButton);

        ForWhoScooterPage.clickButtonScooter();

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutRentPage() {
        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        MainPage.waitForLoadMainPAge();
        objMainPage.ClickOrderButton(topOrderButton);
        ForWhoScooterPage.inputName("Кнопки");
        ForWhoScooterPage.inputSurname("Тестируем");
        ForWhoScooterPage.inputAddress("самокат");
        ForWhoScooterPage.inputTelephone("+79265949591");
        ForWhoScooterPage.inputMetrostation("Перово");
        ForWhoScooterPage.clickButtonNext();
        AboutRentPage.waitForLoadAboutRentPage();
        AboutRentPage.clickButtonScooter();

        assertEquals("https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }


    @After
    public void teardown() {
        driver.quit();
    }

}