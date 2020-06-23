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

    public static WebElement pYfLookingFor(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"intent\"]/h2"));
        return element;
    }

    public static  WebElement pYLookingForChat(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='intent']//li[1]//div[1]"));
        return element;
    }

    public static WebElement pYRelationshipHistoryNeverMarried(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='relationshipStatus']//li[1]//div[1]"));
        return element;
    }

    public static WebElement pYDoYouHaveKidsNo(WebDriver driver) {
        element= driver.findElement(By.xpath("//div[@id='kidsAtHome']//li[1]//div[1]"));
        return element;
    }
     public static  WebElement pYDoYouWantChildrenNo(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='wantsKids']//li[1]//div[1]"));
        return element;
     }

     public static WebElement pYEthnicityIndian(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='ethnicity']//li[6]//div[1]"));
        return element;
     }
     public static WebElement pYReligionAgnostic(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='religion']//li[1]//div[1]"));
        return element;
     }
     public static WebElement pYEducationNoDegree(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='education']//li[1]//div[1]"));
        return element;
     }
     public static WebElement pyBodyTypeAverage(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@id='bodyType']//li[1]//div[1]"));
        return element;
     }

     public static WebElement pYSmokingNo(WebDriver driver){
        element = driver.findElement(By.xpath("//*[@id='smokes']/ul/li[1]/div[1]"));
        return element;
     }

     public static WebElement pYDrinkingNo(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@id='drinks']//li[1]//div[1]"));
        return element;
     }

     public static WebElement pYHeightScale(WebDriver driver) {                     //линейка роста
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/form/div[2]/div[11]/div[3]/div/div"));
        return element;
     }

     public static WebElement pYSaveAndContinueButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/main/form/div[4]/div/button"));
        return element;
     }



}
