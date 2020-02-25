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

    public static WebElement pn_hamburger(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='HeaderIconComponent__icon_wrapper___3ZHUA']"));
        return element;
    }

    public static WebElement pn_ham_ActiveSubscription(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Activate Subscription')]"));
        return element;
    }

    public static WebElement pn_ham_favedMe(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Faved Me')]"));
        return element;
    }

    public static WebElement pn_ham_likedMe(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Liked Me')]"));
        return element;
    }

    public static WebElement pn_ham_viewedMe(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Viewed Me')]"));
        return element;
    }

    public static WebElement pn_ham_quickMatch(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Quick Match')]"));
        return element;
    }

    public static WebElement pn_ham_peopleNearby(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'People Nearby')]"));
        return element;
    }

    public static WebElement pn_ham_chats(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'Chats')]"));
        return element;
    }

    public static WebElement pn_ham_myFaves(WebDriver driver) {
        element = driver.findElement(By.xpath("//span[contains(text(),'My Faves')]"));
        return element;
    }

}
