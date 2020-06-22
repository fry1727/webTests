package PageObjects.Tests;

import PageObjects.Pages.LoginPage;
import PageObjects.Pages.PeopleNearbyPage;
import PageObjects.Pages.PortrayYourselfPage;
import PageObjects.Pages.RegistrationMainPage;
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
        usersData.setEmail("test.userfora123311@yopmail.com");
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
    public void pYTest() throws AWTException, InterruptedException {
        driver.get("https://m.meetville.com");
        RegistrationMainPage.registrationMainImAManButton(driver).click();              //Choose button I'm a man
        //=========================================================Page 2=====================================================================================================

        RegistrationMainPage.registrationMain2LookingforSecondButton(driver).click(); //Choose button I'm a woman
        //=========================================================Page 3=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain3BirthdayInput(driver).click();
        RegistrationMainPage.registrationMain3DateOkButton(driver).click();         //выбор текущей даты в date picker
        RegistrationMainPage.registrationMain3ContinueButton(driver).click();       //нажатие кнопки Continue
        //=========================================================Page 4=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain4NicknameInput(driver).click();
        RegistrationMainPage.registrationMain4NicknameInput(driver).sendKeys(usersData.getName());
        RegistrationMainPage.registrationMain4ContinueButton(driver).click();        //нажатие кнопки Continue
        //=========================================================Page 5=====================================================================================================
        TimeUnit.SECONDS.sleep(1);
        RegistrationMainPage.registrationMain5EmailInput(driver).click();
        RegistrationMainPage.registrationMain5EmailInput(driver).sendKeys(usersData.getEmail());
        RegistrationMainPage.registrationMain5ContinueButton(driver).click();       //нажатие кнопки Continue
        //=========================================================Проверка перехода на страницу portray yourself
        assertThat(PortrayYourselfPage.PYTapTheOptionsToDescribeYourself(driver).getText(), is(ApplicationTexts.tapTheOptionsText(toString())+  "\n" + ApplicationTexts.toDescribeYourself(toString())));


        // driver.get("https://m.meetville.com/registration_steps/portrayYourself");
        PortrayYourselfPage.pYLookingForChat(driver).click();
        PortrayYourselfPage.pYRelationshipHistoryNeverMarried(driver).click();
        PortrayYourselfPage.pYDoYouHaveKidsNo(driver).click();
        PortrayYourselfPage.pYDoYouWantChildrenNo(driver).click();
        PortrayYourselfPage.pYEthnicityIndian(driver).click();
        PortrayYourselfPage.pYReligionAgnostic(driver).click();
        PortrayYourselfPage.pYEducationNoDegree(driver).click();
        PortrayYourselfPage.pyBodyTypeAverage(driver).click();
        PortrayYourselfPage.pYSmokingNo(driver).click();
        PortrayYourselfPage.pYDrinkingNo(driver).click();
        PortrayYourselfPage.pYHeightScale(driver).click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_RIGHT);
        PortrayYourselfPage.pYSaveAndContinueButton(driver).click();



    }
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

}

