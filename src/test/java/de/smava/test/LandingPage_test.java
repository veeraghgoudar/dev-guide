/**
 * This is test class which extends the Base class. 
 * Creates the instance of page object methods classes performs action through webdriver.
 * Follows the TestNG annotation approach 
 * @project smava-Selenium
 * @author Veeragh.Goudar
 * @since Sep 17, 2017
 */



package de.smava.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import de.smava.Base;
import de.smava.business.LandingPage_methods;
import de.smava.business.ResultPage_methods;

public class LandingPage_test extends Base {
	private LandingPage_methods landingScreen;
	private ResultPage_methods resultScreen;

	@BeforeMethod
	public void LoadPageObjects(){
		 landingScreen = PageFactory.initElements(driver,LandingPage_methods.class);
		 resultScreen = PageFactory.initElements(driver,ResultPage_methods.class);
	}
	/* Test case for the Quote of 500 for the period of 48 Months for Business use*/
	@Test
	public void Test_0001_getLoanAmount_500_48_Gewerbe() {
		try {
			landingScreen.getQuote("500", "48", "Gewerbe");
			Assert.assertTrue(resultScreen.verifyQuote("500", "48", "Gewerbe"));
		} catch (Exception e) {
			e.printStackTrace(); }
	}
	
	/* Test case for the Quote of 2750 for the period of 24 Months for living.
	 * Also, verifies whether by clicking on Next & verifies whether the page is loaded*/
	@Test
	public void Test_0002_getLoanAmount_2750_24_Wohnen() {
		System.out.println("Executing SECOND test CASE");
		try {
			landingScreen.getQuote("2750", "24", "Wohnen");
			resultScreen.clickNextButton();
			Assert.assertTrue(resultScreen.verifyWhetherPersonDetailsDisplayed());
			resultScreen.goToHomeScreen();
		} catch (Exception e) {
			e.printStackTrace(); }
	}
	
	/* Test case to check invalid credentials sign-in feature. 
	 * Verifies the error message with Access denied message */
	@Test
	public void Test_0003_Login_by_Invalid_Credentials() {
		System.out.println("Executing Test_0003_Login_by_Access_Denied_User");
		try {
			landingScreen.signIn("test@gmail.com", "wrongpassword");
			Assert.assertTrue(resultScreen.verifyForUserAccessDenial());
		} catch (Exception e) {
			e.printStackTrace(); }
	}
}
