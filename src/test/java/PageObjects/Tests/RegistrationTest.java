package PageObjects.Tests;

import Avanta.com.CRUD.PasswordGetCRUD;
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

    public void setUp() throws InterruptedException {
        RegistrationPage1 registrationPage1 = new RegistrationPage1();
        registrationPage1.setUp();
        registrationPage1.registrationPage1();
        registrationPage1.tearDown();

    }

    @Test
    public void reg () throws InterruptedException {
        new RegistrationPage1();






    }

}
