package Avanta.com.Meetville;

import Avanta.com.Meetville.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App {

    static WebDriver driver;
    public static void main( String[] args ) {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver83Mac");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://m.meetville.com");

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickImAManButton();
        registrationPage.clickLookingForSecondButton();
        registrationPage.typeDateInput();
        registrationPage.clickOkDatePickerButton();
        registrationPage.clickContinue3Button();
        registrationPage.typeNickname("pika");
        registrationPage.clickContinue4Button();
        registrationPage.typeEmail("test.testauteNew@yopmail.com");
       // registrationPage.clickContinue5Button();



    }
}
