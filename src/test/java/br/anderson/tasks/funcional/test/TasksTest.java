package br.anderson.tasks.funcional.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.anderson.tasks.resources.connectionDriver;

public class TasksTest {
	
	public WebDriver driver;
	@Before
	public void setup() {
		
		driver = new connectionDriver().startBrowser();
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		
		driver.findElement(By.id("addTodo")).click();
		driver.findElement(By.id("task")).sendKeys("Teste Funcional via Selenium");
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Sucess!", message);
	}
	
	@Test
	public void naoDeveSalvarTaskSemDescricao() {
		
		driver.findElement(By.id("addTodo")).click();
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2030");
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
	}
	
	@Test
	public void naoDeveSalvarTaskSemData() {
		
		driver.findElement(By.id("addTodo")).click();
		driver.findElement(By.id("task")).sendKeys("Teste Funcional via Selenium");
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the due date", message);
	}
	
	@Test
	public void naoDeveSalvarTaskComDataPassada() {
		
		driver.findElement(By.id("addTodo")).click();
		driver.findElement(By.id("task")).sendKeys("Teste Funcional via Selenium");
		driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
		driver.findElement(By.id("saveButton")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
	}
	
	@After
	public void tearDown() {
		
		driver.close();
	}

}
