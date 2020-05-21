package PageObjects.Tests;

import PageObjects.Pages.CommonElements;
import PageObjects.Pages.LoginPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;


public class LoginVisualTest {
    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;


    @Before

    public void setUp() {
        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;

    }

    @Test
    public void loginVisual() throws InterruptedException {
        driver.get("https://m.meetville.com/login");
        assertThat(LoginPage.login_textPleaseUseThePassword(driver).getText(), is(ApplicationTexts.pleaseUseThePassword(toString())));
        LoginPage.login_email(driver).click();
        CommonElements.Main(driver).click();
        assertThat(LoginPage.login_emailError(driver).getText(), is(ApplicationTexts.pleaseEnterYourEmail(toString())));
        LoginPage.login_password(driver).click();
        CommonElements.Main(driver).click();
        assertThat(LoginPage.login_emailPasswordError(driver).getText(), is(ApplicationTexts.pleaseEnterCorrectEmailAndPassword(toString())));
        assertThat(LoginPage.login_confirmButton(driver).getText(), is(ApplicationTexts.signIn(toString())));
        assertThat(LoginPage.login_resetPassword(driver).getText(), is(ApplicationTexts.resetYourPassword(toString())));
        LoginPage.login_resetPassword(driver).click();  //добавить проверку на переход на страницу  "reset password"

        System.out.println("==========================LoginPage visual check Successfully===========================");

    }

    @After
    public void tearDown() {driver.quit();}
}
