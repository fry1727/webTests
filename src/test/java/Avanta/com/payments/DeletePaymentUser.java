package Avanta.com.payments;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DeletePaymentUser {

    private WebDriver driver;


    @Before
    public void setUp() {
        PaymentPasswordYopmail paymentPasswordYopmail = new PaymentPasswordYopmail();
        paymentPasswordYopmail.setUp();
        paymentPasswordYopmail.pasYopm();
        paymentPasswordYopmail.tearDown();

        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

    }

    @Test
    public void deleteUser() {
        if (PaymentPasswordYopmail.sPass != null) {

            driver.get("https://m.meetville.com/");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
            driver.findElement(By.cssSelector(".px-3 > svg")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
            driver.findElement(By.cssSelector("a[href*='/login']")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
            driver.findElement(By.name("password")).click();


            driver.findElement(By.name("password")).sendKeys(PaymentPasswordYopmail.sPass);
            driver.findElement(By.cssSelector("button[class*='Button']")).click();

            driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
            driver.findElement(By.name("email")).click();
            Random random = new Random();
            int randomCount = random.nextInt(1000000);
            driver.findElement(By.name("email")).sendKeys("test." + randomCount + "payment1727@yopmail.com");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys(PaymentPasswordYopmail.sPass);
            driver.findElement(By.cssSelector("button[class*='Button']")).click();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


