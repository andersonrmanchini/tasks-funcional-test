package br.anderson.tasks.resources;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class connectionDriver {
	
	protected WebDriver driver;
	
	public WebDriver startBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("http://localhost:8010/tasks");
		
		return driver;
	}
}
