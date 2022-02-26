package Week5_Day2_Assignment;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead{

	@Test(dataProvider = "DuplicateLead")
	public void DuplicateLead1 (String data[]) throws InterruptedException {
		System.err.println(data[0]);
		System.err.println(data[1]);
		

		     WebDriverManager.chromedriver().setup();
		     WebDriver driver = new ChromeDriver();
		     driver.get("http://leaftaps.com/opentaps/control/main");
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		     driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data[0]);
		     driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(data[1]);
		     driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		     driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
				driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
				driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(data[2]);
				driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
				Thread.sleep(3000);
				WebElement Firstname = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName'][1]//a"));
				String Firstname1 = Firstname.getText();
				System.out.println("First Resulting name is:- " +Firstname1);
				Firstname.click();
				//Duplicate button 
				driver.findElement(By.xpath("//div[@class='frameSectionExtra'][1]//a[1]")).click();
				if(driver.getTitle().contains("Duplicate Lead"))
				{
					System.out.println("Verified title");
				}
				else
				{
					System.out.println("Title name is mismatching as per expected");
				}
				driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
				WebElement Duplicate_Firstname =driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
				String Duplicate_Firstname1 = Duplicate_Firstname.getText();

				if(Duplicate_Firstname1.equals(Firstname1))
				{
					System.out.println("Duplicate name & Captured name are same");
				}
				else
				{
					System.out.println("Duplicate name & Captured name are not same");
				}
				driver.close();
			}
	
	
	@DataProvider(name ="DuplicateLead")
	public String[][] getData() throws IOException {
String[][] excelData = ReadDataExcel_DuplicateLead.getExcelData();

return excelData;

	}
	}