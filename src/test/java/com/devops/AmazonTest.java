package com.devops;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTest {

	@Parameters("browser")
	@Test
	public void openAmazon(String browser) throws Exception {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--remote-allow-origins=*");

			driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("firefox");
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), cap);
		} else if (browser.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
		}

		// driver.get("https://www.amazon.com");
		driver.get("https://example.com/");
		System.out.println(browser + " Title: " + driver.getTitle());
		driver.quit();
	}
}