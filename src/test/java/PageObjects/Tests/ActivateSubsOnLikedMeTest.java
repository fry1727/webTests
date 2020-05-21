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

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class ActivateSubsOnLikedMeTest {

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
    public void actSubLikedTest() {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();
        PeopleNearbyPage.pn_hamburger(driver).click();
        PeopleNearbyPage.pn_ham_likedMe(driver).click();
        assertThat(ActivateSubscriptionPage.as_getFullAccessText(driver).getText(), is(ApplicationTexts.getFullAccessText(toString())));
        assertThat(ActivateSubscriptionPage.as_seeWhoInterestedInYouText(driver).getText(), is(ApplicationTexts.seeWhoInterestedinYou(toString())));
        assertThat(ActivateSubscriptionPage.as_knowWhoFavedYourProfileText(driver).getText(), is(ApplicationTexts.knowWhoFavedYourProfile(toString())));
        assertThat(ActivateSubscriptionPage.as_buySubscriptionButton(driver).getText(), is(ApplicationTexts.buySubscriptionText(toString())));
        System.out.println("===============================Checking Activate Subscription page on LikedMe successful=============================");

    }

    @After
    public void tearDown(){driver.quit();}
}



