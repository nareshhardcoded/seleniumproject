package org.pro;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.base.BaseClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModuleTwo extends BaseClass {

	@Test()
	private void tc1() throws InterruptedException {
		launchBrowser();
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		windowMaximize();
		System.out.println("Test Case 1");
		Thread.sleep(6000);

		LoginPojo p = new LoginPojo();
		passText("Admin", p.getUsrname());

	}

	@Test(enabled = false)
	private void tc2() throws IOException, InterruptedException {
		System.out.println("Test Case 2");
		launchUrl("https://profile.w3schools.com/login");
		windowMaximize();
		Thread.sleep(5000);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy//h-m-s");
		Date date = new Date();
		takeScreenShot(
				"C:\\Users\\LENOVO\\eclipse-workspace\\TestNgProject\\screenshots\\scrn-"+dateFormat.format(date)+".png");

	}

	@Test(enabled = false)
	private void tc3() {
		System.out.println("Test Case 3");
		launchBrowser();
		launchUrl("https://www.demo.guru99.com/test/guru99home/");
		windowMaximize();
	}
	
	@Test(enabled = false)
	private void tc4() {
		System.out.println("Test Case 4");
		launchBrowser();
		launchUrl("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		windowMaximize();
		LoginPojo p=new LoginPojo();
		// To upload file to website
		fileUpload(p.getFileUpld(), "D:\\software testing\\Selenium.pdf");
		//driver.findElement(By.xpath("//input[@id='myFile']")).sendKeys("D:\\software testing\\Selenium.pdf");

	}
	
	@Test(priority = 15)
	private void tc5() throws IOException {
		System.out.println("Test Case 5 last");
		excelReadNew("C:\\Users\\LENOVO\\eclipse-workspace\\TestNgProject\\excel\\SampleData.xlsx", "Data");
	}

	@BeforeMethod
	private void startDate() {
		Date sdate = new Date();
		System.out.println(sdate);

	}

	@AfterMethod
	private void endDate() {
		Date edate = new Date();
		System.out.println(edate);

	}
}
