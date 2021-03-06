import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalendarPage;
import pages.GdprPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {

    WebDriver webdriver;
    CalendarPage calendarPage;
    LoginPage loginPage;
    GdprPage gdprPage;

    @BeforeEach
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    @Order(1)
    @DisplayName("LI-01 Bejelentkezés edzőként email cím megadása nélkül")
    public void TestTrainerLoginNoEmail(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginNoEmail(Constants.TRAINER_PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(2)
    @DisplayName("LI-02 Bejelentkezés edzőként jelszó megadása nélkül")
    public void TestLoginNoPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginNoPassword(Constants.TRAINER_EMAIL);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(3)
    @DisplayName("LI-03 Bejelentkezés edzőként rossz jelszó megadásával")
    public void TestLoginWrongPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLoginWrongPassword(Constants.TRAINER_EMAIL, Constants.TRAINER_WRONG_PASSWORD);


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(4)
    @DisplayName("LI-04 Bejelentkezés edzőként érvényes adatokkal")
    public void TestLogin(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.TRAINER_EMAIL, Constants.TRAINER_PASSWORD);

        Assertions.assertEquals("Hello, Edző", webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }

    @Test
    @Order(5)
    @DisplayName("LI-05 Bejelentkezés felhasználóként email cím megadása nélkül")
    public void TestUserLoginNoEmail(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoEmail(Constants.USER_PASSWORD);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(6)
    @DisplayName("LI-06 Bejelentkezés felhasználóként jelszó megadása nélkül")
    public void TestUserLoginNoPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginNoPassword(Constants.USER_EMAIL);

        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(7)
    @DisplayName("LI-07 Bejelentkezés felhasználóként rossz jelszó megadásával")
    public void TestUserLoginWrongPassword(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLoginWrongPassword(Constants.USER_EMAIL, Constants.USER_WRONG_PASSWORD);


        Assertions.assertEquals("https://igym-igym-dev.azurewebsites.net/authentication/login", webdriver.getCurrentUrl());
    }

    @Test
    @Order(8)
    @DisplayName("LI-08 Bejelentkezés felhasználóként érvényes adatokkal")
    public void TestUserLogin(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.userLogin(Constants.EMAIL, Constants.PASSWORD);

        Assertions.assertEquals("Hello, Teszti", webdriver.findElement(By.cssSelector("mat-toolbar-row:nth-child(1) > div > div > span")).getText());
    }




 /*   @AfterEach
    public void Close() {
        webdriver.quit();
    }*/
}
