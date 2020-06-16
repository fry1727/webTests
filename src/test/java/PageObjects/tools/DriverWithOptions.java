package PageObjects.tools;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverWithOptions {
    public ChromeDriver driver;

    public ChromeDriver diverOpt() {
        System.setProperty("webdriver.chrome.driver", "src/recources/chromedriver83Mac");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); //1-Allow, 2-Block, 0-default
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--no-sandbox");
        //options.addArguments("useragent = Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");
        //options.addArguments("--headless");
        options.addArguments("disable-gpu");
        options.addArguments("window-size=1400,2100"); // Linux should be activate
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
