package PageObjects.TestData;

import PageObjects.Pages.*;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhotoUploadTest {
    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.1autoreg39510@yopmail.com");
        usersData.setPassword("111111");
        usersData.setName("PikaAuto");
//        try {
//            final Response postResult = Request.Post("https://api.meetville.com/graphql")
//                    .bodyString("{\"query\":\"mutation CreateUser($input_0: UserRegistrationMutationInput!) {\\n  userRegistration(input:$input_0)" +
//                            "{\\n    errors {\\n      key\\n      message\\n    }\\n   " +
//                            " viewer {\\n      profile {\\n        id\\n        sex\\n        lookingFor\\n        firstName\\n        email\\n        fullYears\\n        city {\\n          name\\n        }\\n  " +
//                            "    searchSettings {\\n     sex\\n        ageFrom\\n        ageTo\\n        isMetric\\n        distance\\n        cmHeightFrom\\n        cmHeightTo\\n        cityId\\n      }\\n\\n    }\\n  }\\n}\\n}\\n\"," +
//                            "\"variables\":{\"input_0\":{\"firstName\":\"TestWithAR\"," +
//                            "\"email\":\"" + usersData.getEmail() + "\"," +
//                            "\"cityId\":\"Y2l0eTo2MTMw\"," +
//                            "\"sex\":\"female\",\"lookingFor\":\"male\",\"birthdate\":\"1992-03-24\",\"clientMutationId\":\"abcdde\"}},\"operationName\":\"CreateUser\"}", ContentType.APPLICATION_JSON)
//                    .addHeader("CLIENT", "{\"id\":\"ios.justmen.def\",\"dtype\":\"phone\",\"lang\":\"en_FR\",\"metric\":\"0\",\"ccode\":\"BYR\"," +
//                            "\"locale\":\"fr_FR\",\"os\":\"android\",\"osv\":\"1.0.0\",\"did\":\"EFFBBF4C-96EC-42D7-87B3-F37B77D2F210\"," +
//                            "\"dname\":\"iPhone 6 Plus\",\"decsep\":\".\",\"csymbol\":\".\",\"net\":\"wi-fi\",\"screen\":\"400x500\",\"timezone\":\"Europe/Minsk\",\"push\":\"1\",\"buildv\":\"8.6\"}")
//                    .execute();
//            postResult.returnContent().toString();
//
//            System.out.println(postResult.returnContent().toString());
//        } catch (Exception Ex) {
//            System.out.println(Ex.getMessage());
//        }
    }


    @Test
    public void phUploadTest() throws AWTException, InterruptedException {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();

        // driver.get("https://m.meetville.com/registration_steps/photoUpload");


        PhotoUploadPage.photoUploadAddPhotoButton(driver).sendKeys("/Users/yskiruk/IdeaProjects/webTests/src/recources/1_d_850.jpg");
        PhotoUploadPage.photoUploadSaveAndContinueButton(driver).click();
        TimeUnit.SECONDS.sleep(10);
        assertThat(PeopleNearbyPage.pn_title(driver).getText(), is(ApplicationTexts.peopleNearbyText(toString())));
        System.out.println(" =======================================================PhotoUpload page checking complete Successfully============================================================== ");




    }
    @After
    public void tearDown() {
        driver.quit();
    }

}



