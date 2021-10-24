package com.prateekv.testing.springseleniumautomation.page.window;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class MainPage extends Base {

	@FindBy(tagName = "a")
	private List<WebElement> links;

	public void goTo(){
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
	}

	public void launchAllWindows(){
		for(WebElement link:links) {
			link.click();
		}
	}

	@Override
	public boolean isAt() {
		return this.wait.until((d) -> !this.links.isEmpty());
	}
}
