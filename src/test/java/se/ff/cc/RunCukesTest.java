package se.ff.cc;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

//@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/report.html"})
public class RunCukesTest extends AbstractTestNGCucumberTests {

}
