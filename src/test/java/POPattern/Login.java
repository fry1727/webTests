package POPattern;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class Login {

    LoginPage loginPage = new LoginPages;


    @Test
    public void logIn() {

        loginPage.open();
        assertTrue(loginPage.atPage());
        loginPage.enterUserEmail("test.qwertyuiop@yopmail.com");
        loginPage.enterUserPassword("111111");
        loginPage.clickSignIn();


        //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        // assertThat(driver.findElement(By.className("text-title-medium")).getText(),is("People Nearby"));
    }
}