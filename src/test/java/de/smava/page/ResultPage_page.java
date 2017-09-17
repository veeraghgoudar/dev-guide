/**
 * The Result screen page object class. The provides all the elements of result page.
 * @project smava-Selenium
 * @author Veeragh.Goudar
 * @since Sep 17, 2017
 */

package de.smava.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage_page{

	public WebDriver driver;

	public ResultPage_page(WebDriver driver) {
		this.driver = driver;
	}

	public By loanAmountDrpDwnXpath = By.xpath(".//*[@id='category']");
	public By periodDrpDwnXpath = By.xpath(".//*[@id='amount']");
	public By useForDrpDwnXpath = By.xpath(".//*[@id='term']");
	public By homeLogo = By.xpath(".//*[@id='main_logo_image']");
	public By nextButton = By
			.xpath(".//*[@id='x-application']//span[contains(string(),'Weiter' )]");
	public By firstNameInput = By.xpath(".//*[@id='firstname']");
	public By errorSection = By
			.xpath(".//*[@id='layout-wrapper']//div[@class='box-inner']//ul/li");

	public Select getLoanAmount_result() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(loanAmountDrpDwnXpath));
		Select loanAmountDrpDwn = new Select(
				driver.findElement(loanAmountDrpDwnXpath));
		return loanAmountDrpDwn;
	}

	public Select getPeriodDrpDwn_result() {
		Select periodDrpDwn = new Select(driver.findElement(periodDrpDwnXpath));
		return periodDrpDwn;
	}

	public Select getUseForDrpDwn_result() {
		Select useForDrpDwn = new Select(driver.findElement(useForDrpDwnXpath));
		return useForDrpDwn;
	}

	public WebElement getHomeScreenLogo() {
		return driver.findElement(homeLogo);
	}

	public WebElement getNextButton() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		return driver.findElement(nextButton);
	}

	public WebElement getFirstNameInputBox() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(firstNameInput));
		return driver.findElement(firstNameInput);
	}

	public WebElement getErrorSection() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(errorSection));
		return driver.findElement(errorSection);
	}
}
