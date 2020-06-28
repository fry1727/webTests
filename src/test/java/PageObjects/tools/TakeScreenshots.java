package PageObjects.tools;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshots {

    public static void takeScreenshot(WebDriver driver, String name) throws IOException {
        if (driver instanceof TakesScreenshot) {
            File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(tempFile, new File(String.format("screenshots/%s.png", name)));
        }
    }
}
