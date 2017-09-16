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
	
	@Test
	public void Test_0001_getLoanAmount_500_48_Gewerbe() {
		try {
			landingScreen.getQuote("500", "48", "Gewerbe");
			Assert.assertTrue(resultScreen.verifyQuote("500", "48", "Gewerbe"));
		} catch (Exception e) {
			e.printStackTrace(); }
	}

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
