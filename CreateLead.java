package Week5_Day2_Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead{


	@Test(dataProvider = "CreateLead")
	public void CreateLead1(String data[]) {

	     WebDriverManager.chromedriver().setup();
	     WebDriver driver = new ChromeDriver();
	     driver.get("http://leaftaps.com/opentaps/control/main");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	     driver.findElement(By.xpath("//input[@id='username']")).sendKeys(data[0]);
	     driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(data[1]);
	     driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	     driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();

		//Enter all the fields in CreateLead page

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(data[2]);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(data[3]);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(data[4]);
		Select Source = new Select(driver.findElement(By.name("dataSourceId")));
		Source.selectByVisibleText("Other");
		Select Campaign = new Select(driver.findElement(By.name("marketingCampaignId")));
		Campaign.selectByIndex(3);
		driver.findElement(By.name("firstNameLocal")).sendKeys(data[5]);
		driver.findElement(By.name("lastNameLocal")).sendKeys(data[6]);
		driver.findElement(By.name("personalTitle")).sendKeys(data[7]);
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys(data[8]);
		driver.findElement(By.name("generalProfTitle")).sendKeys(data[9]);
		driver.findElement(By.name("departmentName")).sendKeys(data[10]);
		driver.findElement(By.name("annualRevenue")).sendKeys(data[11]);
		Select Industry = new Select(driver.findElement(By.name("industryEnumId")));
		Industry.selectByIndex(5);
		Select Preferred_Currency = new Select(driver.findElement(By.name("currencyUomId")));
		Preferred_Currency.selectByIndex(8);
		Select Ownership = new Select(driver.findElement(By.name("ownershipEnumId")));
		Ownership.selectByVisibleText("Corporation");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys(data[12]);

		//Click on create Lead Button

		driver.findElement(By.className("smallSubmit")).click();
		driver.close();
			}
	
	@DataProvider(name ="CreateLead")
	public String[][] getData() throws IOException {
String[][] excelData = ReadDataExcel_CreateLead.getExcelData();

return excelData;

	}


		}
