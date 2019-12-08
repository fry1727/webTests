package Avanta.com;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


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
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.partialLinkText("Welcome to Meetville")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Password:')]")));
        //String a = driver.findElement(By.xpath("//span[contains(text(),'Password:')]")).getText();
        //System.out.println(a);
        String pass = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[1]/span[1]")).getText();
        System.out.println(pass);


    }

//@After
//public void tearDown() {
    //driver.quit();
//}
}

