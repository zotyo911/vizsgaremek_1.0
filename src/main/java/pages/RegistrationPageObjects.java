package pages;

import org.openqa.selenium.By;
import util.Util;

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
        Util.getDriver().findElement(nameInput).sendKeys(name);
        Util.getDriver().findElement(passwordInput).sendKeys(password);
        Util.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoName(){
        Util.getDriver().findElement(emailInput).sendKeys(email);
        Util.getDriver().findElement(passwordInput).sendKeys(password);
        Util.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoPassword(){
        Util.getDriver().findElement(nameInput).sendKeys(name);
        Util.getDriver().findElement(emailInput).sendKeys(email);
        Util.getDriver().findElement(passwordInput).sendKeys("");
        Util.getDriver().findElement(checkPasswordInput).sendKeys("");
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNotValidPassword(){
        Util.getDriver().findElement(nameInput).sendKeys(name);
        Util.getDriver().findElement(emailInput).sendKeys(email);
        Util.getDriver().findElement(passwordInput).sendKeys(notValidPassword);
        Util.getDriver().findElement(checkPasswordInput).sendKeys(notValidPassword);
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void registrationNoMatchPassword(){
        Util.getDriver().findElement(nameInput).sendKeys(name);
        Util.getDriver().findElement(emailInput).sendKeys(email);
        Util.getDriver().findElement(passwordInput).sendKeys(password);
        Util.getDriver().findElement(checkPasswordInput).sendKeys(notMatchPassword);
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }

    public static void validRegistration() {
        Util.getDriver().findElement(nameInput).sendKeys(name);
        Util.getDriver().findElement(emailInput).sendKeys(email);
        Util.getDriver().findElement(passwordInput).sendKeys(password);
        Util.getDriver().findElement(checkPasswordInput).sendKeys(password);
        Util.getDriver().findElement(createYourIMDBAccountButton).click();
    }
}
