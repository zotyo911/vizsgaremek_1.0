import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalendarPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogoutTest {

    WebDriver webdriver;
    CalendarPage calendarPage;
    LoginPage loginPage;

    @BeforeEach
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    @Order(1)
    @DisplayName("LO-01 Trainer kijlentkezés")
    public void TestTrainerLogout() {
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.TRAINER_EMAIL, Constants.TRAINER_PASSWORD);
        calendarPage.logout();

        Assertions.assertEquals("BELÉPÉS", webdriver.findElement(By.cssSelector("mat-toolbar-row > div > div > span")).getText());
    }

    @Test
    @Order(2)
    @DisplayName("LO-02 User kijlentkezés")
    public void TestUserLogout() {
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        calendarPage.logout();

        Assertions.assertEquals("BELÉPÉS", webdriver.findElement(By.cssSelector("mat-toolbar-row > div > div > span")).getText());
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}
