package pages;

import org.openqa.selenium.By;
import util.Webdriver;

public class SignInPageObjects extends RegistrationPageObjects{
    private static final By keepMeSignedInCheckBox = By.xpath("//*/label/input");
    private static final By signInButton = By.id("signInSubmit");

    public static void signInEmptyNameInputField(){
        Webdriver.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys("");
        Webdriver.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.password);
        Webdriver.getDriver().findElement(signInButton).click();
    }

    public static void signInEmptyPasswordField(){
        Webdriver.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Webdriver.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys("");
        Webdriver.getDriver().findElement(signInButton).click();
    }

    public static void signInWrongPassword(){
        Webdriver.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Webdriver.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.notMatchPassword);
        Webdriver.getDriver().findElement(signInButton).click();
    }

    public static void signIn(){
        Webdriver.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Webdriver.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.password);
        Webdriver.getDriver().findElement(keepMeSignedInCheckBox).click();
        Webdriver.getDriver().findElement(signInButton).click();
    }
}
