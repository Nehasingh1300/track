# Working with Elements
**Chapter Review**
<ul> 
<li>Automating textboxes, text areas, and buttons</li>
 <li>Checking an element's text</li>
 <li>Checking an element's attribute and CSS values</li>
<li> Automating dropdowns and lists</li>
<li> Checking options in dropdowns and lists</li>
<li> Checking selected options in dropdowns and lists</li>
<li> Automating radio buttons and radio groups</li>
<li> Automating checkboxes</li>
<li> Working with WebTables</li></ul>

## Automating textboxes, text areas, and buttons\
**clear(), sendKeys(), submit() and click()**

```
// Find the text input element by its name
WebElement element = driver.findElement(By.name("q"));
// Clear the existing text value
element.clear();
// Enter something to search for
element.sendKeys("Selenium testing tools cookbook");
// Now submit the form. WebDriver will find
// the form for us from the element
element.submit();
// Find the button element by its name
WebElement element = driver.findElement(By.name("btnG"));
// Click on the button
element.click();

//non text keys
element.sendKeys("123" + Keys.TAB);
```

## Checking an element's text

```
@Test
public void testElementText() {
 // Get the message Element
 WebElement message = driver.findElement(By.id("message"));
 // Get the message elements text
 String messageText = message.getText();
 // Verify message element's text displays "Click on me and my
 // color will change"
 assertEquals("Click on me and my color will change",
 messageText);
 // Get the area 
  WebElement area = driver.findElement(By.id("area"));
 // Verify area element's text displays "Div's Text\nSpan's Text"
 assertEquals("Div's Text\nSpan's Text", area.getText());
}
 ```
 
 ## Checking an element's attribute and CSS values
```
@Test
public void testElementAttribute() {
 WebElement message = driver.findElement(By.id("message"));
 assertEquals("justify", message.getAttribute("align"));
}

@Test
public void testElementStyle() {
 WebElement message = driver.findElement(By.id("message"));
 String width = message.getCssValue("width");
 assertEquals("150px", width);
}
```

## Automating dropdowns and lists
```
@Test
public void testDropdown() {
 // Get the Dropdown as a Select using it's name attribute
 Select make = new Select(driver.findElement(By.name("make")));
 // Verify Dropdown does not support multiple selection
 assertFalse(make.isMultiple());
 // Verify Dropdown has four options for selection
 assertEquals(4, make.getOptions().size());
 // With Select class we can select an option in Dropdown using
Visible text
 make.selectByVisibleText("Honda");
 assertEquals("Honda", make.getFirstSelectedOption().getText());
  // or we can select an option in Dropdown using value attribute
 make.selectByValue("audi");
 assertEquals("Audi", make.getFirstSelectedOption().getText());
 // or we can select an option in Dropdown using index
 make.selectByIndex(0);
 assertEquals("BMW", make.getFirstSelectedOption().getText());
}
```
## Selecting and deselecting Elements
```
<select name="color" size="6" multiple="multiple"
 style="width:100px">
 <option value="bl">Black</option>
 <option value="wt">White</option>
 <option value="rd">Red</option>
 <option value="br">Brown</option>
 <option value="sl">Silver</option>
</select>
```
Each option in this <select> element has a value property as well as a text label specified between <option> and </option>. We can select an option using this text label by calling the selectByVisibleText() method of the Select class, as shown in the following code:

```color.selectByVisibleText("Black");```

Similarly, you can deselect an already selected option by calling the deselectByVisibleText() method, as shown in the following code:

```color.deselectByVisibleText("Black");```
