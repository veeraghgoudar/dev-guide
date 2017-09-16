package de.smava.business;

import org.openqa.selenium.WebDriver;

import de.smava.page.ResultPage_page;

public class ResultPage_methods extends ResultPage_page {

	public ResultPage_methods(WebDriver driver) {
		super(driver);
	}

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
	public Boolean verifyForUserAccessDenial(){
		System.out.println(getErrorSection().getText());
		//if(getErrorSection().getText().equalsIgnoreCase("Ihre Angaben zum Einloggen sind ungültig. Bitte versuchen Sie es erneut. Bitte beachten Sie, dass Ihr Zugang bei 3 Fehlversuchen von uns vorläufig gesperrt wird.")){
		if(getErrorSection().getText().equalsIgnoreCase("Der Zugang für diesen Benutzernamen ist deaktiviert.")){
			return true;
		}else{
			return false; }
	}
	public void  goToHomeScreen() {
		getHomeScreenLogo().click();
	}
}
