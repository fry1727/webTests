package Avanta.com.Meetville;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PortrayYourselfPage {
    private  WebDriver driver;

    public PortrayYourselfPage(WebDriver driver) {
        this.driver = driver;
    }

    private By portrayYourselfHeader = By.xpath("//*[@id=\"app-root\"]/div/main/form/div[1]/h1");

    public String getPortrayYourselfHeaderText () {
        return driver.findElement(portrayYourselfHeader).getText();
    }
}
