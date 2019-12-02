package Avanta.com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.assertThat;

public class passYopmail {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
String pas;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();


    }
    @Test
 public void pasYopm(){
        driver.get("http://www.yopmail.com//");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("test.payment1");
        driver.findElement(By.cssSelector(".sbut")).click();
        driver.findElement(By.cssSelector("a[href*='']")).click();
        //assertThat(driver.findElement(By.cssSelector("#m2 .lms")).getText(),is(("Welcome to Meetville")));
        pas = driver.findElement(By.cssSelector("#m2 .lms")).getText();
        System.out.println(pas);

    }

//@After
//public void tearDown() {
    //driver.quit();
//}
}

