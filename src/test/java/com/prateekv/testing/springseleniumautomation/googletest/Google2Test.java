package com.prateekv.testing.springseleniumautomation.googletest;

import com.prateekv.testing.springseleniumautomation.SpringBaseTestNGTest;
import com.prateekv.testing.springseleniumautomation.kelvin.annotation.LazyAutowired;
import com.prateekv.testing.springseleniumautomation.page.google.GooglePage;
import com.prateekv.testing.springseleniumautomation.kelvin.service.ScreenshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Google2Test extends SpringBaseTestNGTest {

	@LazyAutowired
	private GooglePage googlePage;

	@LazyAutowired
	private ScreenshotService screenshotService;

	@Test
	public void googleTest() throws IOException {
		this.googlePage.goTo();
		Assert.assertTrue(this.googlePage.isAt());
		this.googlePage.getSearchComponent().search("selenium");
		Assert.assertTrue(this.googlePage.getSearchResult().isAt());
		Assert.assertTrue(this.googlePage.getSearchResult().getCount() > 2);
		this.screenshotService.takeScreenShot();
		this.googlePage.closeBrowser();
	}
}
