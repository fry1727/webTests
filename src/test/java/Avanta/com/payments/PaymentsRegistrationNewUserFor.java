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

public class PaymentsRegistrationNewUserFor {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);

    }

    @Test
    public void createNewUserForPayment() throws AWTException, InterruptedException {

        //Регистрация начало
        driver.get("https://m.meetville.com/__registration");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
        driver.findElement(By.id("fast_registration_submit")).click();
//
        //заполнение describe yourself
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='intent']//li[1]")));
        driver.findElement(By.xpath("//div[@id='intent']//li[1]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='relationshipStatus']//li[1]")));
        driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='kidsAtHome']//li[1]")));
        driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='wantsKids']//li[1]")));
        driver.findElement(By.xpath("//div[@id='wantsKids']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ethnicity']//li[1]")));
        driver.findElement(By.xpath("//div[@id='ethnicity']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='religion']//li[1]")));
        driver.findElement(By.xpath("//div[@id='religion']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='education']//li[1]")));
        driver.findElement(By.xpath("//div[@id='education']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='bodyType']//li[1]")));
        driver.findElement(By.xpath("//div[@id='bodyType']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='smokes']//li[1]")));
        driver.findElement(By.xpath("//div[@id='smokes']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='drinks']//li[1]")));
        driver.findElement(By.xpath("//div[@id='drinks']//li[1]")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")));
        driver.findElement(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")).click();

//
//        //интересы
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Computer Games')]")));
        driver.findElement(By.xpath("//p[contains(text(),'Computer Games')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Charity')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Collecting')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Cooking')]")).click();
        driver.findElement(By.xpath("//p[contains(text(),'Dance')]")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")));
        driver.findElement(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")).click();
//
        //photoUpload


        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='PhotoBox__container___axuMm PhotoBox__empty___3Po31']")));
        driver.findElement(By.xpath("//input[@class='display_none']")).sendKeys("C:\\maven\\webTests\\src\\recources\\IMG_0030.JPG");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        TimeUnit.SECONDS.sleep(10);  //ожидание загрузки фото

        //проверка логина на странице
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}


