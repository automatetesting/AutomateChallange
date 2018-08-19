import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.File;


@CucumberOptions(
        strict = true,
        features = {"C:/Users/hsidhu/Documents/AutomationProjects/Demo/BDD-Parallel-stack/CucumberParallel/src/test/resources/se/ff/cc/f2.feature"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:C:/Users/hsidhu/Documents/AutomationProjects/Demo/BDD-Parallel-stack/CucumberParallel/target/2.html"},
        monochrome = false,
        tags = {"@smoke"},
        glue = {"se.ff.cc"})
public class Parallel02IT extends AbstractTestNGCucumberTests {

public static Scenario scenario;

    @BeforeClass
    public static void beforeClass(){
      //Do things
    }

    @AfterClass
    public static void afterClass(){
      Reporter.loadXMLConfig(new File("reports/extent-xml/extent-config.xml"));
        Reporter.setSystemInfo("OS", System.getProperty("os.name"));
        Reporter.setSystemInfo("Project Name", "Sopra Steria demo Project");
        Reporter.setSystemInfo("Environment", "QA - demo");
        Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
        Reporter.setSystemInfo("User Time zone", System.getProperty("user.timezone"));
        Reporter.setTestRunnerOutput("This is Sidhu here");
    }
}