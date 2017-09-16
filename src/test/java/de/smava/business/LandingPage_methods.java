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
		System.out.println("Entering Get Quote");
		getCreditAmountDropDown().sendKeys(creditAmount);
		getCreditAmountDropDown().sendKeys(Keys.RETURN);
		getPeriodDropDown().sendKeys(period);
		Thread.sleep(1000);
		getPeriodDropDown().sendKeys(Keys.RETURN);
		getUseForDropDown().click();
		selectOptionsForUse(use);
		getCompareButton().click();
		System.out.println("END of getQuote Operation");
		
	}
	
	public void signIn(String username, String password){
		System.out.println("Signing in as "+username);
		try{
		getLoginLink().click();
		getUsername().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginButton().submit();
		}
		catch(Exception e){
			System.out.println("Element not visible");
			e.printStackTrace();
		}
	}
}
