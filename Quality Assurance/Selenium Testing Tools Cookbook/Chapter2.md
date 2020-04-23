# We will see how to use Selenium WebDriver API to find elements on a Web page and interact with these elements

Clicking links -> opening HTML Page -> text, image, picture, input box and may more stuff <br>
When we want to automate browser interaction using Selenium, we need to tell Selenium how to find a particular element or set of elements on a web page programmatically and simulate user actions on these elements. <br>
## Take Away 
You can right click on the line of code to find xpath as compared to find it.

## **FindElementMethod**<br>
The findElement() method returns an instance of a WebElement that is found in the page DOM based on specified locators, also called search criteria, else no element found.<br>
The findElements() method returns a list of WebElements matching the search criteria, else return empty list.<br>
<br>Child FindElement:<br>
The WebElement interface also supports find methods that find child elements. For example,if there are some duplicate elements on a page but they are located in the separate <div>elements, we can first locate the parent <div> element and then locate the child element within the context of the <div> element in the following way:<br>
  ```
WebElement div = driver.findElement(By.id("div1"));
WebElement topLink = div.findElement(By.linkText("top"));
```
You can also a use a shortcut method in the following way:<br>
  ```
WebElement topLink = driver.findElement
 (By.id("div1")).findElement(By.linkText("top"));
```
**various locator strategies**
by name, by id, by class name, by tag name, by link text, by partial link text, by css, by xpath<br><br>
  To locate the User Name and Password fields, we can use the id attribute in the following way:<br>
WebElement username = driver.findElement(By.id("username"));<br>
WebElement password = driver.findElement(By.id("password"));<br>
<br>
  
## Finding elements using the findElementsmethod
Selenium WebDriver provides the findElements() method, using which we can find more than one element matching the specified search criteria. This method is useful when we want to work with a group of similar elements. For example, we can get all the links displayed on a page, or get all rows from a table, and so on.<br>
In this recipe, we will get all the links and print their targets by using the findElements() method.<br>
<br>
Let's create a test that will get all the links from a page, verify the count of links, and print a
target for each link, as follows:
```
@Test
public void testFindElements() {
 //Get all the links displayed on Page
 List<WebElement> links = driver.findElements(By.tagName("a"));
 //Verify there are four links displayed on the page
 assertEquals(4, links.size());
 //Iterate though the list of links and print
 //target for each link
 for(WebElement link : links) {
 System.out.println(link.getAttribute("href"));
 }
}
  ```
### Finding link 
BY TEXT<br>
BY Partial Text<br>

### Tag Name
Let's assume you have a single button element on a page. You can locate this button by using its tag in the following way:<br>
```
WebElement loginButton = driver.findElement(By.tagName("button"));
loginButton.click();
```
Take another example where we want to count how many rows are displayed in <table>.
<br>We can do this in the following way:
  
```
WebElement table = driver.findElement(By.id("summaryTable"));
List<WebElement> rows = table.findElements(By.tagName("tr"));
assertEquals(10, rows.size());
  ```
