package PageObjects.Tests;

import PageObjects.Pages.ActivateSubscriptionPage;
import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActivateSubscriptionTest {
    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


    @Before

    public void SetUp() {
        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.userforautotestsubscheking@yopmail.com");
        usersData.setPassword("111111");
    }

    @Test
    public void actSubTest() {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();
        PeopleNearbyPage.pn_hamburger(driver).click();
        PeopleNearbyPage.pn_ham_ActiveSubscription(driver).click();
        assertThat(ActivateSubscriptionPage.as_getFullAccessText(driver).getText(), is(ApplicationTexts.getFullAccessText(toString())));
        assertThat(ActivateSubscriptionPage.as_sendMessages(driver).getText(), is(ApplicationTexts.sendMessagesText(toString())));
        assertThat(ActivateSubscriptionPage.as_chatWithAnyMember(driver).getText(), is(ApplicationTexts.chatWithAnyMemberText(toString())));
        assertThat(ActivateSubscriptionPage.as_buySubscriptionButton(driver).getText(), is(ApplicationTexts.buySubscriptionText(toString())));
        System.out.println("Checking successful");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

