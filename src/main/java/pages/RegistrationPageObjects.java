package pages;

import org.openqa.selenium.By;
import util.Webdriver;

public class RegistrationPageObjects {

    protected static final String name = "Soós Zoltán";
    protected static final String email = "sooszoltan79@gmail.com";
    protected static final String password = "Ca1133557799";
    protected static final String notValidPassword = "Ca11334";
    protected static final String notMatchPassword = "Ca1133557798";


    protected static final By nameInput = By.id("ap_customer_name");
    protected static final By emailInput = By.id("ap_email");
    protected static final By passwordInput = By.id("ap_password");
    protected static final By checkPasswordInput = By.id("ap_password_check");
    protected static final By createYourIMDBAccountButton = By.id("continue");

    public static void registrationNoEmailAddress() {
        Webdriver.getDriver().findElement(nameInput).sendKeys(name);
        Webdriver.getDriver().findElement(passwordInput).sendKeys(password);
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoName(){
        Webdriver.getDriver().findElement(emailInput).sendKeys(email);
        Webdriver.getDriver().findElement(passwordInput).sendKeys(password);
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoPassword(){
        Webdriver.getDriver().findElement(nameInput).sendKeys(name);
        Webdriver.getDriver().findElement(emailInput).sendKeys(email);
        Webdriver.getDriver().findElement(passwordInput).sendKeys("");
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys("");
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNotValidPassword(){
        Webdriver.getDriver().findElement(nameInput).sendKeys(name);
        Webdriver.getDriver().findElement(emailInput).sendKeys(email);
        Webdriver.getDriver().findElement(passwordInput).sendKeys(notValidPassword);
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys(notValidPassword);
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoMatchPassword(){
        Webdriver.getDriver().findElement(nameInput).sendKeys(name);
        Webdriver.getDriver().findElement(emailInput).sendKeys(email);
        Webdriver.getDriver().findElement(passwordInput).sendKeys(password);
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys(notMatchPassword);
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void validRegistration() {
        Webdriver.getDriver().findElement(nameInput).sendKeys(name);
        Webdriver.getDriver().findElement(emailInput).sendKeys(email);
        Webdriver.getDriver().findElement(passwordInput).sendKeys(password);
        Webdriver.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Webdriver.getDriver().findElement(createYourIMDBAccountButton).click();
    }
}
