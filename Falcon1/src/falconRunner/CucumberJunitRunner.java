package falconRunner;

import java.io.IOException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.AfterSuite;
import com.github.mkolisnyk.cucumber.runner.BeforeSuite;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import cucumber.api.CucumberOptions;
import utils.Common;
import utils.Wrappers;

@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(
		jsonReport = "target/cucumberDefaultReports/cucumber.json", 
		retryCount = 0, 
		//overviewReport = true,
		outputFolder = "report/DATE(dd-MMM-yyyy)_DATE(hhmmss)",
		detailedReport = true
		)

@CucumberOptions(
		plugin = {"pretty","json:target/cucumberDefaultReports/cucumber.json" },
		features = {"resources/features"}, 
		glue = {"classpath:stepdefinitions"},
		tags = {"@RBTRAN21", "@CCMS" }
		)

public class CucumberJunitRunner {

	@BeforeSuite
	/**
	 * Description - To setup initial parameters before execution
	 * @param <null>
	 * @return void
	 */
	public static void setUp() throws Exception {
		new Wrappers().loadPropFile("config.properties");
		Common.testFilesPath=Wrappers.prop.getProperty("TestFilesPath");
		Common.countryToBeValidated=Wrappers.prop.getProperty("CountryCode");
		new Wrappers().loadFilePathsAndCountry();
	}

	@AfterSuite
	/**
	 * Description - To clear loaded properties after execution
	 * @param  <null>
	 * @return void
	 */
	public static void tearDown() {
	new Wrappers().flushProp();
	}

}
