package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	public static void windowMaximize() {
		driver.manage().window().maximize();

	}

	public static void launchUrl(String url) {
		driver.get(url);

	}

	public static void pageTitle() {
		@Nullable
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static void pageUrl() {
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);

	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static void closeBrowserTab() {
		driver.close();

	}

	public static void closeBrowser() {
		driver.quit();

	}

	public static void clickBtn(WebElement ele) {
		ele.click();

	}

	public static void fileUpload(WebElement ele, String filepath) {
		ele.sendKeys(filepath);
	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		// change the file location and image format according to the project
		File destFile = new File("C:\\Users\\LENOVO\\eclipse-workspace\\TestNgExcel\\excel\\" + imgName + ".png");
		FileUtils.copyFile(srcFile, destFile);

	}

	public static void takeScreenShot(String filePath) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filePath);
		FileUtils.copyFile(srcFile, destFile);

	}

	public static Actions a;

	public static void moveTheCursor(WebElement targetWebElement) {
		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	public static void dragDrop(WebElement dragWebelement, WebElement dropWebelement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebelement, dropWebelement).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement tarWebEle) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebEle);

	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Data");
		Row r = mySheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		CellType cellType = c.getCellType();

		String value = " ";
		if (cellType == CellType.STRING) {
			String value2 = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = (Date) c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
		wb.close();
	}
	
	public static void excelReadNew(String filePath, String sheetName) throws IOException {
		File f=new File(filePath);
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=new XSSFWorkbook(fis);
		Sheet mySheet= wb.getSheet(sheetName);
		int totalRows = mySheet.getLastRowNum();
		int totalCells = mySheet.getRow(0).getLastCellNum();
		for (int i = 0; i < totalRows; i++) {
			Row currentRow = mySheet.getRow(i);
			for (int j = 0; j < totalCells; j++) {
				Cell cel = currentRow.getCell(j);
				System.out.print(cel.toString()+"\t\t");
			}
			System.out.println();
		}
		wb.close();

	}

	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		Workbook wb = new XSSFWorkbook();
		Sheet newSheet = wb.createSheet("Data");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static void createCell(int getRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.getRow(getRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();

	}

	public static void updateDataOfParticularCell(int getTheRow, int getTheCell, String existingData,
			String writeNewData) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenDataDrivenBaseClass\\excel\\SampleData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Data");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		wb.close();
	}

	public static void waitForElementToLoad(WebElement element, Duration i) {
		WebDriverWait wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
