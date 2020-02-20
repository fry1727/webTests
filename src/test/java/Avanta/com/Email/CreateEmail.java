package Avanta.com.Email;

import Avanta.com.Data;
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
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CreateEmail {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    Data data;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        data = new Data();
        data.setName("Anton");
        Random random = new Random();
        int randomCount = random.nextInt(1000000);
        data.setEmail("test." + randomCount + "aTestEmail@yopmail.com");

    }

    @Test
    public void createSimpleUser() throws AWTException, InterruptedException {

        //===================================================Регистрация начало======================================================================================================
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']"))));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']"))));
        driver.findElement(By.xpath("//input[@placeholder='Birthday']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'OK')]"))));
        driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("name"))));   //ввод name
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).sendKeys(data.getName());
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("email"))));   //ввод email
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();

        //==================================================заполнение describe yourself===========================================================================================

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='intent']//li[1]")));
        driver.findElement(By.xpath("//div[@id='intent']//li[1]")).click();                                                                                                 //выбор Looking for: Chat
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='relationshipStatus']//li[1]")));
        driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[1]")).click();                                                                                     //выбор relationship: Separated
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='kidsAtHome']//li[1]")));
        driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[1]")).click();                                                                                              //выбор Children: No
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='wantsKids']//li[1]")));
        driver.findElement(By.xpath("//div[@id='wantsKids']//li[1]")).click();                                                                                               //выбор wantsKids: No
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ethnicity']//li[1]")));
        driver.findElement(By.xpath("//div[@id='ethnicity']//li[1]")).click();                                                                                                //выбор Ethnicity: White / Caucasian
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='religion']//li[1]")));
        driver.findElement(By.xpath("//div[@id='religion']//li[1]")).click();                                                                                                  //выбор Religion: Agnostic
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='education']//li[1]")));
        driver.findElement(By.xpath("//div[@id='education']//li[1]")).click();                                                                                                  //выбор Education: No Degree
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='bodyType']//li[1]")));
        driver.findElement(By.xpath("//div[@id='bodyType']//li[1]")).click();                                                                                                   //выбор BodyType: Average
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='smokes']//li[1]")));
        driver.findElement(By.xpath("//div[@id='smokes']//li[1]")).click();                                                                                                     //выбор Smoking: No
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='drinks']//li[1]")));
        driver.findElement(By.xpath("//div[@id='drinks']//li[1]")).click();                                                                                                       //выбор Drinking: No
        TimeUnit.SECONDS.sleep(1);
        //=============================================выбор роста==============================================================
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")));
        driver.findElement(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")).click();

        //===================================================заполнение интересов======================================================================================================

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Computer Games')]")));
        driver.findElement(By.xpath("//p[contains(text(),'Computer Games')]")).click();                                                                                                  //выбор Computer Games
        driver.findElement(By.xpath("//p[contains(text(),'Charity')]")).click();                                                                                                        //выбор Charity
        driver.findElement(By.xpath("//p[contains(text(),'Collecting')]")).click();                                                                                                     //выбор Collecting
        driver.findElement(By.xpath("//p[contains(text(),'Cooking')]")).click();                                                                                                        //выбор Cooking
        driver.findElement(By.xpath("//p[contains(text(),'Dance')]")).click();                                                                                                          //выбор CDance
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")));
        driver.findElement(By.cssSelector(".SaveContinueButton__footer_fixed___3D1EY .Button__button___2GX_6")).click();

        //====================================================шаг photoUpload==================================================================================================================

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='PhotoBox__container___axuMm PhotoBox__empty___3Po31']")));
        driver.findElement(By.xpath("//input[@class='display_none']")).sendKeys("C:\\maven\\webTests\\src\\recources\\IMG_0030.JPG");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        TimeUnit.SECONDS.sleep(10);                                                                                                                                         //ожидание загрузки фото

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

        driver.get("http://www.yopmail.com//");
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys(data.getEmail());
        driver.findElement(By.cssSelector(".sbut")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.partialLinkText("Welcome to Meetville")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Password:')]")));
        driver.findElement(By.xpath("//span[contains(text(),'OPEN APP')]")).click();

        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
