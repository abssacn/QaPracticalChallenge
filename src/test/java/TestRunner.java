import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.QaPracticalChallange.utils.FileReaderWriteManager;
import org.QaPracticalChallange.utils.SeleniumDriverMethods;
import org.junit.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(
        features = "src/test/",
        glue = {"org/QaPracticalChallange/stepDefinition"},
        tags = {"@flightBooking"},
        format = { "json:target/QaPracticalChallange.json", "pretty",
                "html:target/QA_CHALLENGE" },
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html.target/cucumber-reports/report.html"}
)

public class TestRunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(final CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderWriteManager.getInstance().getConfigReader().getReportConfigPath()));
        SeleniumDriverMethods.tearDown();
    }

}