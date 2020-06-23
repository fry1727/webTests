package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InterestsRegistrationPage {
    private static WebElement element = null;

    public static WebElement interestsPickUpAtLeast5Interests (WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id='app-root']/div/main/div[2]/div[1]/h1"));
        return element;
    }
    public static WebElement interestsCampingHiking(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Camping')]"));
        return element;
    }
    public static WebElement interestsCharity(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Charity')]"));
        return element;
    }
    public static WebElement interestsCollecting (WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Collecting')]"));
        return element;
    }
    public static WebElement interestsCoking(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Cooking')]"));
        return element;
    }
    public static WebElement interestsCycling(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Cycling')]"));
        return element;
    }
    public static WebElement interestsDance(WebDriver driver) {
        element = driver.findElement(By.xpath("//p[contains(text(),'Dance')]"));
        return element;
    }
    public static WebElement interestsContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/div[2]/div[4]/div/button"));
        return element;
    }
}
