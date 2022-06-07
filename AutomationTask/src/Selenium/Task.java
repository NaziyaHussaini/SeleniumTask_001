package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task {

	WebDriver driver;
	
	public void launchBrowser(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://dotnetfiddle.net/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void Test1(String text){
		System.out.println("\nTest1: Click “Run” button and check Output window (“Hello World” text is expected)");
		driver.findElement(By.id("run-button")).click();
		String outputValidation=driver.findElement(By.id("output")).getText();
		Assert.assertEquals(outputValidation, text, "Expected text is not obtained");
		System.out.println("Result: Expected text is obtained, Test1 passed successfully");
	}
	
	@Test
	public void Test2(String name) throws InterruptedException{
		System.out.println("\nTest2: Test to be perform depending upon the starting letter of the Firstname");
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div[4]/div[1]/input")).sendKeys(name);
		char c=name.charAt(0);
		int c1=c;
		System.out.println("Firstname starts with "+ "'"+c+"'");
		if((c1>=65&&c1<=69)||(c1>=97&&c1<=101)){
			//( your first name starts with letter “A-B-C-D-E”):
			System.out.println("\nScenario: Select NuGet Packages: nUnit (3.12.0) and check that nUnit package is added");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div[3]/div[5]/div/div/input")).sendKeys("NUnit"+Keys.ENTER);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
			Thread.sleep(5000);
			JavascriptExecutor jse=(JavascriptExecutor)driver;
			jse.executeScript("document.querySelector('ul.ui-menu.ui-widget.ui-widget-content.ui-corner-all').querySelector('ul.ui-menu.ui-widget.ui-widget-content.ui-corner-all').scrollTop=100");
			driver.findElement(By.xpath("/html/body/ul/li[1]/ul/li[5]/a")).click();
			Assert.assertTrue(driver.getPageSource().contains("NUnit"),"NUnit package is not added");
			System.out.println("Result: NUnit package is added successfully, Test2 Passed");
		}	
		else if((c1>=70&&c1<=75)||(c1>=102&&c1<=107)){
			//(If your first name starts with letter “F-G-H-I-J-K”):
			System.out.println("\nScenario: Click “Share” button and check that link starts with “https://dotnetfiddle.net/”");
			driver.findElement(By.id("Share")).click();
			Thread.sleep(1000);
			String link=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[1]/input")).getAttribute("value");
			Assert.assertTrue(link.startsWith("https://dotnetfiddle.net/"), "Link validation failed");
			System.out.println("Result: Link validation passed, Test2 ran successfully");
		}
		else if((c1>=76&&c1<=80)||(c1>=108&&c1<=112)){
			//(If your first name starts with letter “L-M-N-O-P”):
			System.out.println("\nScenario: Click “<” button on “Options” panel to hide this panel and check that “Options” panel is hidden");
			driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div[3]/div[1]/button[1]/span")).click();
			Thread.sleep(1000);
			String val=(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/form/div[2]/div[3]")).getAttribute("style"));
			String val1="left: -180px;";
			Assert.assertEquals(val,val1);
			System.out.println("Result: 'Options' panel is now Hidden, Test2 ran successfully");
		}
		else if((c1>=81&&c1<=85)||(c1>=113&&c1<=117)){
			//(If your first name starts with letter “Q-R-S-T-U”):
			System.out.println("\nScenario: Click “Save” button and check that “Log In” window appeared");
			driver.findElement(By.id("save-button")).click();
			Assert.assertTrue(driver.getPageSource().contains("Log in"));
			System.out.println("Result: 'Log In' window appeared successfully, Test2 validation passed");
		}
		else if((c1>=86&&c1<=90)||(c1>=118&&c1<=122)){
			//(If your first name starts with letter “V-W-X-Y-Z”):
			System.out.println("\nScenario: Click “Getting Started” button and check that “< Back to Editor” button appeared"); 
			driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div[5]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/a")).isDisplayed());
			System.out.println("Result: '< Back To Editor' button appeared successfully, Test2 validation passed");
		}
	}
	
	public void closeBrowser(){
		driver.quit();
		}
	
	public static void main(String[] args) throws InterruptedException {
		Task obj = new Task();
		obj.launchBrowser();
		String text = "Hello World";
		String name = "S&PGlobal";
		obj.Test1(text);
		obj.Test2(name);
		Thread.sleep(5000);
		obj.closeBrowser();
	}

}
