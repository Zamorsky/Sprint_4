import pageobject.AboutRentPage;
import pageobject.constants.URLs;
import pageobject.ForWhoScooterPage;
import pageobject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static pageobject.MainPage.TOP_ORDER_BUTTON;
import static org.junit.Assert.assertEquals;

public class ButtonScooterTest extends BeforeAndAfterParent {

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
        objMainPage.clickOrderButton(TOP_ORDER_BUTTON);

        objForWhoScooterPage.clickButtonScooter();

        assertEquals(URLs.URL_QA_SCOOTER, driver.getCurrentUrl());
    }

    @Test
    public void clickScooterFromAboutRentPage() {
        MainPage objMainPage = new MainPage(driver);
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver);
        AboutRentPage objAboutRentPage = new AboutRentPage(driver);

        objMainPage.waitForLoadMainPage();
        objMainPage.clickOrderButton(TOP_ORDER_BUTTON);
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
}