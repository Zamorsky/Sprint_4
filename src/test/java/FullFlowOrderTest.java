// Импорт классов из пакетов PageObject, которые описывают страницы и элементы страницы.
import pageobject.AboutRentPage;
import pageobject.ForWhoScooterPage;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;

import pageobject.MainPage;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// Используем аннотацию @RunWith для запуска параметризованных тестов. В этом случае - с двумя наборами данных.
@RunWith(Parameterized.class)
public class FullFlowOrderTest extends BeforeAndAfterParent {
    // наследуем переменную для WebDriver, которая будет управлять браузером.

    // Параметры для параметризованного теста
    private final By choisedOrderButton; // Кнопка для создания заказа, может быть верхняя или нижняя.
    private final String name; // Имя пользователя для формы заказа.
    private final String surname; // Фамилия пользователя для формы заказа.
    private final String address; // Адрес пользователя.
    private final String metrostation; // Ближайшая станция метро.
    private final String telephone; // Номер телефона.
    private final String dateOfScooterDelivery; // Дата доставки самоката.
    private final String rentTime; // Время аренды (на сколько дней).
    private final String colorOfScooter; // Цвет самоката.
    private final String inputComment; // Комментарий пользователя.
    private final String expectedTextInFinalPopup; // Ожидаемый текст во всплывающем окне после успешного заказа.

    // Конструктор, который инициализирует параметры теста.
    public FullFlowOrderTest(By choisedOrderButton, String name, String surname, String address, String metrostation,
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

    // Метод, который задает параметры для теста. Параметры включают две тестовые ситуации с разными данными.
    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                // Первый набор данных для верхней кнопки заказа.
                {MainPage.TOP_ORDER_BUTTON, "Антон", "Заморский", "ул. Тестервская34 дом 0.123, кв 1,3,4", "Перово", "+79265949591", "22.09.2024", "сутки","чёрный жемчуг","дам хорошие чаевые","Заказ оформлен"},
                // Второй набор данных для нижней кнопки заказа.
                {MainPage.BOTTOM_ORDER_BUTTON, "Заморский", "Антон", "ул. Тестеровщинская 3.1423, 0.123, кв 000", "Выхино", "+79265843618", "17.09.2024", "семеро суток","серая безысходность","чаевых не дам","Заказ оформлен"}
        };
    }

    // НАСЛЕДУЕТСЯ Метод, который выполняется перед тестом. Инициализирует драйвер и открывает главную страницу тестируемого приложения.


    /*
    // Альтернативный метод инициализации драйвера для Firefox. Оставлен как комментарий для возможного использования.
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru");
    }
    */

    // Основной тест, проверяющий позитивный сценарий создания заказа.
    @Test
    public void fullFlowOrderTest() {
        // Создание объектов страниц, которые будут использоваться для взаимодействия с элементами UI.
        MainPage objMainPage = new MainPage(driver); // Главная страница.
        ForWhoScooterPage objForWhoScooterPage = new ForWhoScooterPage(driver); // Страница ввода данных о заказчике.
        AboutRentPage objAboutRentPage = new AboutRentPage(driver); // Страница ввода данных о самокате и аренде.

        // Клик на кнопку заказа (верхнюю или нижнюю) в зависимости от переданного параметра.
        objMainPage.clickOrderButton(choisedOrderButton);

        // Ввод данных на странице "Для кого самокат".
        objForWhoScooterPage.inputName(name); // Ввод имени.
        objForWhoScooterPage.inputSurname(surname); // Ввод фамилии.
        objForWhoScooterPage.inputAddress(address); // Ввод адреса.
        objForWhoScooterPage.inputTelephone(telephone); // Ввод телефона.
        objForWhoScooterPage.inputMetrostation(metrostation); // Ввод ближайшей станции метро.
        objForWhoScooterPage.clickButtonNext(); // Переход на следующую страницу.

        // Ожидание загрузки страницы с данными аренды самоката.
        objAboutRentPage.waitForLoadAboutRentPage();
        // Ввод данных на странице "Об аренде".
        objAboutRentPage.inputDateOfScooterDelivery(dateOfScooterDelivery); // Ввод даты доставки самоката.
        objAboutRentPage.inputRentTime(rentTime); // Ввод времени аренды.
        objAboutRentPage.inputColorOfScooter(colorOfScooter); // Ввод цвета самоката.
        objAboutRentPage.inputComment(inputComment); // Ввод комментария.
        objAboutRentPage.clickButtonOrder(); // Нажатие кнопки "Заказать".
        objAboutRentPage.clickButtonAccept(); // Подтверждение заказа.

        // Проверка, что на странице отображается попап с успешным сообщением о создании заказа.
        MatcherAssert.assertThat("Ошибка! Итоговый попап с текстом об успехе не выведен. ",
                objAboutRentPage.getTextOfSuccessOrder(), // Получаем текст всплывающего окна.
                containsString(expectedTextInFinalPopup)); // Проверяем, что текст содержит ожидаемое сообщение.
    }

    // Метод, который выполняется после теста для завершения работы браузера наследуется

}