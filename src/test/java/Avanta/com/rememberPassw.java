package Avanta.com;

import com.google.common.base.Verify;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class rememberPassw {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;


    @Before
    public void setUp() {

        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();


    }
    @Test
//восстановление пароля
    public void rememerPass()

    {
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        driver.findElement(By.linkText("Sign in")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("p:nth-child(1) > span")));
        driver.findElement(By.cssSelector("a[href*='/reset_password']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Button__button___2GX_6 > span")));
        assertThat(driver.findElement(By.cssSelector(".Button__button___2GX_6 > span")).getText(),is("GET NEW PASSWORD"));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.cssSelector("main")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Input__error___T9UAQ > span")));
        assertThat(driver.findElement(By.cssSelector(".Input__error___T9UAQ > span")).getText(),is("Please enter your email"));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test.qwertyuiop@yopmail.com");
        driver.findElement(By.cssSelector(".Button__button___2GX_6 > span")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".overlay"))); //Плохой css !!!!!! замени
        //assertThat(driver.findElement(By.cssSelector(".overlay")).getText(),is("Please check your email\\ntest.qwertyuiop@yopmail.com\\nand spam folder\\nto reset your password."));
        driver.findElement(By.cssSelector(".color-blue-500")).click();


    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

