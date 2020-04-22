package pkg2;

import org.openqa.selenium.Keys;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;  
	  

public class track_automate { 
	  
	    public static void main(String[] args) {  
	        
	    // declaration and instantiation of objects/variables  
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neha\\Documents\\sem4\\BRM\\chromedriver_win32\\chromedriver.exe");
	   
	    WebDriver driver=new ChromeDriver();  
	    
	    // Launch website  
	    driver.navigate().to("https://github.com/login"); 
	    driver.findElement(By.xpath("//input[@name='login']")).sendKeys("Nehasingh1300");
	    
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("$$banke123$$");
	    driver.findElement(By.xpath("//input[@value='Sign in']")).sendKeys(Keys.ENTER);
	    
	    driver.navigate().to("https://github.com/Nehasingh1300/track");
	    driver.findElement(By.xpath("//button[@data-disable-with]")).sendKeys(Keys.ENTER);
	    	    
	    driver.findElement(By.xpath("//input[@name='filename']")).sendKeys(generateRandomString(),".md");
	    driver.findElement(By.xpath("//pre")).sendKeys("# ",generateRandomString());
	    driver.findElement(By.xpath("//input[@id='commit-summary-input']")).sendKeys(generateRandomString());
	    driver.findElement(By.xpath("//button[@data-edit-text='Commit new file']")).sendKeys(Keys.ENTER);
	  
	  
	    }  
	    
	    
	    public static String generateRandomString() {
	    
		    
	    	Date date = (Date) Calendar.getInstance().getTime();   
	    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);   
		    return "Selenium Beginners" + strDate;
		    //return "Selenium Beginners" + new BigInteger(10, new SecureRandom()).toString(16);
		   }
	  
}  
// all methods tried but could not work somehow
//driver.findElement(By.xpath("//input[@data-query-name=\"q\"]")).sendKeys("track");
//driver.findElement(By.xpath("//span[@title='track']")).sendKeys(Keys.ENTER);
//driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("1300nehasingh@gmail.com");
//driver.findElement(By.xpath("//a[text()='Sign in']")).click();       not using     
// Click on the search text box and send value  
//driver.findElement(By.xpath("//button[contains(text(),'Create new file')]")).sendKeys(Keys.ENTER);   


//// Create object of SimpleDateFormat class and decide the format
//DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
////get current date time with Date()
//Date date = new Date(0, 0, 0);
//// Now format the date
//String date1= dateFormat.format(date);
// // Print the Date
