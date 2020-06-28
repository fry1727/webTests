package PageObjects.Tests;

import PageObjects.Pages.*;
import PageObjects.tools.ApplicationTexts;
import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PortrayYourselfTest {

    private ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;


    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.1autoreg399990@yopmail.com");
        usersData.setPassword("111111");
        usersData.setName("PikaAuto");
        try {
            final Response postResult = Request.Post("https://api.meetville.com/graphql")
                    .bodyString("{\"query\":\"mutation CreateUser($input_0: UserRegistrationMutationInput!) {\\n  userRegistration(input:$input_0)" +
                            "{\\n    errors {\\n      key\\n      message\\n    }\\n   " +
                            " viewer {\\n   xsrfToken\\n        profile {\\n        id\\n        sex\\n        lookingFor\\n        firstName\\n        email\\n        fullYears\\n        city {\\n          name\\n        }\\n  " +
                            "    searchSettings {\\n     sex\\n        ageFrom\\n        ageTo\\n        isMetric\\n        distance\\n        cmHeightFrom\\n        cmHeightTo\\n        cityId\\n      }\\n\\n    }\\n  }\\n}\\n}\\n\"," +
                            "\"variables\":{\"input_0\":{\"firstName\":\"TestWithAR\"," +
                            "\"email\":\"" + usersData.getEmail() + "\"," +
                            "\"cityId\":\"Y2l0eTo2MTMw\"," +
                            "\"sex\":\"female\",\"lookingFor\":\"male\",\"birthdate\":\"1992-03-24\",\"clientMutationId\":\"abcdde\"}},\"operationName\":\"CreateUser\"}", ContentType.APPLICATION_JSON)
                    .addHeader("CLIENT", "{\"id\":\"web.mtvl.def\",\"dtype\":\"phone\",\"metric\":1,\"ccode\":\"USD\",\"lang\":\"ru\",\"locale\":\"ru\"," +
                            "\"os\":\"Android\",\"osv\":\"6.0\",\"did\":\"EFFBBF4C-96EC-42D7-87B3-F37B77D2F210\",\"dname\":\"Nexus 5\",\"decsep\":\".\"," +
                            "\"csymbol\":\".\",\"screen\":\"1000x1242\",\"timezone\":\"Europe/Minsk\",\"push\":0,\"buildv\":\"2.4.2\"}")
                    .execute();

            System.out.println(postResult.returnResponse().toString());

            System.out.println(postResult.returnContent().toString());

        } catch (Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }


    @Test
    public void pYTest() throws AWTException, InterruptedException {
        driver.get("https://m.meetville.com/login");
        LoginPage.login_email(driver).click();
        LoginPage.login_email(driver).sendKeys(usersData.getEmail());
        LoginPage.login_password(driver).click();
        LoginPage.login_password(driver).sendKeys(usersData.getPassword());
        LoginPage.login_confirmButton(driver).click();
        assertThat(PortrayYourselfPage.PYTapTheOptionsToDescribeYourself(driver).getText(), is(ApplicationTexts.tapTheOptionsText(toString())+  "\n" + ApplicationTexts.toDescribeYourself(toString())));


        // driver.get("https://m.meetville.com/registration_steps/portrayYourself");
        PortrayYourselfPage.pYLookingForChat(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYRelationshipHistoryNeverMarried(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYDoYouHaveKidsNo(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYDoYouWantChildrenNo(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYEthnicityIndian(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYReligionAgnostic(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYEducationNoDegree(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pyBodyTypeAverage(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYSmokingNo(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYDrinkingNo(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYHeightScale(driver).click();
        TimeUnit.SECONDS.sleep(1);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyPress(KeyEvent.VK_RIGHT);
        PortrayYourselfPage.pYHeightScale(driver).click();
        TimeUnit.SECONDS.sleep(1);
        PortrayYourselfPage.pYSaveAndContinueButton(driver).click();

        assertThat(InterestsRegistrationPage.interestsPickUpAtLeast5Interests(driver).getText(),
                is(ApplicationTexts.pickUpAtLeast5Interests(toString())));

        System.out.println(" =======================================================Portray Yourself page complete Successfully============================================================== ");

    }
    @After
    public void tearDown() {
        driver.quit();
    }

}

