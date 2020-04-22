## [Dynamic XPath in Selenium using Different Approaches:](https://www.youtube.com/watch?v=3uktjWgKrtI)
<br>
+How to Find XPath in Chrome browser for Selenium Webdriver
<br>+Learn how to verify Custom XPath in Chrome Browser
<br>+Create and Test your own XPath before using it in Script
+Learn how quickly - you can create custom XPath<br>
+Learn the concept of : parent, preceding-sibling, forward-sibling Xpaths in Selenium<br>
+Learn text(), contains() functions in XPath<br>
+handling dynamic elements in selenium webdriver<br>
+how to write xpath in selenium webdriver<br>
+how to write relative xpath in selenium<br>
+dynamic xpath in selenium using different approaches<br>
+absolute xpath in selenium<br>
+how to write xpath manually in selenium webdriver<br>
+how to write absolute xpath in selenium<br>
selenium xpath java<br><br>

Some Good Examples:<br>
++link: Features<br>
```
1. //a[text()='Features']
2. //a[contains(text(),'Features')] --recommended

++button:
//button[@type='button' and @class='btn']
//button[contains(text(),'Sign Up')]
//div[@class='dropdown']//button[@type='button' and @class='btn btn-secondary dropdown-toggle' and @id='dropdownMenuButton']
//button[@id='dropdownMenuButton']

++preceding-sibling:
//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input

++parent & preceding-sibling:

//a[text()='test2 test2']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
```
