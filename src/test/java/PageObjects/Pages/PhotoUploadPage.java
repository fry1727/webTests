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

    public static WebElement photoUploadAddPhotoButton (WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@class='display_none']"));
        return element;
    }

    public static WebElement photoUploadSaveAndContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/div/div[6]/div/button"));
        return element;
    }
}