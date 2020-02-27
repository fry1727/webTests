
package PageObjects.Tests;


import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoginTest {

    private  ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;

    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.pingui@yopmail.com");
        usersData.setPassword("111111");

    }

        @Test
                public  void login() throws InterruptedException {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();
        assertThat(PeopleNearbyPage.pn_title(driver).getText(), is("People Nearby"));

            System.out.println(" Login Successfully ");
    }
        @After
        public void tearDown() {
        driver.quit();
    }
    }


    //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
    // assertThat(driver.findElement(By.className("text-title-medium")).getText(),is("People Nearby"));
