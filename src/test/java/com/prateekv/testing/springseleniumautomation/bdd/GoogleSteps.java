package com.prateekv.testing.springseleniumautomation.bdd;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.LazyAutowired;
import com.prateekv.testing.springseleniumautomation.page.google.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@CucumberContextConfiguration
@SpringBootTest
public class GoogleSteps {

	@LazyAutowired
	private GooglePage googlePage;

	@Given("^I am on the google site$")
	public void i_am_on_the_google_site(){
		this.googlePage.goTo();
	}
	@When("^I enter \"([^\"]*)\" as a keyword$")
	public void i_enter_as_a_keyword(String keyword){
		this.googlePage.getSearchComponent().search(keyword);
	}
	@Then("^I should see search results page$")
	public void i_should_see_search_results_page(){
		Assert.assertTrue(this.googlePage.getSearchResult().isAt());
	}
	@Then("I should see at least {int} results")
	public void i_should_see_at_least_results(int count){
		Assert.assertTrue(this.googlePage.getSearchResult().getCount() >=count);
	}

}
