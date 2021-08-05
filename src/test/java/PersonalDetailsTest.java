import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalendarPage;
import pages.LoginPage;
import pages.PersonalDetails;

import java.util.concurrent.TimeUnit;

public class PersonalDetailsTest {

    WebDriver webdriver;
    LoginPage loginPage;
    CalendarPage calendarPage;
    PersonalDetails personalDetails;

    @BeforeEach
    public void Init() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void testUploadPersonaDetails(){
        calendarPage = new CalendarPage(webdriver);
        calendarPage.navigateToURL(Constants.URL);
        calendarPage.clickHamburgerButton();
        calendarPage.clickLoginButton();
        loginPage = new LoginPage(webdriver);
        loginPage.trainerLogin(Constants.EMAIL, Constants.PASSWORD);
        calendarPage.profileButtonClick();
        personalDetails = new PersonalDetails(webdriver);
        personalDetails.uploadPersonalDetails(Constants.USER_FIRSTNAME, Constants.USER_SURNAME, Constants.USER_NICKNAME);

        Assertions.assertEquals("Hello, " + Constants.USER_FIRSTNAME, webdriver.findElement(By.xpath("//*/mat-toolbar-row[1]/div/div/span")).getText());
    }


  /*  @AfterEach
    public void Close() {
        webdriver.quit();
    }*/
}
