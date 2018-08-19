package se.ff.cc.stepDef;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import se.ff.cc.browserStack.TestBase;
import se.ff.cc.webDriver.Driver;

import java.util.Collections;
import java.util.List;


public class Hooks {
    private static Boolean runOnce = false;
    public static ExtentReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static Scenario scenario;


    @Before(order = 1)
    public void before(Scenario scenario) {
        System.out.println("this is Before Scenario");
        scenario = scenario;

        List sname = Collections.singletonList(scenario.getName());

    }

    @BeforeSuite
    public void beforesuite(){
        System.out.println("this should run only once");
    }

    @Before(order = 2)
    public void setup() {
        System.out.println("this is BEFORE running");
        htmlReporter = new ExtentHtmlReporter("C:\\Users\\hsidhu\\Documents\\AutomationProjects\\Demo\\BDD-Parallel-stack\\CucumberParallel\\reports\\myreport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterMethod(alwaysRun = true)
    public void getResults(ITestResult result) {
        System.out.println("this is after Method running");
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(MarkupHelper.createLabel(result.getName() + "Test failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(MarkupHelper.createLabel(result.getName() + "Test failed", ExtentColor.GREEN));
        }
    }


    @AfterClass
    public void after(Scenario scenario) {
        System.out.println("this is after Class running");
        if (scenario.isFailed()) {
            //take screenshot
            try {
                Driver.takeScreenshot("fail");
                Driver.embedScreenshot(scenario);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    @After(order=1)
    public void teardown() {
        System.out.println("this is After - order 1 running");
        extent.flush();
    }

    @After(order=2)
    public void cleanup(Scenario scenario) {

        System.out.println("this is After - order 2 running");
        if (Driver.webdriver != null){
            Driver.webdriver.quit();
            System.out.println("Local Browser closed successfully");
        }
        if(TestBase.webdriver != null){
            TestBase.webdriver.quit();
            System.out.println("Browserstack Browser closed successfully");
        }

        if (scenario.isFailed()) {
            //take screenshot
            try {
                Driver.takeScreenshot("fail");
                Driver.embedScreenshot(scenario);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}



