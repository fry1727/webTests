package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


    private static WebElement element = null;


    public static WebElement login_email(WebDriver driver) {

        element = driver.findElement(By.name("email"));

        return element;

    }

    public static WebElement login_password(WebDriver driver) {

        element = driver.findElement(By.name("password"));

        return element;

    }

    public static WebElement login_confirmButton(WebDriver driver) {
        element = driver.findElement(By.cssSelector("button[class*='Button']"));

        return element;
    }

    public static  WebElement login_textPleaseUseThePassword(WebDriver driver) {
        element = driver.findElement(By.cssSelector("p:nth-child(1) > span"));

        return element;
    }

    public static WebElement login_resetPassword(WebDriver driver) {
        element = driver.findElement(By.cssSelector("a[href*='/reset_password']"));
        return element;
    }
     public static WebElement login_emailError(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/form/label[1]/span/span"));
        return element;
     }

     public static WebElement login_emailPasswordError(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/form/div[2]/span"));
        return element;
     }


}
