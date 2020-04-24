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
## Performing drag-and-drop operations
```
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
```
 
 ## Context Menu
 A context menu (also known as a shortcut, a popup, or a pop-up menu) is a menu displayed on a web page that appears when a user performs a right-click mouse operation.<br>
```
@Test
public void testContextMenu() {
	  WebElement clickMeElement =
	  driver.findElement(By.cssSelector("div.context-menuone.box.menu-1"));
	  WebElement editMenuItem = driver.findElement(By.cssSelector("li.context-menuitem.icon-edit"));
	  Actions builder = new Actions(driver);
	  builder.contextClick(clickMeElement).moveToElement(editMenuItem).click().perform();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	  assertEquals("clicked: edit", alert.getText());
	  alert.dismiss();
}
```
## Executing the JavaScript code
```
@Test
public void testJavaScriptCalls() throws Exception {
 WebDriver driver = new ChromeDriver();
 driver.get("http://www.google.com");
 try {
 JavascriptExecutor js = (JavascriptExecutor) driver;
 String title = (String) js.executeScript("return document.title");
 assertEquals("Google", title);
 long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
 assertEquals(42, links);
 } finally {
 driver.quit();
 }
}
```
## Capturing screenshots with Selenium WebDriver -> Chapter 9 
Selenium WebDriver provides the TakesScreenshot interface to capture a screenshot of a web page. This helps in test runs, showing exactly what happened when an exception or error has occurred during execution, and so on. <br>
Let's create a test that will open our test application and take a screenshot of the page in PNG **(Portable Network Graphics) format**, as shown in the following code example:

```@Test
public void testTakesScreenshot() throws Exception {
 File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(scrFile, new File("target/main_page.png"));
}
```

## Maximizing the browser window
```
driver = new FirefoxDriver();
driver.manage().window().maximize();
```

## Handling session cookies
```
Method                                   Description
addCookie(Cookie cookie)                This method adds a cookie.
getCookieNamed(String name)             This method returns the cookie with a specified name.
getCookies()                            This method returns all the cookies for current domain.
deleteCookieNamed(String name)          This method deletes the cookie with a specified name.
deleteCookie(Cookie cookie)             This method deletes a cookie.
deleteAllCookies()                      This method deletes all the cookies for current domain.
```

## Working with browser navigation
```
Method                                  Description
back()                                  This method moves back to the page in browser history.
forward()                               This method moves forward to the page in browser history.
refresh()                               This method reloads the current page.
to(String url)                          This method loads the specified URL in the current browser window.
to(java.net.URL url)
```
## Working with WebDriver events
```
Event                                   Description
beforeNavigateTo                        This method is called before the get(String url) or the navigate().to(String url) method is called.
afterNavigateTo                         This method is called after the get(String url) or the navigate().to(String url) method is called.
beforeNavigateBack                      This method is called before the navigate().back()method.
afterNavigateBack                       This method is called after the navigate().back()method.
beforeNavigateForward                   This method is called before the navigate().forward() method.
afterNavigateForward                    This method is called after the navigate().forward()method.
beforeFindBy                            This method is called before the following methods: WebDriver.findElement(...), WebDriver.findElements(...), WebElement.findElement(...), WebElement.findElements(...)
afterFindBy                             This method is called after the following methods: WebDriver.findElement(...), WebDriver.findElements(...), WebElement.findElement(...), WebElement.findElements(...)
beforeChangeValueOf                     This method is called before the WebElement.clear() or the WebElement.sendKeys(...) method.
afterChangeValueOf                      This method is called after the WebElement.clear() or the WebElement.sendKeys(...) method.
beforeClickOn                           This method is called before the WebElement.click()method.
afterClickOn                            This method is called after the WebElement.click()method.
beforeScript                            This method is called before the RemoteWebDriver. executeScript(java.lang.String, java.lang.Object[]) method.
afterScript                             This method is called after the RemoteWebDriver.executeScript(java.lang.String, java.lang.Object[]) method.
onException                             This method is called whenever an exception would be thrown.
```
