package Avanta.com;

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

public class deletePaymentUser {

    private WebDriver driver;
    // private Map<String, Object> vars;
    //JavascriptExecutor js;


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
    public void deleteUser() {

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test.payment1@yopmail.com");
        driver.findElement(By.name("password")).click();
        String passwordPayment = "111111";  // удалить после нормальной реализации
        driver.findElement(By.name("password")).sendKeys(passwordPayment);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("Layer_1___1847921000")));
        driver.findElement(By.id("Layer_1___1847921000")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("a[href*='/myProfile']")));
        driver.findElement(By.cssSelector("a[href*='/myProfile']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/settings']")));
        driver.findElement(By.cssSelector("a[href*='/settings']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/settings/accountSettings']")));
        driver.findElement(By.cssSelector("a[href*='/settings/accountSettings']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/settings/accountSettings/changeEmail']")));
        driver.findElement(By.cssSelector("a[href*='/settings/accountSettings/changeEmail']")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        String randomCount = "";
        driver.findElement(By.name("email")).sendKeys("test."+randomCount+"payment1@yopmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(passwordPayment);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();

    }

    //  @After
    //public void tearDown() {
    //  driver.quit();
    //}
}


