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

