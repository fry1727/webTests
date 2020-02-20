package Avanta.com.CRUD;

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

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Delete {

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
        data.setEmail("test.atestuser@yopmail.com");
        data.setName("Jonathan");
        PasswordGetCRUD passwordGetCRUD = new PasswordGetCRUD();
        passwordGetCRUD.setUp();
        passwordGetCRUD.passYopmail();
        passwordGetCRUD.tearDown();


    }

    @Test
    public void deleteSimpleUser() throws AWTException, InterruptedException {

        //================================логин юзера=============================================================================
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));                //проверка успешного логина
        //=========================изменение аккаунта перед удалением=======================================================
        driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        Random random = new Random();
        int randomCount = random.nextInt(1000000);
        data.setEmail("test." + randomCount + "atestuser@yopmail.com");                                                     //изменение email
        System.out.println("new email is " + data.getEmail());
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        TimeUnit.SECONDS.sleep(1);
        //=========================================удаление аккаунта==================================================================================================
        driver.get("https://m.meetville.com/settings/accountSettings/deleteMyAccount");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete My Account')]")));
        driver.findElement(By.xpath("//textarea[@placeholder='Enter the reason here...']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Later')]")));
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//span[contains(text(),'Later')]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete My Account')]")));
        driver.findElement(By.xpath("//textarea[@placeholder='Enter the reason here...']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Enter the reason here...']")).sendKeys("It's a test user =^_^=");
        driver.findElement(By.xpath("//span[contains(text(),'Send Message & Delete')]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Delete Account')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Delete Account')]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-root']//button[1]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//button[1]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Deactivate Account')]")));
        driver.findElement(By.xpath("//button[@class='py-4 px-0 text-caption-regular color-grey-500 DeactivateMyAccountControl__btn_delete___2PsyF']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Who are you looking for?')]")));
        //===============================проверка логина удалённого пользователя=====================================================================
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Your account was deleted, add another email')]")));

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
