package Week5_Day2_Assignment;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact{
	WebDriver  driver;	

	@Test(dataProvider = "CreateContact")
	public void CreateContact1 (String data[]) {
		System.err.println(data[0]);
		System.err.println(data[1]);
		

		     WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		     driver.get("http://leaftaps.com/opentaps/control/main");
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		     driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data[0]);
		     driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(data[1]);
		     driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		     driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
		     driver.findElement(By.xpath("//a[contains(text(),'Contacts')][1]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Create Contact')][1]")).click();
				driver.findElement(By.id("firstNameField")).sendKeys(data[2]);
				driver.findElement(By.id("lastNameField")).sendKeys(data[3]);
				driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys(data[4]);
				driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys(data[5]);
				driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys(data[6]);
				driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(data[7]);
				driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys(data[8]);
				WebElement State = (driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']")));
				Select State1 = new Select(State);
				State1.selectByVisibleText("New York");
				driver.findElement(By.xpath("//input[@name='submitButton']")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
				driver.findElement(By.xpath("//textarea[@name='description']")).clear();
				driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys(data[9]);
				driver.findElement(By.xpath("//input[@value='Update']")).click();
				System.out.println("Browser title :- " +driver.getTitle());	
				driver.close();
			}
	
	
	@DataProvider(name ="CreateContact")
	public String[][] getData() throws IOException {
String[][] excelData = ReadDataExcel_CreateContact.getExcelData();

return excelData;

	}
	}