package se.ff.cc.supportFactory;




import org.openqa.selenium.WebDriver;
import se.ff.cc.webDriver.Driver;

import java.net.URL;

public class WebdriverFactory {

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Cleaning up the browser");
            try {
                Driver.webdriver.quit();
            } catch (NullPointerException e) {
                System.out.println("Browser already shut down.");
            }
        }
    }

    public static WebDriver createWebdriver(String browser) {
        Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
        return BrowserFactory.selectLocalBrowser(browser);
    }


}
