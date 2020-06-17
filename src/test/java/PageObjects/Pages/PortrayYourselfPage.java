package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortrayYourselfPage {

    private static WebElement element = null;

    public static WebElement PYTapTheOptionsToDescribeYourself(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/form/div[1]/h1"));
        return element;
    }

    public static WebElement PYfLookingFor(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"intent\"]/h2"));
        return element;
    }
}
