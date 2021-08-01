package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class Webdriver {

    private static WebDriver driver;
    private static final String URL = "https://www.imdb.com";

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
        //    options.setExperimentalOption("useAutomationExtension", false);
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get(URL);
        }
        return driver;
    }
}
