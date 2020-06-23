package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PhotoUploadPage {
    private static WebElement element = null;

    public static WebElement photoUploadUploadYourPhotos(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Upload Your Photos')]"));
        return element;
    }
}
