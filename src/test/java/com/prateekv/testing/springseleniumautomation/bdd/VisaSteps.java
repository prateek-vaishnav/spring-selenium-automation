package com.prateekv.testing.springseleniumautomation.bdd;

import com.prateekv.testing.springseleniumautomation.kelvin.annotation.LazyAutowired;
import com.prateekv.testing.springseleniumautomation.page.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

import java.time.LocalDate;

public class VisaSteps {

	@LazyAutowired
	private VisaRegistrationPage visaRegistrationPage;


		@Given("^I am on VISA registration form$")
		public void i_am_on_VISA_registration_form(){
			this.visaRegistrationPage.goTo();
			Assert.assertTrue(this.visaRegistrationPage.isAt());
		}
		@When("^I select my from country \"([^\"]*)\" and to country \"([^\"]*)\"$")
		public void i_select_my_from_country_and_to_country(String fromCountry, String toCountry){
			this.visaRegistrationPage.setCountryFromAndTo(fromCountry,toCountry);
		}

		@And("^I enter my dob as \"([^\"]*)\"$")
		public void i_enter_my_dob_as(String dateOfBirth){
			this.visaRegistrationPage.setBirthDate(LocalDate.parse(dateOfBirth));
		}

		@And("^I enter my name as \"([^\"]*)\" and \"([^\"]*)\"$")
		public void i_enter_my_name_as_and(String firstName, String lastName){
			this.visaRegistrationPage.setNames(firstName,lastName);
		}

		@And("^I enter my contact details as \"([^\"]*)\" and \"([^\"]*)\"$")
		public void i_enter_my_contact_details_as_and(String email, String phone){
			this.visaRegistrationPage.setContactDetails(email, phone);
		}

		@And("^I enter the comment \"([^\"]*)\"$")
		public void i_enter_the_comment(String comments){
			this.visaRegistrationPage.setComments(comments);
		}

		@And("^I submit the form$")
		public void i_submit_the_form(){
			this.visaRegistrationPage.submit();
		}

		@Then("^I should see the confirmation number$")
		public void i_should_see_the_confirmation_number(){
			Assert.assertFalse(StringUtils.isEmpty(this.visaRegistrationPage.getConfirmationNumber()));
		}

}
