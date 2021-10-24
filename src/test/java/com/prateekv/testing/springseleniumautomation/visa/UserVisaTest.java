package com.prateekv.testing.springseleniumautomation.visa;

import com.prateekv.testing.springseleniumautomation.SpringBaseTestNGTest;
import com.prateekv.testing.springseleniumautomation.entity.User;
import com.prateekv.testing.springseleniumautomation.page.visa.VisaRegistrationPage;
import com.prateekv.testing.springseleniumautomation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class UserVisaTest extends SpringBaseTestNGTest {

	private static final Logger logger = LoggerFactory.getLogger(UserVisaTest.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VisaRegistrationPage visaRegistrationPage;

	@Test(dataProvider = "getData")
	public void visaTest(User u){
			this.visaRegistrationPage.goTo();
			this.visaRegistrationPage.isAt();
			this.visaRegistrationPage.setNames(u.getFirstName(), u.getLastName());
			this.visaRegistrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
			this.visaRegistrationPage.setBirthDate(u.getDob().toLocalDate());
			this.visaRegistrationPage.setContactDetails(u.getEmail(), u.getPhone());
			this.visaRegistrationPage.setComments(u.getComments());
			this.visaRegistrationPage.submit();
			logger.info("Request Confirmation # INFO: " + this.visaRegistrationPage.getConfirmationNumber());
			logger.warn("Request Confirmation # WARN: " + this.visaRegistrationPage.getConfirmationNumber());
	}

	@DataProvider
	public Object[] getData(ITestContext context){
		return this.userRepository.findByDobBetween(
				Date.valueOf(context.getCurrentXmlTest().getParameter("dobFrom")),
						Date.valueOf(context.getCurrentXmlTest().getParameter("dobTo"))
				)
				.stream()
				.limit(2)
				.toArray();
	}
}
