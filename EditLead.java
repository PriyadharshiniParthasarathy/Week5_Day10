package Week5_Day2_Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead{
	@Test(dataProvider = "EditLead")
	public void EditLead1(String data[]) throws InterruptedException {

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
			driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(data[2]);
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
			Thread.sleep(3000);
			String actualTitle = driver.getTitle();
			String expectedTitle ="View Lead | opentaps CRM";

			if(actualTitle.equalsIgnoreCase(expectedTitle))
			{
				System.out.println("Title Matched");
			}
			else {
				System.out.println("Title didn't match");
				}
			driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
			driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
	Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys(data[3]);
			driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
			if (driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).isDisplayed())

					{
				System.out.println("Updated Company name is displayed");
					}

			
			driver.close();
		}
		
	@DataProvider(name ="EditLead")
	public String[][] getData() throws IOException {
String[][] excelData = ReadDataExcel_EditLead.getExcelData();

return excelData;

	}
	}
