package PageObjects.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActivateSubscriptionPage {
    private static WebElement element = null;

    public static WebElement as_laterButton(WebDriver driver) {
        element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/header[1]/div[1]/div[1]/div[1]/span[1]"));
        return element;
    }

    public static WebElement as_buySubscriptionButton(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@class='Button__button___2GX_6 Button__link___E_ERf Button__blue___1PGNk text-button rounded-6 color-white VipStepControl__link_center___33Aio']"));
        return element;
    }

    public static WebElement as_getFullAccessText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[@class='HeaderMainContentComponent__inner___2IrBU']"));
        return element;
    }

    public static WebElement as_UnlimitedLikesText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[14]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_attractMoreAttentionText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[14]//div[1]//p[1]"));
        return element;
    }

    public static WebElement as_seeWhoInterestedYouText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[12]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_knowWhoFavedYourProfileText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[12]//div[1]//p[1]"));
        return element;
    }

    public static WebElement as_seeWhoInterestedInYouText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[12]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_seeWhoViewedYouText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[11]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_keepAnEyeOnThePeopleText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[11]//div[1]//p[1]"));
        return element;
    }

    public static WebElement as_rewindYourLastActionText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[15]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_goBackAndLikeAgainText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[15]//div[1]//p[1]"));
        return element;
    }

    public static WebElement as_unlimitedGifts(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[16]//div[1]//h3[1]"));
        return element;
    }

    public static WebElement as_breakTheIceBySendingGiftsText(WebDriver driver) {
        element = driver.findElement(By.xpath("//div[16]//div[1]//p[1]"));
        return element;
    }

}






