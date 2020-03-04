package Avanta.com;

import org.junit.After;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class VisualLogin_T {
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
//проверка присутсвия элементов на странице sign in
     public void visualLog()

    {
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver,1).until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        driver.findElement(By.linkText("Sign in")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("p:nth-child(1) > span")));
        assertThat(driver.findElement(By.cssSelector("p:nth-child(1) > span")).getText(),is("Please use the password sent to your email during the registration."));
        assertThat(driver.findElement(By.cssSelector(".Button__button___2GX_6 > span")).getText(),is("SIGN IN"));
        assertThat(driver.findElement(By.cssSelector("a[href*='/reset_password']")).getText(),is("Reset your password?"));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).click();
        driver.findElement(By.cssSelector("main")).click();
        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Input__error___T9UAQ > span\n")));
        assertThat(driver.findElement(By.cssSelector(".Input__error___T9UAQ > span\n")).getText(),is("Please enter your email"));
        driver.findElement(By.name("password"));
        driver.findElement(By.cssSelector("input[placeholder=\"Password\"]")).click();
        driver.findElement(By.cssSelector("main")).click();
        assertThat(driver.findElement(By.cssSelector(".LoginForm__error___SF0Ae > span\n")).getText(),is("Please enter correct email and password"));
        driver.findElement(By.cssSelector("a[href*='/reset_password']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".Button__button___2GX_6 > span")));
        assertThat(driver.findElement(By.cssSelector(".Button__button___2GX_6 > span")).getText(),is("GET NEW PASSWORD"));
        driver.findElement(By.cssSelector("main")).click();
        driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).click();
        driver.findElement(By.cssSelector("main")).click();
        assertThat(driver.findElement(By.cssSelector(".Input__error___T9UAQ > span")).getText(),is("Please enter your email"));



    }
        @After
        public void tearDown() {
            driver.quit();
        }
}
