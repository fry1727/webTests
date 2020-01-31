package Avanta.com.CRUD;

import Avanta.com.Data;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Read {
    private WebDriver driver;
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
        data.setEmail("test.atestuser@yopmail.com");
        data.setName("Jonathan");
        PasswordGetCRUD passwordGetCRUD = new PasswordGetCRUD();
        passwordGetCRUD.setUp();
        passwordGetCRUD.passYopmail();
        passwordGetCRUD.tearDown();


    }

    @Test
    public void readSimpleUser() throws AWTException, InterruptedException {

        //================================проверка созданного юзера=============================================================================
        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));
        driver.findElement(By.cssSelector(".px-3 > svg")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='/login']")));
        driver.findElement(By.cssSelector("a[href*='/login']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
        assertThat(driver.findElement(By.className("text-title-medium")).getText(), is("People Nearby"));                //проверка успешного логина

        driver.get("https://m.meetville.com/settings/editBasicInfo");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.name("name")));
        assertThat(driver.findElement(By.name("name")).getAttribute("value"), is(data.getName()));                          //проверка имени
        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
        Calendar c = new GregorianCalendar();
        c.setTimeInMillis(System.currentTimeMillis());
        c.add(Calendar.YEAR, -26);
        Date date = c.getTime();
        assertThat(driver.findElement(By.name("Birthday")).getAttribute("value"), is(dateFormat.format(date)));             //проверка даты

        driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        assertThat(driver.findElement(By.xpath("//p[@class='text-body-regular color-black mb-2']")).getText(), is(data.getEmail()));        //проверка email
        driver.get("https://m.meetville.com/myProfile");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Profile')]")));
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[1]/div[1]")).getText(), is("Chat"));                              //проверка Looking for
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[5]/div[1]/div[1]")).getText(), is("Separated"));                         //проверка relationship
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[6]/div[1]/div[1]")).getText(), is("No"));                                //проверка Children
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[7]/div[1]/div[1]")).getText(), is("No"));                                 //проверка want to kids
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[8]/div[1]/div[1]")).getText(), is("White / Caucasian"));                  //проверка Ethnicity
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[9]/div[1]/div[1]")).getText(), is("No Degree"));                          //проверка Education
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[10]/div[1]/div[1]")).getText(), is("Agnostic"));                          //проверка Religion
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/div[1]")).getText(), is("Average"));                            //проверка BodyType
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[4]/ul[1]/li[3]/div[1]/div[1]")).getText(), is("No"));                                 //проверка Smoking
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[4]/ul[1]/li[4]/div[1]/div[1]")).getText(), is("No"));                                 //проверка Drinking
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[5]/ul[1]/li[1]/div[1]/div[1]")).getText(), is("Computer Games, Charity, Collecting, Cooking, Dance"));   //проверка Interests


    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
