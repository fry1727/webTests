package PageObjects.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Data {

    public static void main(String[] args) throws IOException {

        FileInputStream fis;

        Properties prop = new Properties();


        fis = new FileInputStream("src/test/java/PageObjects/data.properties");
        prop.load(fis);

        System.out.println(prop.getProperty("email"));


    }
}