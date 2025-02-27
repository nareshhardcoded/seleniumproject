package org.pro;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPojo extends BaseClass{
	public LoginPojo() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement usrname;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pass;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//input[@id='myFile']")
	private WebElement fileUpld;

	public WebElement getUsrname() {
		return usrname;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getFileUpld() {
		return fileUpld;
	}
	



}
