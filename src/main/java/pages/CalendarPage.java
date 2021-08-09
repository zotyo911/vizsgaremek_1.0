package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
    private final By CALENDAR_FORWARD_ARROW_BUTTON = By.xpath("//*/section/div/span[2]");
    private final By CALENDAR_TRAINING_LIST = By.xpath("//*/app-training-calendar-list-view");
    private final By UPPER_MENU_JOGA_BUTTON = By.cssSelector("div:nth-child(1) > button > mat-icon > svg");
    private final By UPPER_MENU_STRECHING_BUTTON = By.cssSelector("div:nth-child(2) > button > mat-icon > svg");
    private final By UPPER_MENU_MEDITATION_BUTTON = By.cssSelector("div:nth-child(3) > button > mat-icon > svg");
    private final By UPPER_MENU_KARDIO_BUTTON = By.cssSelector("div:nth-child(4) > button > mat-icon > svg");
    private final By UPPER_MENU_PILATES_BUTTON = By.cssSelector("div:nth-child(5) > button > mat-icon > svg");
    private final By UPPER_MENU_BODYFIT_BUTTON = By.cssSelector("div:nth-child(6) > button > mat-icon > svg");
    private final By UPPER_MENU_MUSCLE_BUTTON = By.cssSelector("div:nth-child(7) > button > mat-icon > svg");
    private final By UPPER_MENU_OTHER_BUTTON = By.cssSelector("div:nth-child(8) > button > mat-icon > svg");



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
        String text = "";
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


    public boolean chooseTrainingType(String type) {
        boolean isContains = false;
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);
        for (WebElement training : trainings) {
            WebElement currentTrainings = training.findElement(TRAININGS);
            if (currentTrainings.getText().toUpperCase().contains(type.toUpperCase())) {
                isContains = true;
            } else {
                isContains = false;
            }
        }
        return isContains;
    }
    public void jogaButtonClick(){
        webdriver.findElement(UPPER_MENU_JOGA_BUTTON).click();
    }

    public void stechingButtonClick(){
        webdriver.findElement(UPPER_MENU_STRECHING_BUTTON).click();
    }

    public void meditationButtonClick(){
        webdriver.findElement(UPPER_MENU_MEDITATION_BUTTON).click();
    }

    public void kardioButtonClick(){
        webdriver.findElement(UPPER_MENU_KARDIO_BUTTON).click();
    }

    public void pilatesButtonClick() {
        webdriver.findElement(UPPER_MENU_PILATES_BUTTON).click();
    }

    public void bodyFitButtonClick(){
        webdriver.findElement(UPPER_MENU_BODYFIT_BUTTON).click();
    }

    public void muscleButtonClick(){
        webdriver.findElement(UPPER_MENU_MUSCLE_BUTTON).click();
    }

    public void otherButtonClick(){
        webdriver.findElement(UPPER_MENU_OTHER_BUTTON).click();
    }




    public boolean upperMenuButtonChecker(String type){
        boolean isContains = true;
        List<WebElement> trainings = webdriver.findElements(TRAINING_LIST);
        for (WebElement training : trainings) {
            WebElement currentTrainings = training.findElement(TRAININGS);
            if (trainings.size() == 0 || currentTrainings.getText().toUpperCase().contains(type.toUpperCase())) {
                isContains = true;
            } else {
                isContains = false;
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
