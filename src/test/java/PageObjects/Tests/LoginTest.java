
package PageObjects.Tests;


import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LoginTest {

    //private  ChromeDriver driver;
    private DriverWithOptions diverOpt;
    UsersData usersData;

    @Before

    public void setUp() {


        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--no-sandbox");
        //options.addArguments("useragent = Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");
        //options.addArguments("--headless");
        //options.addArguments("disable-gpu");
        options.addArguments("window-size=1400,2100"); // Linux should be activate
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        usersData = new UsersData();
        usersData.setEmail("test.pingui@yopmail.com");
        usersData.setPassword("111111");

    }

        @Test
                public  void login() throws InterruptedException {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();
        assertThat(PeopleNearbyPage.pn_title(driver).getText(), is("People Nearby"));

            System.out.println(" Login Successfully ");
    }
        @After
        public void tearDown() {
        driver.quit();
    }
    }


    //  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.className("text-title-medium")));
    // assertThat(driver.findElement(By.className("text-title-medium")).getText(),is("People Nearby"));
