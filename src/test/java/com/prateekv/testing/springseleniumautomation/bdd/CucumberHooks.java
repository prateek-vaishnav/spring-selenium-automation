package com.prateekv.testing.springseleniumautomation.bdd;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.LazyAutowired;
import com.prateekv.testing.springseleniumautomation.kelvin.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

	@LazyAutowired
	private ScreenshotService screenshotService;

	@LazyAutowired
	private ApplicationContext ctx;

	@AfterStep
	public void afterStep(Scenario scenario){
		if(scenario.isFailed()){
			scenario.attach(this.screenshotService.getScreenShot(),"image/png",scenario.getName());
		}
	}

	@After
	public void afterScenario(){
		this.ctx.getBean(WebDriver.class).quit();
	}
}
