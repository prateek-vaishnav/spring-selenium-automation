package com.prateekv.testing.springseleniumautomation.kelvin.config;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.ThreadScopeBean;
import com.prateekv.testing.springseleniumautomation.kelvin.annotation.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

	@ThreadScopeBean
	@ConditionalOnProperty(name = "browser", havingValue = "firefox")
	public WebDriver firefoxDriver(){
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	@ThreadScopeBean
	@ConditionalOnMissingBean
	public WebDriver chromeDriver(){
		WebDriverManager.chromedriver().version("94.0.4606.61").setup();
		return new ChromeDriver();
	}
}
