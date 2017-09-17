/***
 * The Landing screen page object class. This provides all the web elements of landing page.
 * @project smava-Selenium
 * @author Veeragh.Goudar
 * @since Sep 17, 2017
 */
package de.smava.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage_page {
	public WebDriver driver;
	public LandingPage_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public By loanAmountDrpDwn = By.xpath(".//*[@id='myselect']//input[@class='search']");
	public By periodDrpDwn = By.xpath(".//*[@id='myselect2']//input[@class='search']");
	public By useForDrpDwn = By.xpath(".//*[@id='myselect3']//div[@class='text']");
	public By compareButton = By.id("loanSelectionForward");
	public By loginLink = By.xpath(".//*[@class='headex']//a[contains(string(),'Anmelden')][1]");
	public By username = By.xpath(".//*[@id='signonForm.email']");
	public By password = By.xpath(".//*[@id='signonForm.password']");
	public By loginButton = By.xpath(".//*[@id='signonForm.password']");

	public WebElement getCreditAmountDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loanAmountDrpDwn));
		return driver.findElement(loanAmountDrpDwn);
	}
	public WebElement getPeriodDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(periodDrpDwn));
		return driver.findElement(periodDrpDwn);
	}
	public WebElement getUseForDropDown() {
		return driver.findElement(useForDrpDwn);
	}
	public WebElement getCompareButton() {
		return driver.findElement(compareButton);
	}
	public void selectOptionsForUse(String option){
		WebElement optionsOfDropDown = driver.findElement(By.xpath(generateXpathForUseDropDown(option)));
		optionsOfDropDown.click();
	}
	public WebElement getLoginLink() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		return driver.findElement(loginLink);
	}
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	/*Dynamically generates xpath based on the option required*/
	private String generateXpathForUseDropDown(String option){
		String forUseOptionxpath;
		forUseOptionxpath = ".//*[@id='myselect3']/div/div[2]/div[contains(string(), '"+option+"')]";
		return forUseOptionxpath;
	}
}
