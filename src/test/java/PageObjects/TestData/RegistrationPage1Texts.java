package PageObjects.TestData;

import PageObjects.Pages.RegistrationMainPage;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RegistrationPage1Texts {

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
    public void regPage1Text() throws InterruptedException {
        driver.get("https://m.meetville.com/");
        assertThat(RegistrationMainPage.registrationMainTextLetsFindYour(driver).getText(), is(ApplicationTexts.letsFindYourTEXT(toString())));
        assertThat(RegistrationMainPage.registrationMainTextNextDate(driver).getText(), is(ApplicationTexts.nextDateTEXT(toString())));
        assertThat(RegistrationMainPage.registrationMainTextAreYouManOrWoman(driver).getText(), is(ApplicationTexts.areYouAManOrAWomanTEXT(toString())));
        assertThat(RegistrationMainPage.registrationMainTextAlreadyHasAnAcc(driver).getText(), is(ApplicationTexts.alreadyHaveAnAccountText(toString())));
        assertThat(RegistrationMainPage.registrationMainImAManButton(driver).getText(),
                is(ApplicationTexts.manIcon(toString())+"\n"+ApplicationTexts.imATEXT(toString())+"\n"+ApplicationTexts.manTEXT(toString())));
        assertThat(RegistrationMainPage.registrationMainImWomanButton(driver).getText(),
                is(ApplicationTexts.womanIcon(toString())+"\n"+ApplicationTexts.imATEXT(toString())+"\n"+ApplicationTexts.womanText(toString())));
        assertThat(RegistrationMainPage.registrationMainSignIn(driver).getText(), is(ApplicationTexts.signInOnRegistrationText(toString())));
        assertThat(RegistrationMainPage.registrationMainCookiePolicyBanner(driver).getText(),
                is(ApplicationTexts.cookiePoliceBannerText1(toString())+" "+ApplicationTexts.cookiePoliceBannerText2(toString())+" ."));
        RegistrationMainPage.registrationMainImAManButton(driver).click();              //Choose button I'm a man
//=========================================================Page 2=====================================================================================================
        assertThat(RegistrationMainPage.registrationMainCookiePolicyBanner(driver).getText(),
                is(ApplicationTexts.cookiePoliceBannerText1(toString())+" "+ApplicationTexts.cookiePoliceBannerText2(toString())+" ."));
        assertThat(RegistrationMainPage.registrationMain2WhoAreYouSeeking(driver).getText(), is(ApplicationTexts.whoAreYouSeekingForText(toString())));
        assertThat(RegistrationMainPage.registrationMain2SignIn(driver).getText(), is(ApplicationTexts.signInOnRegistrationText(toString())));
        assertThat(RegistrationMainPage.registrationMain2AlreadyHawAnAc(driver).getText(), is(ApplicationTexts.alreadyHaveAnAccountText(toString())));
        assertThat(RegistrationMainPage.registrationMain2LookingForFirstButton(driver).getText()
                ,is(ApplicationTexts.seekingAManFromMANICON(toString())+"\n"+ApplicationTexts.seekingAText(toString())+"\n"+ApplicationTexts.manTEXT(toString())));
        assertThat(RegistrationMainPage.registrationMain2LookingforSecondButton(driver).getText()
                ,is(ApplicationTexts.seekingAWomanfromManICON(toString())+"\n"+ApplicationTexts.seekingAText(toString())+"\n"+ApplicationTexts.womanText(toString())));
        RegistrationMainPage.registrationMain2LookingforSecondButton(driver).click(); //Choose button I'm a woman
//=========================================================Page 3=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        assertThat(RegistrationMainPage.registrationMainCookiePolicyBanner(driver).getText(),
                is(ApplicationTexts.cookiePoliceBannerText1(toString())+" "+ApplicationTexts.cookiePoliceBannerText2(toString())+" ."));
        RegistrationMainPage.registrationMain3BirthdayInput(driver).click();
        RegistrationMainPage.registrationMain3DateOkButton(driver).click();         //выбор текущей даты в date picker
        assertThat(RegistrationMainPage.registrationMain3WhenIsYourBirthday(driver).getText(), is(ApplicationTexts.whenIsYourBirthdayText(toString())));
        //assertThat(RegistrationMainPage.registrationMain3BirthdayPlaceholder(driver).getText(), is(ApplicationTexts.placeholderBirthdayText(toString())));     //добавить проверку плэйсхолдера
        assertThat(RegistrationMainPage.registrationMain3ContinueButton(driver).getText(), is(ApplicationTexts.continueButtonText(toString())));
        RegistrationMainPage.registrationMain3ContinueButton(driver).click();
//=========================================================Page 4=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        assertThat(RegistrationMainPage.registrationMainCookiePolicyBanner(driver).getText(),
                is(ApplicationTexts.cookiePoliceBannerText1(toString())+" "+ApplicationTexts.cookiePoliceBannerText2(toString())+" ."));
        assertThat(RegistrationMainPage.registrationMain4WhatIsYourNickname(driver).getText(), is(ApplicationTexts.whatisYourNicknameText(toString())));
        assertThat(RegistrationMainPage.registrationMain4ContinueButton(driver).getText(), is(ApplicationTexts.continueButtonText(toString())));
        RegistrationMainPage.registrationMain4NicknameInput(driver).click();
        RegistrationMainPage.registrationMain4NicknameInput(driver).sendKeys(usersData.getName());
        RegistrationMainPage.registrationMain4ContinueButton(driver).click();
//=========================================================Page 5=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        assertThat(RegistrationMainPage.registrationMainCookiePolicyBanner(driver).getText(),
                is(ApplicationTexts.cookiePoliceBannerText1(toString())+" "+ApplicationTexts.cookiePoliceBannerText2(toString())+" ."));
        assertThat(RegistrationMainPage.registrationMain5WhatIsYourEmail(driver).getText(), is(ApplicationTexts.whatIsYourEmailText(toString())));
        assertThat(RegistrationMainPage.registrationMain5CheckboxEmailText(driver).getText(), is(ApplicationTexts.sendMeEmailsCheckboxText(toString())));
        assertThat(RegistrationMainPage.registrationMain5ContinueButton(driver).getText(), is(ApplicationTexts.continueButtonText(toString())));
        assertThat(RegistrationMainPage.registrationMain5PrivacyCookieTermsText(driver).getText(),
                is(ApplicationTexts.signingUpOrInAnAccountText(toString())+" "+ApplicationTexts.termsOfUseText(toString())+" , "+ ApplicationTexts.securityAndConplianceText(toString())
                        + " , "+ ApplicationTexts.cookiePolicyText(toString())+" "+ ApplicationTexts.andText(toString())+ " "+ ApplicationTexts.PrivacyPolicyText(toString())+ " ."));


        System.out.println(" =======================================================Registration main page texts checking complete Successfully============================================================== ");
    }

    @After
     public void tearDown() {
       driver.quit();
    }
}

