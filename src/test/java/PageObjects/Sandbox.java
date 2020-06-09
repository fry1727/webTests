package PageObjects;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class Sandbox  {


    public static void main(String[] args) {

      /*  final Content getResult = Request.Get("http://jsonplaceholder.typicode.com/posts?_limit=10")
                .execute().returnContent();
        System.out.println(getResult.asString());

        final Collection<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("title", "foo"));
        params.add(new BasicNameValuePair("body", "bar"));
        params.add(new BasicNameValuePair("userId", "1"));*/


        try {
            final Response postResult = Request.Post("https://api.meetville.com/graphql")
                    .bodyString("{\"query\":\"query clientTexts {\\n  viewer {\\n    appConfig {\\n      supportEmail\\n    }\\n  }\\n}\",\"operationName\":\"clientTexts\"}", ContentType.APPLICATION_JSON)
                    .addHeader( "CLIENT", "{\"id\":\"ios.justmen.def\",\"dtype\":\"phone\",\"lang\":\"en_FR\",\"metric\":\"0\",\"ccode\":\"BYR\",\"locale\":\"fr_FR\",\"os\":\"android\",\"osv\":\"1.0.0\",\"did\":\"EFFBBF4C-96EC-42D7-87B3-F37B77D2F210\",\"dname\":\"iPhone 6 Plus\",\"decsep\":\".\",\"csymbol\":\".\",\"net\":\"wi-fi\",\"screen\":\"400x500\",\"timezone\":\"Europe/Minsk\",\"push\":\"1\",\"buildv\":\"8.6\"}")
                    .execute();
            System.out.println(postResult.returnContent().toString());

        } catch (Exception Ex) {

            System.out.println(Ex.getMessage());

        }
    }
}