package org.pro;


import org.base.BaseClass;


public class ModuleOne extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		launchBrowser();
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		windowMaximize();
		Thread.sleep(6000);
		
		LoginPojo poj=new LoginPojo();
		passText("Admin", poj.getUsrname());
		passText("admin123", poj.getPass());
		clickBtn(poj.getLoginBtn());
		
	}

}
