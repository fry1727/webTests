package Avanta.com;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class regNewPaymentUser {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

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
    public void createNewUserForPayment() {
        driver.get("https://m.meetville.com/__registration");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
        driver.findElement(By.id("fast_registration_submit")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#intent .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#intent .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        driver.findElement(By.cssSelector("#relationshipStatus .item-with-line:nth-child(1) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#kidsAtHome .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#kidsAtHome .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#wantsKids .item-with-line:nth-child(3) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#wantsKids .item-with-line:nth-child(3) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ethnicity .item-with-line:nth-child(5) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#ethnicity .item-with-line:nth-child(5) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".item-with-line:nth-child(7) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector(".item-with-line:nth-child(7) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#education .item-with-line:nth-child(4) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#education .item-with-line:nth-child(4) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bodyType .item-with-line:nth-child(3) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#bodyType .item-with-line:nth-child(3) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#smokes .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")));
        driver.findElement(By.cssSelector("#smokes .item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")).click();

        driver.findElement(By.cssSelector(".item-with-line:nth-child(2) > .PortayYourselfControl__question_list_item___1SJIM")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        driver.findElement(By.cssSelector(".Button__button___2GX_6")).click();
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.ARROW_RIGHT).perform();
        driver.findElement(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")).click();


        //}
        //@After
        // public void tearDown() {
        //  driver.quit();
    }
}


