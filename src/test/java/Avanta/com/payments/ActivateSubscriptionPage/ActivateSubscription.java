package Avanta.com.payments.ActivateSubscriptionPage;

import Avanta.com.Data;
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
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ActivateSubscription {
    private WebDriver driver;
    Data data;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        data = new Data();
        data.setEmail("test.userforautotestsubscheking@yopmail.com");
        data.setPassword("111111");
    }

    @Test
    public void activateSubstciptionCheck() throws InterruptedException {

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        //=============================================переход на вкладку active subscription=======================================================================
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//div[@class='HeaderIconComponent__icon_wrapper___3ZHUA']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Activate Subscription')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Activate Subscription')]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Buy Subscription')]")));
        //======================================проверка элементов на странице===========================================================================================
        assertThat(driver.findElement(By.xpath("//div[@class='HeaderMainContentComponent__inner___2IrBU']")).getText(), is("Get Full Access"));
        assertThat(driver.findElement(By.xpath("//div[10]//div[1]//h3[1]")).getText(), is("Send Messages"));
        assertThat(driver.findElement(By.xpath("//div[10]//div[1]//p[1]")).getText(), is("Chat with any member:\nfree and paid users can reply"));
        assertThat(driver.findElement(By.xpath("//a[@class='Button__button___2GX_6 Button__link___E_ERf Button__blue___1PGNk text-button rounded-6 color-white VipStepControl__link_center___33Aio']")).getText(), is("BUY SUBSCRIPTION"));

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

