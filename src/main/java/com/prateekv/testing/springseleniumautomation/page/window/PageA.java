package com.prateekv.testing.springseleniumautomation.page.window;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Window;
import com.prateekv.testing.springseleniumautomation.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page A")
public class PageA extends Base {

	@FindBy(id = "area")
	private WebElement textArea;

	public void addToArea(final String msg){
		this.textArea.sendKeys(msg);
	}
	@Override
	public boolean isAt() {
		return this.wait.until((d)-> this.textArea.isDisplayed());
	}
}
