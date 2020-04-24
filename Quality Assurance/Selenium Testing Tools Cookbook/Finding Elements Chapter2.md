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
We can do this in the following way:  
  
```
WebElement table = driver.findElement(By.id("summaryTable"));
List<WebElement> rows = table.findElements(By.tagName("tr"));
assertEquals(10, rows.size());
```
### Finding elements using XPath
XPath (the XML path language) is a query language used to select nodes from an XML
document. <br>
One of the important differences between XPath and CSS is that, with XPath, we can search
elements backwards or forwards in the DOM hierarchy, while CSS works only in a forward
direction. This means that using XPath we can locate a parent element using a child element
and vice versa.<br><br>
**Nodes** :HTML,id,title <br>
**Atomic Values** :nodes with no children and parent <br>
**Parent** <br>
**Children**  <br>
**Siblings** <br>
**Ascendants**  <br>
**Descendants**  <br><br>
**Selecting Nodes**<br>
**Nodename** :Select complete table <br>
**/(slash)** :/html/body/div <br>
**//(double slash)** ://img,//a,//table,//tr,//td <br>
**.(dot)** :current node <br>
**..(double dot)** :parent of the current node <br>
**@** :attribute <br><br>
## Finding elements using predicates

In the previous example, the XPath query will return the first <input> element that it finds in the DOM. There could be multiple elements matching the specified XPath query. If the element is not the first element, we can also locate the element by using its index in theDOM. For example, in our login form, we can locate the Password field, which is the second <input> element on the page, in the following way:
```
WebElement userName = driver.findElement(By.xpath("//input[2]"));
```
```
Syntax                                  Example                                Description
starts-with()                   input[starts-with(@id,'ctrl')]                  Starting with:For example, if the ID of an element is ctrl_12, this will find and return elements with ctrl at the beginning of the ID.
ends-with()                     input[ends-with(@id,'_userName')]               Ending with:For example, if the ID of an element is a_1_userName, this will find and return elements with _userName at the end of the ID.
contains()                      Input[contains(@id,'userName')]                 Containing:For example, if the ID for an element is panel_login_userName_ textfield, this will use the userName part in the middle to match and locate the element.
```

```
Expression                                                                       Description
/table/tr[1]                                                                    This will select the first tr (row) element that is the child of the table element.
/table/tr[last()]                                                               This will select the last tr (row) element that is the child of the table element.
/table/tr[last()-1]                                                             This will select the second last tr (row) element that is the child of the table element.
/table/tr[position()>4]                                                         This will select the three tr (rows) elements that are child of the table element.
//tr[td>40]                                                                     This will select all the tr (rows) elements that have one of their children td with value greater than 40.
```

### Selecting unknown nodes
Apart from selecting the specific nodes, XPath also provides wildcards to select a group of elements:<br>
```
Wildcard                        Description                             Example
\*                               Matches any element node.               f /table/*: This will select all child elements of a table element ;f //*: This will select all elements in the document ;f //*[@class='price']: This will select any element in the document which has an attribute named class with a specified value, that is price 
@                               Matches any attribute node.             f //td[@*]: This will select all the td elements that have any attribute 
node()                          Matches any node of any kind.           f //table/node(): This will select all the child elements of table
```

## Finding elements using CSS selectors
```
WebElement userName = driver.findElement(By.cssSelector("html body div div form input"));
WebElement userName = driver.findElement(By.cssSelector("html > body > div > div > form > input"));
WebElement userName = driver.findElement(By.cssSelector("input"));
WebElement loginButton =  driver.findElement(By.cssSelector("input.login"));
<input type="text" class="username textfield" />
WebElement loginButton = driver.findElement(By.cssSelector("input.login.textfield"));
WebElement loginButton =driver.findElement(By.cssSelector(".login"));
```
## Locating elements using text
XPath provides the text() function, which can be used to see if an element contains the specified text in the following way:
```WebElement cell = driver.findElement
 (By.xpath("//td[contains(text(),'Item 1')]"));
```
We can also use a single period/dot, ".", instead of the text() function in following way:
```WebElement cell = driver.findElement
 (By.xpath("//td[contains(.,'Item 1')]"));```
 
