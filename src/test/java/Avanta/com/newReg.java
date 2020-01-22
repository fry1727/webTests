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

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class newReg {
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
        String dateBirthd;

    }

    @Test
    public void createNewUserForPayment() throws AWTException, InterruptedException {

        //Регистрация начало
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']"))));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']"))));
        driver.findElement(By.xpath("//input[@placeholder='Birthday']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        
    }


    @After
    public void tearDown() {

        driver.quit();
    }
}
