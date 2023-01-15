package Login;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utility.ConfigReader;
import weekSelectionAndLogging.WeekHelper;

 public class login extends ConfigReader {

	WebDriver driver = new ChromeDriver();

	
	@Test(priority = 1)
	public void loginWand() throws IOException {
		new ConfigReader();
		Date currDate = new Date();
		long dayOfTheWeekIndex = WeekHelper.dayOfTheWeekIndex(currDate);

		// username click
		WebElement username = new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @id='usernamefield']")));
		username.click();
		username.clear();
		username.isSelected();
		username.sendKeys(ConfigReader.getUsername());

		// Password
		WebElement password = new WebDriverWait(driver, Duration.ofSeconds(15)).until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password' and @id='passwordfield']")));
		password.click();
		password.sendKeys(ConfigReader.getPassword());

		// submit
		driver.findElement(By.xpath("//*[@type='submit' and @id='loginButton']")).click();

		// Time
		Select getSelectionValue = new Select(driver.findElement(By.xpath("//select[@id='selectedBillingType']")));
		getSelectionValue.selectByValue("Time");

		// SelectDaterance
		Select SelectDaterance = new Select(driver.findElement(By.xpath("//Select[@id='dateRangeString']")));
		SelectDaterance.selectByValue(WeekHelper.getSelectionValue(currDate));

		// Add Time & Expense
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		// submissionListStartHour
		Select submissionListStartHour = new Select(
				driver.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.startHourM")));
		submissionListStartHour.selectByValue("11");

		// submissionListStartMin
		Select submissionListStartMin = new Select(
				driver.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.startMinute")));
		submissionListStartMin.selectByValue("30");

		// submissionListStartMeridiem
		Select submissionListStartMeridiem = new Select(driver
				.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.startMeridiem")));
		submissionListStartMeridiem.selectByVisibleText("AM");

		// submissionListEndHour
		Select submissionListEndHour = new Select(
				driver.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.endHourM")));
		submissionListEndHour.selectByValue("8");

		// submissionListEndMin
		Select submissionListEndMin = new Select(
				driver.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.endMinute")));
		submissionListEndMin.selectByValue("30");

		// submissionListStartMeridiem
		Select submissionListEndMeridiem = new Select(
				driver.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.endMeridiem")));
		submissionListEndMeridiem.selectByVisibleText("PM");

		// Type_of_Work
		Select type_of_Work = new Select(driver
				.findElement(By.id("billingDetailItems" + dayOfTheWeekIndex + ".billingTimeSpans0.timeEntrySpanType")));
		type_of_Work.selectByValue("Labor");

		// ReqHrs
		WebElement reqHrs = driver.findElement(
				By.xpath("//*[@id='billingDetailItems" + dayOfTheWeekIndex + ".customFields0.regularHours']"));
		reqHrs.clear();
		reqHrs.sendKeys("9");

		// ProjectTaskData
		Select getProjectTaskData = new Select(
				driver.findElement(By.xpath("//select[@id='cf_0_" + dayOfTheWeekIndex + "_0_0']")));
		getProjectTaskData.selectByVisibleText(ConfigReader.getprojectData());

		// NoLunchBreakButton
		WebElement lunchBreak = driver
				.findElement(By.xpath("//input[@id='billingDetailItems" + dayOfTheWeekIndex + ".noBreakTaken1']"));
		lunchBreak.click();

		// submissionListSubmitButton
		driver.findElement(By.xpath("//input[@value='Submit' and @class='gold-button']")).click();

		// billingItemListVerification
		WebElement billingItemListVerification = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit' and @value='Done']")));
		billingItemListVerification.click();

	}

	@BeforeClass
	public void startSystem() throws IOException {
		new ConfigReader();
		driver.manage().window().maximize();
    	driver.get(ConfigReader.getUrl());
}

	@AfterClass
	public void systemClose() {
		driver.quit();
	}
}
