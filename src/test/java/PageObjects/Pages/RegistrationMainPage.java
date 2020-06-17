package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationMainPage {

    private static WebElement element = null;

    public static WebElement registrationMainImAManButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/div/button[1]"));
        return element;
    }

    public static WebElement registrationMainImWomanButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/div/button[2]"));
        return element;
    }

    public static WebElement registrationMainTextLetsFindYour(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/h5/span[1]"));
        return element;
    }

    public static WebElement registrationMainTextNextDate(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/h5/span[2]"));
        return element;
    }

    public static WebElement registrationMainTextAreYouManOrWoman(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/p[1]/span"));
        return element;
    }

    public static WebElement registrationMainTextAlreadyHasAnAcc(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/p[2]/span"));
        return element;
    }

    public static WebElement registrationMainSignIn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/p[2]/a/span"));
        return element;
    }

    public static WebElement registrationMain2WhoAreYouSeeking(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/p[1]/span"));
        return element;
    }

    public static WebElement registrationMain2LookingForFirstButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/div/button[1]"));
        return element;
    }

    public static WebElement registrationMain2LookingforSecondButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/div/button[2]"));
        return element;
    }

    public static WebElement registrationMain3WhenIsYourBirthday(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'When is your birthday?')]"));
        return element;
    }

    public static WebElement registrationMain3BirthdayInput(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/input"));
        return element;
    }
    public static WebElement registrationMain3BirthdayPlaceholder(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='Birthday']"));
        return element;
    }

    public static WebElement registrationMain3ContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/button"));
        return element;
    }

    public static WebElement registrationMain3DateOkButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/div/div/div[2]/button[2]/span"));
        return element;
    }

    public static WebElement registrationMain4WhatIsYourNickname(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/p/span"));
        return element;
    }

    public static WebElement registrationMain4NicknameInput(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label/input"));
        return element;
    }

    public static WebElement registrationMain4ContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/div/button"));
        return element;
    }

    public static WebElement registrationMain5WhatIsYourEmail(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/p[1]/span"));
        return element;
    }

    public static WebElement registrationMain5EmailInput(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label[1]/input"));
        return element;
    }

    public static WebElement registrationMain5CheckboxEmail(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label[2]"));
        return element;
    }

    public static WebElement registrationMain5CheckboxEmailText(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label[2]/span[2]/span"));
        return element;
    }

    public static WebElement registrationMain5PrivacyCookieTermsText(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/p[2]"));
        return element;
    }

    public static WebElement registrationMain5ContinueButton (WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/div/div/button"));
        return element;
    }

    public static WebElement registrationMainCookiePolicyBanner (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"landing-header\"]/header/div[1]/div/span"));
        return element;
    }
    public static WebElement registrationMain2SignIn(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/p[2]/a/span"));
        return element;
    }
    public static WebElement registrationMain2AlreadyHawAnAc(WebDriver driver) {
        element= driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/p[2]/span"));
        return element;
    }
}
//