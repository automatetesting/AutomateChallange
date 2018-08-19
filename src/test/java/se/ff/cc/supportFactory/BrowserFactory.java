package se.ff.cc.supportFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;

//import org.testng.TestNG


public class BrowserFactory {

    public static WebDriver selectLocalBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.out.println("Opening CHROME browser");
            System.setProperty("webdriver.chrome.driver", "src\\test\\java\\se\\ff\\cc\\drivers\\chromedriver.exe");
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.out.println("Opening FIREFOX browser");
            System.setProperty("webdriver.gecko.driver", "src\\test\\java\\se\\ff\\cc\\drivers\\geckodriver.exe");
//                FirefoxOptions option = new FirefoxOptions();
//                option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.out.println("Opening IE browser");
            System.setProperty("webdriver.ie.driver", "src\\test\\java\\se\\ff\\cc\\drivers\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            System.out.println("Opening OPERA browser");
            System.setProperty("webdriver.opera.driver", "src\\test\\java\\se\\ff\\cc\\drivers\\operadriver.exe");
            OperaOptions options = new OperaOptions();
            options.setBinary("C:\\Program Files\\Opera\\51.0.2830.55\\opera.exe");
            return new OperaDriver(options);
        } else if (browser.equalsIgnoreCase("Safari")) {
            return new SafariDriver();
        } else
            throw new WebDriverException("No browser specified");
    }
}

