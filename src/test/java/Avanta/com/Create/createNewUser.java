package Avanta.com.Create;

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
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class createNewUser {
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
    public void create() throws AWTException, InterruptedException {



/*        //Регистрация начало
        driver.get("https://m.meetville.com/__registration");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
        driver.findElement(By.name("firstName")).click();     //ввод имени
        String userName = "Jonathan";
        driver.findElement(By.name("firstName")).sendKeys(userName);
        driver.findElement(By.name("email")).click();    // ввод email
        driver.findElement(By.name("email")).clear();
        Random random = new Random();
        int randomCount = random.nextInt(1000000);
        String newUser = "test.atest" + randomCount  + "@yopmail.com";
        driver.findElement(By.name("email")).sendKeys(newUser);
        driver.findElement(By.id("fast_registration_submit")).click();*/

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test.atest355199@yopmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("111111");
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
//
        //заполнение describe yourself
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='intent']//li[1]")));
        assertThat(driver.findElement(By.xpath("//h1[@class='header-title text-title-medium text-center']")).getText(), is("Tap the Options" + "\n" + "to Describe Yourself"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Looking for"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//li[1]//div[1]")).getText(), is("Chat"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//li[2]//div[1]")).getText(), is("Flirt"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//li[3]//div[1]")).getText(), is("Long-term"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//li[4]//div[1]")).getText(), is("New friends"));
        assertThat(driver.findElement(By.xpath("//div[@id='intent']//li[5]//div[1]")).getText(), is("Date"));
        driver.findElement(By.xpath("//div[@id='intent']//li[1]")).click();
        //(driver.findElement(By.xpath("//div[@id='intent']//li[@class='ToggledList__list_item___1I-8Y ToggledList__active___3FMdM item-with-line']//div[@class='PortayYourselfControl__question_list_item___1SJIM color-grey-700 text-body-regular pr-12']")).;
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='relationshipStatus']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='relationshipStatus']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Relationship History"));
        assertThat(driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[1]//div[1]")).getText(), is("Never married"));
        assertThat(driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[2]//div[1]")).getText(), is("Separated"));
        assertThat(driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[3]//div[1]")).getText(), is("Divorced"));
        assertThat(driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[4]//div[1]")).getText(), is("Widowed"));
        driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='kidsAtHome']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='kidsAtHome']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Do You Have Kids?"));
        assertThat(driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[1]//div[1]")).getText(), is("No"));
        assertThat(driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[2]//div[1]")).getText(), is("Yes, they live with me"));
        assertThat(driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[3]//div[1]")).getText(), is("Yes, but they don't live with me"));
        driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='wantsKids']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='wantsKids']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Do You Want Children?"));
        assertThat(driver.findElement(By.xpath("//div[@id='wantsKids']//li[1]//div[1]")).getText(), is("No"));
        assertThat(driver.findElement(By.xpath("//div[@id='wantsKids']//li[2]//div[1]")).getText(), is("Yes"));
        assertThat(driver.findElement(By.xpath("//div[@id='wantsKids']//li[3]//div[1]")).getText(), is("Someday"));
        assertThat(driver.findElement(By.xpath("//div[@id='wantsKids']//li[4]//div[1]")).getText(), is("No, but my partner can have them"));
        driver.findElement(By.xpath("//div[@id='wantsKids']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ethnicity']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Ethnicity"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[1]//div[1]")).getText(), is("White / Caucasian"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[2]//div[1]")).getText(), is("Black / African"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[3]//div[1]")).getText(), is("Hispanic / Latino"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[4]//div[1]")).getText(), is("Native American"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[5]//div[1]")).getText(), is("Asian"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[6]//div[1]")).getText(), is("Indian"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[7]//div[1]")).getText(), is("Middle Eastern"));
        assertThat(driver.findElement(By.xpath("//div[@id='ethnicity']//li[8]//div[1]")).getText(), is("Mixed / Other"));
        driver.findElement(By.xpath("//div[@id='ethnicity']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='religion']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Religion"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[1]//div[1]")).getText(), is("Agnostic"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[2]//div[1]")).getText(), is("Atheist"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[3]//div[1]")).getText(), is("Buddhist / Taoist"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[4]//div[1]")).getText(), is("Christian / Catholic"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[5]//div[1]")).getText(), is("Christian / LDS"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[6]//div[1]")).getText(), is("Christian / Protestant"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[7]//div[1]")).getText(), is("Christian / Other"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[8]//div[1]")).getText(), is("Hindu"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[9]//div[1]")).getText(), is("Jewish"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[10]//div[1]")).getText(), is("Muslim / Islam"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[11]//div[1]")).getText(), is("Spiritual but not religious"));
        assertThat(driver.findElement(By.xpath("//div[@id='religion']//li[12]//div[1]")).getText(), is("Other"));
        driver.findElement(By.xpath("//div[@id='religion']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='education']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Education"));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//li[1]//div[1]")).getText(), is("No Degree"));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//li[2]//div[1]")).getText(), is("High school"));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//li[3]//div[1]")).getText(), is("Some College"));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//li[4]//div[1]")).getText(), is("Bachelor's Degree"));
        assertThat(driver.findElement(By.xpath("//div[@id='education']//li[5]//div[1]")).getText(), is("Master's / Doctorate"));
        driver.findElement(By.xpath("//div[@id='education']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='bodyType']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Body type"));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//li[1]//div[1]")).getText(), is("Average"));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//li[2]//div[1]")).getText(), is("Athletic"));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//li[3]//div[1]")).getText(), is("Slim"));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//li[4]//div[1]")).getText(), is("Curvy"));
        assertThat(driver.findElement(By.xpath("//div[@id='bodyType']//li[5]//div[1]")).getText(), is("A Few Extra Pounds"));
        driver.findElement(By.xpath("//div[@id='bodyType']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='smokes']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='smokes']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Smoking"));
        assertThat(driver.findElement(By.xpath("//div[@id='smokes']//li[1]//div[1]")).getText(), is("No"));
        assertThat(driver.findElement(By.xpath("//div[@id='smokes']//li[2]//div[1]")).getText(), is("Yes, socially"));
        assertThat(driver.findElement(By.xpath("//div[@id='smokes']//li[3]//div[1]")).getText(), is("Yes, regularly"));
        driver.findElement(By.xpath("//div[@id='smokes']//li[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='drinks']//li[1]")));
        assertThat(driver.findElement(By.xpath("//div[@id='drinks']//h2[@class='text-title-regular mb-1 pr-12']")).getText(), is("Drinking"));
        assertThat(driver.findElement(By.xpath("//div[@id='drinks']//li[1]//div[1]")).getText(), is("No"));
        assertThat(driver.findElement(By.xpath("//div[@id='drinks']//li[2]//div[1]")).getText(), is("Yes, socially"));
        assertThat(driver.findElement(By.xpath("//div[@id='drinks']//li[3]//div[1]")).getText(), is("Yes, regularly"));
        driver.findElement(By.xpath("//div[@id='drinks']//li[1]")).click();
        assertThat(driver.findElement(By.xpath("//h2[@class='text-title-regular mb-1']")).getText(), is("Height"));
        assertThat(driver.findElement(By.xpath("//p[@class='mb-2 color-grey-700 text-body-regular']")).getText(), is("Slide to set the value"));
        assertThat(driver.findElement(By.xpath("//div[@class='text-small-caption-regular color-grey-500']")).getText(), is("Foot/Inch"));
        assertThat(driver.findElement(By.xpath("//div[@class='text-small-caption-regular color-grey-500']")).getText(), is("Foot/Inch"));

        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        driver.findElement(By.cssSelector(".text-small-caption-regular > span")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF")).click();
        driver.findElement(By.cssSelector(".RulerScale__inner___2QpaF > svg")).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
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


        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='PhotoBox__container___axuMm PhotoBox__empty___3Po31']")));
        driver.findElement(By.xpath("//input[@class='display_none']")).sendKeys("C:\\maven\\webTests\\src\\recources\\IMG_0030.JPG");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        TimeUnit.SECONDS.sleep(10);  //ожидание загрузки фото

        //проверка логина на странице
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
