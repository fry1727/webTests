package Avanta.com.payments;

import Avanta.com.PassYopmail;
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
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class buySubs {
    private WebDriver driver;


    @Before
    public void setUp() {
        PassYopmail passYopmail = new PassYopmail();
        passYopmail.setUp();
        passYopmail.pasYopm();
        passYopmail.tearDown();

        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);


    }

    @Test
    public void payment() throws InterruptedException {
        if (PassYopmail.sPass != null) {

            driver.get("https://m.meetville.com/");
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
            driver.findElement(By.cssSelector(".px-3 > svg")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
            driver.findElement(By.cssSelector("a[href*='/login']")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
            driver.findElement(By.name("email")).click();
            driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
            driver.findElement(By.name("password")).click();
            driver.findElement(By.name("password")).sendKeys(PassYopmail.sPass);
            driver.findElement(By.cssSelector("button[class*='Button']")).click();
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
            assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

            //переход в active subscription
            driver.findElement(By.xpath("//div[@class='HeaderIconComponent__icon_wrapper___3ZHUA']")).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Activate Subscription')]")));
            driver.findElement(By.xpath("//span[contains(text(),'Activate Subscription')]")).click();
            TimeUnit.SECONDS.sleep(1);
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Buy Subscription')]")));

            //поле ввода данных карты
            driver.findElement(By.xpath("//span[contains(text(),'Buy Subscription')]")).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("card_num")));
            driver.findElement(By.xpath("//div[@id='card_num']//input[@class='__PrivateStripeElement-input']")).sendKeys("4242");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//div[@id='card_num']//input[@class='__PrivateStripeElement-input']")).sendKeys("4242");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//div[@id='card_num']//input[@class='__PrivateStripeElement-input']")).sendKeys("4242");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//div[@id='card_num']//input[@class='__PrivateStripeElement-input']")).sendKeys("4242");


        }
    }
    /*    @After
        public void tearDown() {
            driver.quit();
        }*/
}

