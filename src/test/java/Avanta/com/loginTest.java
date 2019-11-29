package Avanta.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class loginTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");
       driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();


        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("user-agent=\"Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_1 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) CriOS/63.0.3239.73 Mobile/15C153 Safari/604.1\"");
        //new ChromeDriver(options);
    }

    @Test
    public void logIn() {

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test.pingui@yopmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("111111");
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(),is("People Nearby"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
