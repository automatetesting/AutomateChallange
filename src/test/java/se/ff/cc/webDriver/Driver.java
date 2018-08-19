package se.ff.cc.webDriver;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import se.ff.cc.supportFactory.WebdriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver webdriver;
    public static String currentbrowser;

    public synchronized static WebDriver getCurrentDriver(String browser) {

//		if (webdriver == null) {
//			webdriver = WebdriverFactory.createWebdriver(browser);
//			webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		}
        currentbrowser = browser;

        webdriver = WebdriverFactory.createWebdriver(browser);
        return webdriver;
    }
    public static String takeScreenshot(String filename) throws IOException {

        try {
            File file = ((TakesScreenshot) getCurrentDriver(Driver.currentbrowser)).getScreenshotAs(OutputType.FILE);
            String filePath = ("./screenshot/" + filename + ".jpg");
            FileUtils.copyFile(file, new File(filePath));
            return filePath;
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            return null;
        }
    }

    public static void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) getCurrentDriver(Driver.currentbrowser)).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
    }

}
