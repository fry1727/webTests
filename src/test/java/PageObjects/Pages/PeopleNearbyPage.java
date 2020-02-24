package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PeopleNearbyPage {

    private static WebElement element = null;

    public static WebElement pn_title(WebDriver driver) {

        element = driver.findElement(By.className("text-title-medium"));

        return element;

    }
}
