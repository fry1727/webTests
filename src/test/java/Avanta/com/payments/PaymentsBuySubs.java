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

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PaymentsBuySubs {
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
    public void payment() throws InterruptedException, AWTException {
        if (PaymentPasswordYopmail.sPass != null) {

            driver.get("https://m.meetville.com/");
            //===============================================================логинимся в приложение==============================================================================
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
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
            assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

            //====================================================================переход в active subscription=======================================================================
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//div[@class='HeaderIconComponent__icon_wrapper___3ZHUA']")).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Activate Subscription')]")));
            driver.findElement(By.xpath("//span[contains(text(),'Activate Subscription')]")).click();
            TimeUnit.SECONDS.sleep(1);
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Buy Subscription')]")));
            driver.findElement(By.xpath("//span[contains(text(),'Buy Subscription')]")).click();

            //===================================================================поле ввода данных карты=================================================================================
            TimeUnit.SECONDS.sleep(1);
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("card_num")));
            driver.findElement(By.xpath("//div[@id='card_num']//input[@class='__PrivateStripeElement-input']")).sendKeys("");
            Robot robot = new Robot();                                                                                                                      //ввод данных карты 4242 4242 4242 4242
            for (int i = 0; i < 8; i++) {
                robot.keyPress(KeyEvent.VK_4);
                robot.keyPress(KeyEvent.VK_2);
            }
            TimeUnit.MILLISECONDS.sleep(500);
            driver.findElement(By.xpath("//div[@id='card_expiration']//input[@class='__PrivateStripeElement-input']")).sendKeys("07/24");      //expire date 07/24
            TimeUnit.MILLISECONDS.sleep(500);
            driver.findElement(By.xpath("//div[@id='card_code']//input[@class='__PrivateStripeElement-input']")).sendKeys("");               //ввод cvc 333
            robot.keyPress(KeyEvent.VK_3);
            TimeUnit.MILLISECONDS.sleep(500);
            robot.keyPress(KeyEvent.VK_3);
            TimeUnit.MILLISECONDS.sleep(500);
            robot.keyPress(KeyEvent.VK_3);
            driver.findElement(By.xpath("//div[@class='CardPaymentFormControl__text_block___24vJB']")).click();                                                 //подтверждение покупки
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Thank You')]")));
            driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
            new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'People Nearby')]")));      //проверка возврата на PN

        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

