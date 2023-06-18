package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators: OR
	private By usernameInp = By.xpath("//input[@name='username']");
	private By passwordInp = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//button[@type='submit']");
	private By forgotPwdLink = By.linkText("Forgot your password?111");

	// 2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(usernameInp).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(passwordInp).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}

	public AdminPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(usernameInp).sendKeys(un);
		driver.findElement(passwordInp).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AdminPage(driver);
	}

}
