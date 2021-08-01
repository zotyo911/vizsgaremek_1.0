package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import util.Webdriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void init(){
        driver = Webdriver.getDriver();
    }

    @AfterEach
    public void closeDriver(){
        driver.close();
    }
}
