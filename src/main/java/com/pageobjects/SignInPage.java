package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.constants.Literals;



public class SignInPage {
	
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	String verifyFailMsg = Literals.LOGIN_VERIFCATION_ERROR_MESSAGE;
	
	//SignIn
	@FindBy(id = "loginEmail")
	private WebElement loginEmail;
	
	@FindBy(id = "loginPassword")
	private WebElement loginPassword;
	
	@FindBy(css = "#loginSubmit .StyledText-sc-1sadyjn-0.egttYR")
	private WebElement loginPwdShowButton;
	
	@FindBy(id = "submitLogin")
	private WebElement submitLogin;
	
	@FindBy(css = "#loginSubmit .StyledBox-sc-13pk1d4-0.jLBcvf .StyledText-sc-1sadyjn-0.hcbzKl")
	private WebElement verificationFailedMessage;
	
	
	//SignIn
	public void enterLoginEmail(String email) {
		loginEmail.sendKeys(email);		
	}
	
	public void enterLoginPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	public void clickShowLoginPassword() {
		loginPwdShowButton.click();
	}
	
	public void clickSignIn() {
		submitLogin.click();
	}
	
	public boolean isVerificationFailedMessageDisplayed() {
		boolean result = verificationFailedMessage.isDisplayed();
		return result;
	}
	
	public String getVericationFailedMessage() {
		String eMsg = verificationFailedMessage.getText();
		return eMsg;
	}
	
	
	
	
}
