package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private static WebElement element = null;

    public static WebElement reg_HamburgerButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='px-3 py-3']"));
        return element;
    }

    public static WebElement reg_ButtonMan(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[1]"));
        return element;
    }

    public static WebElement reg_ButtonWoman(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[2]"));
        return element;
    }

    public static WebElement reg_BirthdayField(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@placeholder='Birthday']"));
        return element;
    }

    public static WebElement reg_ContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//button[@class='Button__button___2GX_6 Button__blue___1PGNk text-button color-white']"));
        return element;
    }
}
