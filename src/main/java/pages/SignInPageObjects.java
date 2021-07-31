package pages;

import org.openqa.selenium.By;
import util.Util;

public class SignInPageObjects extends RegistrationPageObjects{
    private static final By keepMeSignedInCheckBox = By.xpath("//*/label/input");
    private static final By signInButton = By.id("signInSubmit");

    public static void signInEmptyNameInputField(){
        Util.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys("");
        Util.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.password);
        Util.getDriver().findElement(signInButton).click();
    }

    public static void signInEmptyPasswordField(){
        Util.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Util.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys("");
        Util.getDriver().findElement(signInButton).click();
    }

    public static void signInWrongPassword(){
        Util.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Util.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.notMatchPassword);
        Util.getDriver().findElement(signInButton).click();
    }

    public static void signIn(){
        Util.getDriver().findElement(RegistrationPageObjects.emailInput).sendKeys(RegistrationPageObjects.email);
        Util.getDriver().findElement(RegistrationPageObjects.passwordInput).sendKeys(RegistrationPageObjects.password);
        Util.getDriver().findElement(keepMeSignedInCheckBox).click();
        Util.getDriver().findElement(signInButton).click();
    }
}
