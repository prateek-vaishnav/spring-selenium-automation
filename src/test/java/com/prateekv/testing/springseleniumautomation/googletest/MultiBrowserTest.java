package com.prateekv.testing.springseleniumautomation.googletest;

import com.prateekv.testing.springseleniumautomation.SpringBaseTestNGTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class MultiBrowserTest extends SpringBaseTestNGTest {

	@Autowired
	private ApplicationContext ctx;

	@Test
	public void browserTest(){
		this.ctx.getBean("chromeDriver", WebDriver.class);
		this.ctx.getBean("firefoxDriver", WebDriver.class);

	}
}
