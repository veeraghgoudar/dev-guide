/***
 * The class provides all the actions which could be performed on the Result page
 * The class extends ResultPage_page class which provides all the web elements
 * @project smava-Selenium
 * @author Veeragh.Goudar
 * @since Sep 17, 2017
 */
package de.smava.business;

import org.openqa.selenium.WebDriver;

import de.smava.page.ResultPage_page;

public class ResultPage_methods extends ResultPage_page {

	public ResultPage_methods(WebDriver driver) {
		super(driver);
	}

	/*The method verifies whether the use of credit selected in the landing page
	 * appears on the result page as well. 
	 * Returns true if the text is matched, else returns false */
	public Boolean verifyQuote(String creditAmount, String period, String use) {
		System.out.println("Entering verifyQuote");
		Boolean flag = false;
		getLoanAmount_result().getFirstSelectedOption().getText();
		getPeriodDrpDwn_result().getFirstSelectedOption().getText();
		getUseForDrpDwn_result().getAllSelectedOptions();
		if (getLoanAmount_result().getFirstSelectedOption().getText()
				.equalsIgnoreCase(use)) {
			flag = true;
		} else {
			flag = false;
		}
		getHomeScreenLogo().click();
		return flag;
	}

	public void clickNextButton() {
		getNextButton().click();
	}
	public Boolean verifyWhetherPersonDetailsDisplayed(){
		return (getFirstNameInputBox().isDisplayed());
	}
	
	public Boolean verifyIfErrorSectionIsDisplayed(){
		return (getErrorSection().isDisplayed());
	}
	/*Verifies for the error text which appears on the screen*/
	public Boolean verifyForUserAccessDenial(){
		System.out.println(getErrorSection().getText());
		//if(getErrorSection().getText().equalsIgnoreCase("Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird.")){
		if(getErrorSection().getText().equalsIgnoreCase("Der Zugang für diesen Benutzernamen ist deaktiviert.")){
			goToHomeScreen();
			return true;
		}else{
			goToHomeScreen();
			return false; }
	}
	public void  goToHomeScreen() {
		getHomeScreenLogo().click();
	}
}
