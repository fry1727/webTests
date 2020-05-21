package PageObjects.Tests;

import PageObjects.Pages.CommonElements;
import PageObjects.Pages.ResetPasswordOnLoginPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResetPasswordVisualTest {
    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;

    @Before
    public void setUp() {
        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
    }

    @Test
    public void resetPasswordVisual() throws InterruptedException{
        driver.get("https://m.meetville.com/reset_password");
        assertThat(ResetPasswordOnLoginPage.resetPassword_getNewPasswordButton(driver).getText(), is(ApplicationTexts.getNewPassword(toString())));
        ResetPasswordOnLoginPage.resetPassword_input(driver).click();
        CommonElements.Main(driver).click();
        assertThat(ResetPasswordOnLoginPage.resetPassword_emailError(driver).getText(), is (ApplicationTexts.pleaseEnterYourEmail(toString())));
        System.out.println("=======================ResetPassword page check Successfully=====================");
    }
    @After
    public void tearDown(){driver.quit();}
}
