package com.prateekv.testing.springseleniumautomation.page.google;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.Page;
import com.prateekv.testing.springseleniumautomation.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;

@Page
public class GooglePage extends Base {

	@Lazy
	@Autowired
	private SearchComponent searchComponent;

	@Lazy
	@Autowired
	private SearchResult searchResult;

	@Value("${application.url}")
	private String url;

	public void goTo(){
	this.driver.get(url);
	}

	public void closeBrowser(){
		this.driver.quit();
	}

	public SearchComponent getSearchComponent() {
		return searchComponent;
	}

	public SearchResult getSearchResult() {
		return searchResult;
	}

	@Override
	public boolean isAt() {
		return this.searchComponent.isAt();
	}
}
