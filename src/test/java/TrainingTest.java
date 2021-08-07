import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalendarPage;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TrainingTest {

    WebDriver webdriver;
    CalendarPage calendarPage;


    @BeforeEach
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    @Order(1)
    public void TestSaveTrainingDetailsToFile()  {
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        String text = calendarPage.saveTrainingDatasToFile();
        String result = calendarPage.readTrainingDetailsFile();

        Assertions.assertEquals(text, result);
    }

    @Test
    public void testChooseTrainingType(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        boolean isContains = calendarPage.chooseTrainingType("jóga");

        Assertions.assertTrue(isContains);
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}