package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResetPasswordOnLoginPage {
    private static WebElement element = null;

    public static WebElement resetPassword_getNewPasswordButton (WebDriver driver) {
        element = driver.findElement(By.cssSelector(".Button__button___2GX_6 > span"));
        return  element;
    }


    public static WebElement resetPassword_input (WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/form/label/input"));
        return element;
    }

    public static WebElement resetPassword_emailError (WebDriver driver)  {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/main/form/label/span/span"));
        return element;
    }

}
