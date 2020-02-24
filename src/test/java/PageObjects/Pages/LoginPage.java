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

}
