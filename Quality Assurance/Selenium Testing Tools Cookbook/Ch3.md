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

## Deselecting Options
```
@Test
public void testMultipleSelectList()
{
 ...
 //Select multiple options in the list using visible text
 color.selectByVisibleText("Black");
 color.selectByVisibleText("Red");
 color.selectByVisibleText("Silver");
 //We will verify list has multiple options selected as listed
 //in a array
 List<String> expectedSelection = Arrays.asList
 ("Black", "Red", "Silver");
 List<String> actualSelection = new ArrayList<String>();
 for(WebElement option : color.getAllSelectedOptions())
 {actualSelection.add(option.getText()); }
 //Verify expected array for selected options match with actual
 //options selected
 assertArrayEquals
 (expectedSelection.toArray(),actualSelection.toArray());
 //Verify there 3 options selected in the list
 assertEquals(3,color.getAllSelectedOptions().size());
 //Deselect an option using visible text
 color.deselectByVisibleText("Silver");
 //Verify selected options count
 assertEquals(2,color.getAllSelectedOptions().size());
 //Deselect an option using value attribute of the option
 color.deselectByValue("rd");
 //Verify selected options count
 assertEquals(1,color.getAllSelectedOptions().size());
 //Deselect an option using index of the option
 color.deselectByIndex(0);
 //Verify selected options count
 assertEquals(0,color.getAllSelectedOptions().size());
}
```

## Automating radio buttons and radio groups
```
@Test
public void testRadioButton() {
 // Get the Radio Button as WebElement using it's value attribute
 WebElement petrol = driver.findElement(By .xpath("//input[@value='Petrol']"));
 // Check if its already selected? otherwise select the RadioButton
 // by calling click() method
 if (!petrol.isSelected()) {
 petrol.click();
 }
 // Verify Radio Button is selected
 assertTrue(petrol.isSelected());
 // We can also get all the Radio buttons from a Radio Group in a list
 // using findElements() method along with Radio Group identifier
 List<WebElement> fuelType = driver.findElements(By.name("fuel_type"));
 for (WebElement type : fuelType) {
 // Search for Diesel Radio Button in the Radio Group and select it
 if (type.getAttribute("value").equals("Diesel")) {
 if (!type.isSelected()) {
 type.click();
 }
 assertTrue(type.isSelected());
 break;
 }
 }
}
```
 ## Automating checkboxes
 ```
 @Test
public void testCheckBox() {
 //Get the Checkbox as WebElement using it's value attribute
 WebElement airbags = driver.findElement(By.xpath("//input[@
value='Airbags']"));
 //Check if its already selected? otherwise select the Checkbox
 //by calling click() method
 if (!airbags.isSelected()) {
 airbags.click();
 }
 //Verify Checkbox is Selected
 assertTrue(airbags.isSelected());
 //Check Checkbox if selected? If yes, deselect it
 //by calling click() method
 if (airbags.isSelected()) {
 airbags.click();
 }
 //Verify Checkbox is Deselected
 assertFalse(airbags.isSelected());
}]
```
## Working with WebTables
```
@Test
public void testWebTable() {
 WebElement simpleTable = driver.findElement(By.id("items"));
 // Get all rows
 List<WebElement> rows =
simpleTable.findElements(By.tagName("tr"));
 assertEquals(3, rows.size());
 // Print data from each row
 for (WebElement row : rows) {
 List<WebElement> cols = row.findElements(By.tagName("td"));
 for (WebElement col : cols) {
 System.out.print(col.getText() + "\t");
 }
 System.out.println();
 }
}
```
