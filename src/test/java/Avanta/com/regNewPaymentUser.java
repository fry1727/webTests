package Avanta.com;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("111111");
        driver.findElement(By.cssSelector("button[class*='Button']")).click();

        //Регистрация начало
     /*   driver.get("https://m.meetville.com/__registration");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        driver.findElement(By.name("firstName")).click();
        driver.findElement(By.name("firstName")).sendKeys("Test");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("test.payment1727@yopmail.com");
        driver.findElement(By.id("fast_registration_submit")).click();*/
//
        //заполнение describe yourself
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Chat')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Chat')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Never married')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Never married')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'No')]")));
        driver.findElement(By.xpath("//span[contains(text(),'No')]")).click();
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


        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='PhotoBox__container___axuMm PhotoBox__empty___3Po31']")));
        driver.findElement(By.xpath("//input[@class='display_none']")).sendKeys("C:\\maven\\webTests\\src\\recources\\IMG_0784.JPG");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeSelected(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")));
        driver.findElement(By.xpath("//span[contains(text(),'Save & Continue']")).click();

        //}
        //@After
        // public void tearDown() {

        //  driver.quit();
    }
}


