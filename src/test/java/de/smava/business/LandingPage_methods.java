/***
 * The class provides all the actions which could be performed in the landing page
 * The class extends LandingPage_page class which provides all the web elements
 * @project smava-Selenium
 * @author Veeragh.Goudar
 * @since Sep 17, 2017
 */

package de.smava.business;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import de.smava.page.LandingPage_page;


public class LandingPage_methods extends LandingPage_page{

	public LandingPage_methods(WebDriver driver) {
		super(driver);
		//Calling the constructor of super class
	}
	
	public void getQuote(String creditAmount, String period, String use) throws InterruptedException{
		try{
			getCreditAmountDropDown().sendKeys(creditAmount);
			getCreditAmountDropDown().sendKeys(Keys.RETURN);
			getPeriodDropDown().sendKeys(period);
			Thread.sleep(1000);
			getPeriodDropDown().sendKeys(Keys.RETURN);
			getUseForDropDown().click();
			selectOptionsForUse(use);
			getCompareButton().click();
		}
		catch(Exception e){
			e.printStackTrace(); }
	}
	
	public void signIn(String username, String password){
		try{
			getLoginLink().click();
			getUsername().sendKeys(username);
			getPassword().sendKeys(password);
			getLoginButton().submit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
