package Avanta.com.Meetville;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By IAmAManButton = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/div/button[1]");
    private By IAmAWomanButton = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/div/button[2]");
    private By SignInOnRegistration = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/p[2]/a/span");
    private By LookingForFirstButton = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/div/button[1]");
    private By LookingForSecondButton = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div/div/button[2]");
    private By Continue3Button = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[2]/button");
    private By OKDatePickerButton = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/div/div/div[2]/button[2]/span");
    private By NicknameInput = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label/input");
    private By Continue4Button = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/div/button");
    private By EmailInput = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/label[1]/input");
    private By Continue5Button = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/form/div/div/button");
    private By DateInput = By.xpath("//*[@id=\"app-root\"]/main/div/main/div/div/div[1]/input");


    public RegistrationPage clickImAManButton() {
        driver.findElement(IAmAManButton).click();
        return this;
    }
    public RegistrationPage clickImAWomanButton() {
        driver.findElement(IAmAWomanButton).click();
        return this;
    }
    public RegistrationPage clickLookingForFirstButton() {
        driver.findElement(LookingForFirstButton).click();
        return this;
    }

    public RegistrationPage clickLookingForSecondButton() {
        driver.findElement(LookingForSecondButton).click();
        return this;
    }

    public RegistrationPage clickContinue3Button() {
        driver.findElement(Continue3Button).click();
        return this;
    }

    public RegistrationPage clickOkDatePickerButton() {
        driver.findElement(OKDatePickerButton).click();
        return this;
    }

    public RegistrationPage clickContinue4Button() {
        driver.findElement(Continue4Button).click();
        return this;
    }

    public PortrayYourselfPage clickContinue5Button() {
        driver.findElement(Continue5Button).click();
        return new PortrayYourselfPage(driver);
    }

    public RegistrationPage typeNickname(String nickName) {
        driver.findElement(NicknameInput).sendKeys(nickName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        driver.findElement(EmailInput).sendKeys(email);
        return this;
    }
    public RegistrationPage typeDateInput(){
        driver.findElement(DateInput).click();
        return this;
    }

}
