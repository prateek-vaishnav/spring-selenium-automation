package com.prateekv.testing.springseleniumautomation.page.google;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class SearchResult extends Base {

	@FindBy(css = "div.g")
	private List<WebElement> results;

	public int getCount(){
		return this.results.size();
	}

	@Override
	public boolean isAt() {
		return this.wait.until((d) -> !this.results.isEmpty());
	}
}
