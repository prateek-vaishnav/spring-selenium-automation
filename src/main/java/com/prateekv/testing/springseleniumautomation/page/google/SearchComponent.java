package com.prateekv.testing.springseleniumautomation.page.google;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.page.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class SearchComponent extends Base {

	@FindBy(name="q")
	private WebElement searchBox;

	@FindBy(name = "btnK")
	private List<WebElement> searchBtns;

	public void search(final String keyword){
		this.searchBox.sendKeys(keyword);
		this.searchBox.sendKeys(Keys.TAB);
		this.searchBtns
				.stream()
				.filter(e -> e.isDisplayed() && e.isEnabled())
				.findFirst()
				.ifPresent(WebElement::click);

	}
	@Override
	public boolean isAt() {
		return this.wait.until((d) -> this.searchBox.isDisplayed());
	}
}
