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

public class DeleteLead{
	@Test(dataProvider = "DeleteLead")
	public void DeleteLead1 (String data[]) throws InterruptedException {

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
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(data[2]);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		WebElement LeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]//a"));
		String LeadID1 = LeadID.getText();
		System.out.println("First Resulting LeadID No:- " +LeadID1);
		LeadID.click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID1);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.className("x-paging-info")).isDisplayed())

			
{
		System.out.println("No records to display- should be printed");
}
		else
		{
			System.out.println("Records to displayed");
		}
		driver.close();
		}
		
	@DataProvider(name ="DeleteLead")
	public String[][] getData() throws IOException {
String[][] excelData = ReadDataExcel_DeleteLead.getExcelData();

return excelData;

	}
	}
