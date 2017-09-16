package de.smava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

	public WebDriver driver;
	public Properties configFile;

	public WebDriver getDriver() {
		return driver;
	}

	public void readPropertyFile() throws IOException {
		try {
			configFile = new Properties();
			FileInputStream ip = new FileInputStream(
					"src/main/java/de/smava/config/config.properties");
			configFile.load(ip);
			System.out.println("load config propeties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setup() throws IOException {
		readPropertyFile();

		switch (configFile.getProperty("browser")) {
		case "firefox":
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			break;

		case "chrome":
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			break;

		case "ie":
			InternetExplorerDriverManager.getInstance().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			break;
		}

		String url = configFile.getProperty("url");
		driver.get(url);
		// driver.manage().window().maximize();
	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}
