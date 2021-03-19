package br.anderson.tasks.resources;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class connectionDriver {
	
	protected WebDriver driver;
	protected ChromeOptions options;
	protected DesiredCapabilities dc;
	
	public WebDriver startBrowser() throws MalformedURLException {
		
		options = new ChromeOptions();
	    options.addArguments("--disable-infobars");
	    options.addArguments("--no-sandbox");
	    dc = new DesiredCapabilities();
	    dc.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(new URL("http://192.168.1.103:4444/wd/hub"), dc);
		
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://192.168.1.103:8001/tasks");
		
		return driver;
	}
}
