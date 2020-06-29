package PageObjects.TestData;

import Avanta.com.App;
import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.Pages.PortrayYourselfPage;
import PageObjects.Pages.RegistrationMainPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationPage1 {

    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


/*    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        Random random = new Random();
        int randomCount = random.nextInt(1000000);
        String newUser = "test.1autoreg" + randomCount  + "@yopmail.com";
        usersData.setEmail(newUser);
        usersData.setName("PikaAuto");


    }*/


    public RegistrationPage1() throws InterruptedException {
//        driver.get("https://m.meetville.com/");

        RegistrationMainPage.registrationMainImAManButton(driver).click();              //Choose button I'm a man
        //=========================================================Page 2=====================================================================================================

        RegistrationMainPage.registrationMain2LookingforSecondButton(driver).click(); //Choose button I'm a woman
        //=========================================================Page 3=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain3BirthdayInput(driver).click();
        RegistrationMainPage.registrationMain3DateOkButton(driver).click();         //выбор текущей даты в date picker
        RegistrationMainPage.registrationMain3ContinueButton(driver).click();       //нажатие кнопки Continue
        //=========================================================Page 4=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain4NicknameInput(driver).click();
        RegistrationMainPage.registrationMain4NicknameInput(driver).sendKeys(usersData.getName());
        RegistrationMainPage.registrationMain4ContinueButton(driver).click();        //нажатие кнопки Continue
        //=========================================================Page 5=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain5EmailInput(driver).click();
        RegistrationMainPage.registrationMain5EmailInput(driver).sendKeys(usersData.getEmail());
        RegistrationMainPage.registrationMain5ContinueButton(driver).click();       //нажатие кнопки Continue
        //=========================================================Проверка перехода на страницу portray yourself
        assertThat(PortrayYourselfPage.PYTapTheOptionsToDescribeYourself(driver).getText(), is(ApplicationTexts.tapTheOptionsText(toString()) + "\n" + ApplicationTexts.toDescribeYourself(toString())));

        System.out.println(" =======================================================Registration main page complete Successfully============================================================== ");
    }
}
