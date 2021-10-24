package com.prateekv.testing.springseleniumautomation.kelvin.aop;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Window;
import com.prateekv.testing.springseleniumautomation.kelvin.service.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class WindowAspect {

	@Autowired
	private WindowSwitchService windowSwitchService;

	@Before("@target(window) && within(com.prateekv.testing.springseleniumautomation..*)")
	public void before(Window window){
		this.windowSwitchService.switchByTitle(window.value());
	}

	@After("@target(window) && within(com.prateekv.testing.springseleniumautomation..*)")
	public void after(Window window){
		this.windowSwitchService.switchByIndex(0);
	}
}
