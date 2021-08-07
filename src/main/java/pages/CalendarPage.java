package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CalendarPage {

    WebDriver webdriver;

    public CalendarPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private final By PROFILE_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");
    private final By GDPR_BUTTON = By.xpath("//*/section//a");

    private final By LOGOUT_ICON = By.xpath("//*/mat-icon[2]");
    private final By TRAINING_TYPE = By.xpath("//*[contains(@class,'details')]");
    private final By TRAINING_NAME = By.xpath("//*[contains(@class,'name')]");
    private final By TRAINING_DATE = By.xpath("//*[contains(@class,'time')]");
    private final By TRAINING_PRICE = By.xpath("//*[contains(@class,'price')]");

    private final By ACCEPT_COOKIES_BUTTON = By.xpath("//*/section/button");
    private final By HAMBURGER_BUTTON = By.xpath("//*/mat-icon");
    private final By LOGIN_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[1]/div/span/div[1]");
    private final By REGISTRATION_PAGE_BUTTON = By.xpath("//*/mat-nav-list/a[2]/div/span/div[1]");
    private final By CALENDAR_BUTTON = By.xpath("//*/mat-nav-list/a[3]/div/span/div[1]");
    private final By TRAINER_BUTTON = By.xpath("//*/mat-nav-list/a[4]/div/span/div[1]");

    private final By TRAINING_LIST = By.xpath("//*[contains(@class,'container ng-star-inserted')]");
    private final By TRAININGS = By.cssSelector(".mat-card");


    public void navigateToURL(String url) {
        webdriver.get(url);
    }

    public void clickHamburgerButton() {
        webdriver.findElement(HAMBURGER_BUTTON).click();
    }

    public void clickLoginButton() {
        webdriver.findElement(LOGIN_PAGE_BUTTON).click();
        new LoginPage(webdriver);
    }

    public void clickRegistrationButton() {
        webdriver.findElement(REGISTRATION_PAGE_BUTTON).click();
        new RegistrationPage(webdriver);
    }

    public void profileButtonClick() {
        webdriver.findElement(PROFILE_BUTTON).click();
        new PersonalDetails(webdriver);
    }

    public void openGDPR() {
        webdriver.findElement(GDPR_BUTTON).click();
        new GdprPage(webdriver);

    }

    public String saveTrainingDatasToFile() {
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);
        String text = null;
        if (trainings.size() > 0) {
            text = trainings.get(1).getText();
            try {
                FileWriter textFile = new FileWriter("trainingResult.txt");
                textFile.append(text);
                textFile.close();
            } catch (IOException e) {
            }
        }
        return text;
    }

    public String readTrainingDetailsFile() {
        String data = "";
        int i;
        try {
            File file = new File("trainingResult.txt");
            Scanner scanner = new Scanner(file);
        /*    for (i = 0; i < file.length()-1; i++) {
                if (scanner.hasNextLine()){
                    data += scanner.nextLine() + "\n";
                }
            }*/

            while (scanner.hasNextLine()) {
                data += scanner.nextLine() + "\n";

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }


    public boolean chooseTrainingType(String type){
        boolean isContains = false;
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);
        for(WebElement training : trainings){
            WebElement currentTrainings = training.findElement(TRAININGS);
            if(currentTrainings.getText().toUpperCase().contains(type.toUpperCase())){
                isContains = true;
                break;
            }
        }
        return isContains;
    }




    public void logout(){
        webdriver.findElement(LOGOUT_ICON).click();
    }

    public void clickCookiesAcceptButton(){
        webdriver.findElement(ACCEPT_COOKIES_BUTTON).click();
    }

    public void clickCalendarButton(){
        webdriver.findElement(CALENDAR_BUTTON).click();
    }

    public void clickTrainerButton(){
        webdriver.findElement(TRAINER_BUTTON);
    }

}
