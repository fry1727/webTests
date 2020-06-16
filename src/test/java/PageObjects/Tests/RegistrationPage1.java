package PageObjects.Tests;

import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.Pages.RegistrationMainPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationPage1 {

    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.userforautotestsubscheking@yopmail.com");
        usersData.setName("PikaAuto");


    }

    @Test
    public void login() {
        driver.get("https://m.meetville.com/");
        RegistrationMainPage.registrationMainImAManButton(driver).click();

        RegistrationMainPage.registrationMain2LookingforSecondButton(driver).click();

        RegistrationMainPage.registrationMain3BirthdayInput(driver).click();
        RegistrationMainPage.registrationMain3DateOkButton(driver).click();
        RegistrationMainPage.registrationMain3ContinueButton(driver).click();

        RegistrationMainPage.registrationMain4NicknameInput(driver).click();
        RegistrationMainPage.registrationMain4NicknameInput(driver).sendKeys(usersData.getName());
        RegistrationMainPage.registrationMain4ContinueButton(driver).click();

        RegistrationMainPage.registrationMain5EmailInput(driver).click();
        RegistrationMainPage.registrationMain5EmailInput(driver).sendKeys(usersData.getEmail());
        RegistrationMainPage.registrationMain5ContinueButton(driver).click();








        System.out.println(" =======================================================Registration main page complete Successfully============================================================== ");
    }
    //@After
   // public void tearDown() {
     //   driver.quit();
    //}
}
