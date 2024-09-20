import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.constants.URLs;

import java.util.concurrent.TimeUnit;

public abstract class BeforeAndAfterParent {
    protected WebDriver driver;
    @Before
    public void setUp() {
        // Код инициализации перед каждым тестом
        // Настройки для Chrome (можно добавить дополнительные аргументы, например для работы в headless режиме).
        ChromeOptions options = new ChromeOptions();
        options.addArguments(); // Пример: "--no-sandbox", "--headless", "--disable-dev-shm-usage"
        driver = new ChromeDriver(options);
        // Переход на страницу тестируемого приложения.
        driver.get(URLs.URL_QA_SCOOTER);
        // Установка неявного ожидания для всех элементов страницы.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
            driver.quit();
    }
}