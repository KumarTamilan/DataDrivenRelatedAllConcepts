package org.passMultipleDataInSameFieldWithDP;

import java.time.Duration;

import org.driveTheDataFromExcelWithHelpOfDP.PropertyReaderClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PassMultipleDataInSameFieldWithHelpOfDP {

	@Test(dataProvider="TestData")
	public static void main(String username1,String password1,String firstName1,String lastName1,
			String day1,String month1,String year1,String mobileNumber1,String newPassword1) throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get("https://www.facebook.com/");
		
		WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'email')]"));
		username.sendKeys(username1);
		WebElement password = driver.findElement(By.xpath("//input[starts-with(@id,'pass')]"));
		password.sendKeys(password1);
		
		WebElement createAccount = driver.findElement(By.xpath("//a[text()='Create new account']"));
		createAccount.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@name,'firstname')]"));
		firstName.sendKeys(firstName1);
		WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@name,'lastname')]"));
		lastName.sendKeys(lastName1);
		
		WebElement dropdown1 = driver.findElement(By.xpath("//select[starts-with(@id,'day')]"));
		Select s1 = new Select(dropdown1);
		s1.selectByValue(day1);
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[starts-with(@id,'month')]"));
		Select s2 = new Select(dropdown2);
		s2.selectByValue(month1);
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[starts-with(@id,'year')]"));
		Select s3 = new Select(dropdown3);
		s3.selectByValue(year1);
		
		WebElement mobileNumber = driver.findElement(By.xpath("//input[starts-with(@name,'reg_email__')]"));
		mobileNumber.sendKeys(mobileNumber1);
		WebElement newPassword = driver.findElement(By.xpath("//input[starts-with(@name,'reg_passwd__')]"));
		newPassword.sendKeys(newPassword1);
		
		Thread.sleep(5000);
	}
	@DataProvider(name="TestData")
	public String[][] qaData() {
		PropertyReaderClass reader = new PropertyReaderClass(".\\Excel\\FBData.xlsx","Sheet4");
		int row = reader.findRow();
		int cell = reader.findCell();
		return reader.findValues(row, cell);
	}
}
