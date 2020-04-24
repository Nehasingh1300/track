# Working with API
<ul>
<li>Checking for an element's presence</li>
<li>Checking for an element's state</li>
<li>Using Advanced User Interactions API for mouse and keyboard events</li>
<li>Performing double-click on an element</li>
<li>Performing drag-and-drop operations</li>
<li>Working with context menus</li>
<li>Executing the JavaScript code</li>
<li>Capturing screenshots with Selenium WebDriver</li>
<li>Maximizing the browser window</li>
<li>Handling session cookies</li>
<li>Working with browser navigation</li>
<li>Working with WebDriver events</li>
</ul>

## Checking an element's presence
```
@Test
public void testIsElementPresent() {
 // Check if element with locator criteria exists on Page
 if (isElementPresent(By.name("airbags"))) {
 // Get the checkbox and select it
 WebElement airbag =
driver.findElement(By.name("airbags"));
 if (!airbag.isSelected()) {
 airbag.click();
 }
 } else {
 fail("Airbag Checkbox doesn't exists!!");
 }
}
```

## Checking an element's state
```
Method                   Purpose
isEnabled()         This method checks if an element is enabled. It returns true if enabled, else false if disabled.
isSelected()        This method checks if an element is selected (radio button, checkbox, and so on). It returns true if selected, else false if deselected.
isDisplayed()       This method checks if an element is displayed.
```
## Using Advanced User Interactions API for mouse and keyboard events
```
@Test
public void testRowSelectionUsingControlKey() {
 List<WebElement> tableRows = driver.findElements (By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
 //Select second and fourth row from table using Control Key.
 //Row Index start at 0
 Actions builder = new Actions(driver);
 builder.click(tableRows.get(1)).keyDown(Keys.CONTROL).click(tableRows.get(3)).keyUp(Keys.CONTROL).build().perform();
 //Verify Selected Row table shows two rows selected
 List<WebElement> rows = driver.findElements(By.xpath("//div[@class='icePnlGrpexampleBox']/table[@class='iceDatTbl']/tbody/tr"));
 assertEquals(2,rows.size());
}
```

## Performing double-click on an element
```
package com.secookbook.examples.chapter04;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
import org.junit.Test;
public class DoubleClickTest {
 @Test
 public void testDoubleClick() throws Exception {
 WebDriver driver = new ChromeDriver();
 driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
 try {
 WebElement message = driver.findElement(By.id("message"));
 // Verify color is Blue
 assertEquals("rgba(0, 0, 255, 1)",
 message.getCssValue("background-color"));
 Actions builder = new Actions(driver);
 builder.doubleClick(message).perform();
 // Verify Color is Yellow
 assertEquals("rgba(255, 255, 0, 1)",
 message.getCssValue("background-color"));
 } finally {
 driver.quit();
 }
 }
}
```
