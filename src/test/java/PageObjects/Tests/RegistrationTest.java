package PageObjects.Tests;

import PageObjects.Pages.RegistrationPage;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.TestData.*;



import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RegistrationTest {
    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


    @Before

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

    }

    @Test
    public void reg () throws InterruptedException {
        driver.get("https://m.meetville.com/");
        TimeUnit.SECONDS.sleep(1);
        new RegistrationPage1();



    }

}
