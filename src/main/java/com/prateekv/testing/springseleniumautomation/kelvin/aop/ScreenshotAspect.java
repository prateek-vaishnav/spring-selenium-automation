package com.prateekv.testing.springseleniumautomation.kelvin.aop;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.kelvin.annotation.TakeScreenshot;
import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Window;
import com.prateekv.testing.springseleniumautomation.kelvin.service.ScreenshotService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Aspect
public class ScreenshotAspect {

	@Autowired
	private ScreenshotService screenshotService;

	@Before("@annotation(takeScreenshot) && within(com.prateekv.testing.springseleniumautomation..*)")
	public void before(TakeScreenshot takeScreenshot) throws IOException {
		this.screenshotService.takeScreenShot();
	}
}
