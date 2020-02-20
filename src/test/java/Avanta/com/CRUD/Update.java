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
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Update {
    private WebDriver driver;
    Data data;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver");
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
    public void updateSimpleUser() throws AWTException, InterruptedException {

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
        //=====================================================изменение данных===========================================================
        driver.get("https://m.meetville.com/settings/editBasicInfo");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.name("name")));
        driver.findElement(By.name("name")).click();
        driver.findElement(By.name("name")).clear();
        data.setName("Boris");                                                                                                  //изменение имени
        driver.findElement(By.name("name")).sendKeys(data.getName());
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();

        driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        Random random = new Random();
        int randomCount = random.nextInt(1000000);
        data.setEmail("test." + randomCount + "atestuser@yopmail.com");                                                     //изменение email
        System.out.println("new email is " + data.getEmail());
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();

        driver.get("https://m.meetville.com/myProfile#intent");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Looking for')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине looking for на Flirt
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#relationshipStatus");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Relationship')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[3]")).click();                                                                                                             //изменяем separated на Divorced
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#kidsAtHome");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Children')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Yes, they live with me')]")).click();                                                                                          //иземняем No на Yes, they live with me
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#wantsKids");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Want kids')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине No на Yes
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#ethnicity");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Ethnicity')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине White / Caucasian на Black / African
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#education");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Education')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине No Degree на High school
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#religion");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Religion')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине Agnostic на Atheist
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#bodyType");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Body type')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине Average на Athletic
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#smokes");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Smoking')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине No на Yes, socially
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#drinks");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Drinking')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//li[2]")).click();                                                                                                             //изенменине No на Yes, socially
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        driver.get("https://m.meetville.com/myProfile#categories");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Categories')]")));
        driver.findElement(By.xpath("//div[@id='modal-root']//div[@class='mt-4']//li[1]")).click();                                                                                                             //выбираем дополнительно поле Music
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();

        //===========================выход из аккаунта===========================================================
        driver.get("https://m.meetville.com/settings");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[@class='text-title-medium']//span[contains(text(),'Settings')]")));
        driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']")).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Who are you looking for?')]")));                            //ждём загрзки стартовой страницы

        //проверка изменённых данных

        driver.get("https://m.meetville.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".px-3 > svg")));                                                        //логин в приложение
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
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("name")));
        assertThat(driver.findElement(By.name("name")).getAttribute("value"), is(data.getName()));                          //проверка изменённого имени (Boris)
        driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        assertThat(driver.findElement(By.xpath("//p[@class='text-body-regular color-black mb-2']")).getText(), is(data.getEmail()));        //проверка изменённого email
        driver.get("https://m.meetville.com/myProfile");
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Profile')]")));
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[4]/div[1]/div[1]")).getText(), is("Flirt"));                              //проверка Looking for
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[5]/div[1]/div[1]")).getText(), is("Divorced"));                         //проверка relationship
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[6]/div[1]/div[1]")).getText(), is("Yes, they live with me"));                                //проверка Children
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[7]/div[1]/div[1]")).getText(), is("Yes"));                                 //проверка want to kids
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[8]/div[1]/div[1]")).getText(), is("Black / African"));                  //проверка Ethnicity
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[9]/div[1]/div[1]")).getText(), is("High school"));                          //проверка Education
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[2]/ul[1]/li[10]/div[1]/div[1]")).getText(), is("Atheist"));                          //проверка Religion
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[3]/ul[1]/li[1]/div[1]/div[1]")).getText(), is("Athletic"));                            //проверка BodyType
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[4]/ul[1]/li[3]/div[1]/div[1]")).getText(), is("Yes, socially"));                                 //проверка Smoking
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[4]/ul[1]/li[4]/div[1]/div[1]")).getText(), is("Yes, socially"));                                 //проверка Drinking
        assertThat(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/section[1]/div[1]/div[2]/div[5]/ul[1]/li[1]/div[1]/div[1]")).getText(), is("Computer Games, Charity, Collecting, Cooking, Dance, Music"));   //проверка Interests
//=================================================вернуть старый email===================================================================================================================================

        driver.get("https://m.meetville.com/settings/accountSettings/changeEmail");
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.name("email")));
        driver.findElement(By.name("email")).click();
        data.setEmail("test.atestuser@yopmail.com");                                                     //изменение email
        driver.findElement(By.name("email")).sendKeys(data.getEmail());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PasswordGetCRUD.sPass);
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
        TimeUnit.SECONDS.sleep(1);

    }

    @After
    public void tearDown() {

        driver.quit();
    }
}


