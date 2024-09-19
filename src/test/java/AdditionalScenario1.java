import PageObject.AboutRentPage;
import PageObject.Constants.URLs;
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

    @Before
    public void GetMainPage () {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(); //"--no-sandbox", "--headless", "--disable-dev-shm-usage"
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get(URLs.URL_QA_SCOOTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test
    public void clickScooterFromMainPage() {
        MainPage objMainPage = new MainPage(driver);

        objMainPage.waitForLoadMainPage();
        objMainPage.clickButtonScooter();

        assertEquals(URLs.URL_QA_SCOOTER, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromForWhoScooterPage() {
        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);

        objMainPage.waitForLoadMainPage();
        objMainPage.clickOrderButton(topOrderButton);

        objForWhoScooterPage.clickButtonScooter();

        assertEquals(URLs.URL_QA_SCOOTER, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutRentPage() {
        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        objMainPage.waitForLoadMainPage();
        objMainPage.clickOrderButton(topOrderButton);
        objForWhoScooterPage.inputName("Кнопки");
        objForWhoScooterPage.inputSurname("Тестируем");
        objForWhoScooterPage.inputAddress("самокат");
        objForWhoScooterPage.inputTelephone("+79265949591");
        objForWhoScooterPage.inputMetrostation("Перово");
        objForWhoScooterPage.clickButtonNext();
        objAboutRentPage.waitForLoadAboutRentPage();
        objAboutRentPage.clickButtonScooter();

        assertEquals(URLs.URL_QA_SCOOTER, driver.getCurrentUrl());
    }


    @After
    public void teardown() {
        driver.quit();
    }
}