import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalendarPage;
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
    public void TestSaveTrainingDetailsToFile() {
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        String text = calendarPage.saveTrainingDatasToFile();
        String result = calendarPage.readTrainingDetailsFile();

        Assertions.assertEquals(text, result);
    }

    @Test
    @Order(2)
    public void testChooseTrainingType(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        boolean isContains = calendarPage.chooseTrainingType(Constants.TRAINING_TYPE_JOGA);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(3)
    public void testChooseNotValidTrainingType(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        boolean isContains = calendarPage.chooseTrainingType(Constants.TRAINING_TYPE_INVALID);

        Assertions.assertFalse(isContains);
    }

    @Test
    @Order(4)
    public void testOfJogaButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.jogaButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_JOGA);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(5)
    public void testOfStrechingButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.stechingButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_STRECHING);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(6)
    public void testOfMeditationButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.meditationButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_MEDITATON);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(7)
    public void testOfKardioButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.kardioButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_KARDIO);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(8)
    public void testOfPilatesButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.pilatesButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_PILATES);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(9)
    public void testOfBodyFitButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.bodyFitButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_BODYFIT);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(10)
    public void testOfMuscleButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.muscleButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_MUSCLE);

        Assertions.assertTrue(isContains);
    }

    @Test
    @Order(11)
    public void testOfOtherButton(){
        calendarPage =new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.muscleButtonClick();
        boolean isContains = calendarPage.upperMenuButtonChecker(Constants.TRAINING_TYPE_OTHER);

        Assertions.assertTrue(isContains);
    }

    @AfterEach
    public void Close() {
        webdriver.quit();
    }
}