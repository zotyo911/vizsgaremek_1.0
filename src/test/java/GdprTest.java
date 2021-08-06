import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalendarPage;
import pages.GdprPage;

import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GdprTest {

    WebDriver webdriver;
    CalendarPage calendarPage;
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
    public void TestOpenGDPR() {
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.openGDPR();
        gdprPage = new GdprPage(webdriver);
        gdprPage.switchWindow();
        calendarPage.clickCookiesAcceptButton();
    }



 /*   @AfterEach
    public void Close() {
        webdriver.quit();
    }*/
}
