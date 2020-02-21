package POPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    void enterUserEmail(String email) {
        driver.findElement(By.name("email")).sendKeys("test.qwertyuiop@yopmail.com");

    }

    void enterUserPassword (String pass) {
        driver.findElement(By.name("password")).sendKeys("111111");
    }
    void clickSignIn(){
        driver.findElement(By.cssSelector("button[class*='Button']")).click();
    }
    void clickPassword(){}

    void open()
    {
        driver.get("m.meetville.com/login");
    }

    boolean atPage(){
        if (driver.getTitle().equals("Meetville")){
            return true;
        }
        else {
            return false;
        }
    }
}
