package com.prateekv.testing.springseleniumautomation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
		features = "classpath:features",
		glue = "com.prateekv.testing.springseleniumautomation.bdd",
		tags = "@visa",
		plugin = {"pretty","html:/Users/pvaishna/Documents/udemy/temp/index.html"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
