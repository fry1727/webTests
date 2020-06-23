package PageObjects;

import PageObjects.tools.DriverWithOptions;
import PageObjects.tools.UsersData;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Sandbox  {

    private  ChromeDriver driver;
    DriverWithOptions driverWithOptions;
    UsersData usersData;



    @Before

    public void setUp() {

        driverWithOptions = new DriverWithOptions();
        driverWithOptions.diverOpt();
        this.driver = driverWithOptions.driver;
        usersData = new UsersData();
        usersData.setEmail("test.usercheking23423@yopmail.com");
        usersData.setPassword("111111");
        try {
//            final Response postResult = Request.Post("https://api.meetville.com/graphql")
//                    .bodyString("{\"query\":\"mutation generateAccessToken($input: GenerateAccessTokenMutationInput!)" +
//                            " {\\n    generateAccessToken(input:$input) {\\n    clientMutationId,\\n    viewer {\\n      accessToken\\n      xsrfToken\\n     " +
//                            " profile {\\n        id\\n        isVip\\n      }\\n    },\\n    errors {\\n      key,\\n      message\\n    }\\n  }\\n}\\n\"," +
//                            "\"variables\":{\"input\":{\"email\":\"golodny@tut.by\",\"password\":\"111111\",\"clientMutationId\":\"abcde\"}},\"operationName\":\"generateAccessToken\"}", ContentType.APPLICATION_JSON)
//
//                    .addHeader( "CLIENT", "{\"id\":\"ios.justmen.def\",\"dtype\":\"phone\",\"lang\":\"en_FR\",\"metric\":\"0\",\"ccode\":\"BYR\"," +
//                            "\"locale\":\"fr_FR\",\"os\":\"android\",\"osv\":\"1.0.0\",\"did\":\"EFFBBF4C-96EC-42D7-87B3-F37B77D2F210\"," +
//                            "\"dname\":\"iPhone 6 Plus\",\"decsep\":\".\",\"csymbol\":\".\",\"net\":\"wi-fi\",\"screen\":\"400x500\",\"timezone\":\"Europe/Minsk\",\"push\":\"1\",\"buildv\":\"8.6\"}")
//                    .execute();
//            System.out.println(postResult.returnContent().toString());

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



//                    HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet("https://m.meetville.com/");
//        HttpResponse response = client.execute(request);
//
//
//
////get all headers
//        Header[] headers = response.getAllHeaders();
//        for (Header header : headers) {
//            System.out.println("Key : " + header.getName()
//                    + " ,Value : " + header.getValue());
//        }
//
////get header by 'key'
//        String server = response.getFirstHeader("Server").getValue();
//        //System.out.println(server);


            //postResult.returnResponse().getHeaders()




        } catch (Exception Ex) {
            System.out.println(Ex.getMessage());
        }
    }


    @Test
    public void sandy() throws IOException {

//        HttpClient client = HttpClientBuilder.create().build();
//        HttpGet request = new HttpGet("https://m.meetville.com/");
//        HttpResponse response = client.execute(request);
//        response.set


////get all headers
//        Header[] headers = response.getAllHeaders();
//        for (Header header : headers) {
//            System.out.println("Key : " + header.getName()
//                    + " ,Value : " + header.getValue());
//        }
//
////get header by 'key'
//        String server = response.getFirstHeader("Server").getValue();
//        System.out.println(server);

        driver.get("https://m.meetville.com/");


    }
    @After
    public void tearDown() {
        driver.quit();
    }

}