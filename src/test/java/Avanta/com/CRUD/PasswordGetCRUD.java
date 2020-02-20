package Avanta.com.CRUD;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PasswordGetCRUD {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    public static String sPass;

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    //================================забираем пароль из yopmail.com=============================
    public void passYopmail() {

        driver.get("http://www.yopmail.com//");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("test.atestuser");
        driver.findElement(By.cssSelector(".sbut")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.partialLinkText("Welcome to Meetville")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Password:')]")));
        sPass = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[6]/td[1]/span[1]")).getText();

    }

    public void tearDown() {
        driver.quit();
    }
}


