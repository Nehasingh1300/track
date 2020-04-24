package com.secookbook.examples.chapter4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
public class DoubleClickTest {
	private WebDriver driver;
	@Test
	public void testDragDrop() {
     System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Neha\\\\Documents\\\\sem4\\\\BRM\\\\chromedriver_win32\\\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");
	 WebElement source = driver.findElement(By.id("draggable"));
	 WebElement target = driver.findElement(By.id("droppable"));
	 Actions builder = new Actions(driver);  // calling the instance of action class which help in drag and drop
	 builder.dragAndDrop(source, target) .perform();  // in drag and drop we need source and target element & perform() is used to compile and execute the actions class
	 //OUTPUT | Dropped!
	 assertEquals("Dropped!", target.getText());
	 }
}
	
