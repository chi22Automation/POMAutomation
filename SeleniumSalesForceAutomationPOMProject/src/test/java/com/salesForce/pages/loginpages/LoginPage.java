package com.salesForce.pages.loginpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;
import com.salesForce.utility.CommmonUtilities;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver){
		super(driver);

    }
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id ="Login") WebElement btnLogin;
	@FindBy(id ="error") WebElement errorText;
	@FindBy(id ="rememberUn") WebElement rememberMeCheckBox;
	@FindBy(id ="forgot_password_link") WebElement forgotPwdLink;
	@FindBy(xpath ="//span[@id='idcard-identity']") WebElement userTxtBoxAfterRemCheckOut;
	@FindBy(xpath ="//a[@title='Logout']") WebElement logOut;
	
	public void verifyCredentilas()
	{
		String username=CommmonUtilities.getApplicationProperty("username");
	     enterIntoUsername(username);
		String password=CommmonUtilities.getApplicationProperty("password");
		 enterIntoPassword(password);
		 clcikLoginButton();
		 
		 
	}
	
	public void enterIntoUsername(String usrName) {
		enterText(username, usrName);
		
	}
	public void enterIntoPassword(String passwrd) {
		enterText(password, passwrd);
	}
	public void clcikLoginButton() {
		clickElement(btnLogin);
	}
	public void handleAlert() {
		AcceptAlert();
	}
	public void clcikCheckBox() {
		clickElement(rememberMeCheckBox);
	}
	public void clcikForgotPwd() {
		clickElement(forgotPwdLink);
	}
	public String getErrorMessage() 
	{
		String recvErrorTxt=getErrorText(errorText);
		return recvErrorTxt;
	}
	public String gettextBoxDateAfterLogOut()
	{
		report.logTestInfo("inside method gettextBoxDateAfterLogOut");
		report.logTestInfo(userTxtBoxAfterRemCheckOut.getText());
	String txtData=	getTextBoxData(userTxtBoxAfterRemCheckOut);
	report.logTestInfo("inside method gettextBoxDateAfterLogOutafterGetting textbox data"+txtData);
	
	return txtData;
	}
	}

