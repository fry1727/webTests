package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonElements {

    public static WebElement element = null;

    public static WebElement Main (WebDriver driver) {
        element = driver.findElement(By.cssSelector("main"));
        return element;
    }

}
