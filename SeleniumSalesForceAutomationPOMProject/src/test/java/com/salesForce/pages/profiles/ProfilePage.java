package com.salesForce.pages.profiles;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.salesForce.base.BasePage;

public class ProfilePage extends BasePage
{
	public ProfilePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="home_Tab") WebElement hometab;
	 @FindBy(xpath  ="//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']") WebElement userEditProfile;
	 @FindBy(xpath  ="//a[@title='Post']//span[contains(@class,'publisherattachtext')]") WebElement postLink;
	 @FindBy(xpath  ="//a[@title='File']//span[contains(@class,'publisherattachtext')]") WebElement fileLink;
	 @FindBy(xpath  ="//a[@title='Upload a file from your computer']") WebElement fileUploadLink;
	 @FindBy(xpath  ="//input[@class='file']") WebElement selectfileLink ;
	 @FindBy(xpath  ="/html[1]/body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]") WebElement selectfileLink1 ;
	 
	 @FindBy(xpath ="//input[@title='Share']") WebElement shareBtn;
	
	 @FindBy(xpath  ="//span[@class='moderatorBadge']") WebElement mousovertoupdatephoto;
	 @FindBy(xpath  ="//div[@class='photoSection hasPhotoLinks']//a[1]") WebElement uploadPhoto;
	 @FindBy(xpath ="//a[normalize-space()='About']") WebElement aboutTab;
	 @FindBy(xpath ="//input[@value='c']") WebElement firstName;
	 @FindBy(xpath ="//input[@id='lastName']") WebElement lastName;
	 @FindBy(xpath ="//span[@class='tailNode cxTailNode']") WebElement editusernamechange;
	 @FindBy(tagName ="body") WebElement postText;
	 @FindBy(xpath ="//input[@type='file']") WebElement broweseBtnForphotoupload;
	 @FindBy(xpath ="//div[@class='uploadButtonPanel']//input[1]") WebElement saveprofilePhoto;
	
	//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']
	 
	 @FindBy(xpath ="//input[@value='Save All']") WebElement saveAllBtn;
	//img[@class='recImage user']
	//a[@class='contactInfoLaunch editLink']//img[@title='Edit Profile']
	//div[@id='userNavButton']
	 public void clickEdit()
	 {//a[contains(@class,'contactInfoLaunch editLink')]//img[contains(@title,'Edit Profile')]
		 report.logTestInfo("before userEdits click");
		 clickElement(userEditProfile);
		 report.logTestInfo("after userEdits click");
	 }
	public String ProfilEdit(String changeName)
	{ report.logTestInfo("inside profile link clicked userEdits click");
		String editedChangNAme=pofilrEditedOnAboutTab(userEditProfile,aboutTab,firstName,lastName,saveAllBtn,editusernamechange,changeName);
		report.logTestInfo("string return after lastname changed"+editedChangNAme);
		return editedChangNAme;
		
	}
	public String getTitleOfProfilePage()
	{
		 report.logTestInfo("inside hello method ");
		String title= getTitleOfThePage(hometab);
		 return title;
	}
  public void clickFileLink()
  {
	  	 waitUntilVisible(fileLink);
		 clickElement(fileLink);
		 waitUntilVisible(fileUploadLink);
		 clickElement(fileUploadLink);
		 report.logTestInfo("upload file link is clicked");
		 waitUntilVisible(selectfileLink1);
		 waitUntilVisible(selectfileLink1);
		// clickElement(selectfileLink1);
		 report.logTestInfo("select file is clicked");
		 selectfileLink1.sendKeys("C:\\Downloads\\kite.jpg");
		 waitUntilVisible(shareBtn);
		 waitUntilVisible(shareBtn);		 
		 clickElement(shareBtn);
		 report.logTestInfo("after file uploded");
		   
  }
  public void clickpostink()
  {	  
		 clickElement(postLink);		
		 driver.switchTo().frame(0);
		 waitUntilVisible(postText);		 
		 String typeinText="hello hru?";
		 postText.sendKeys(typeinText);
		 report.logTestInfo("after typing text");
		driver.switchTo().defaultContent();
		waitUntilVisible(shareBtn);//input[@title='Share']
		 clickElement(shareBtn);
		 report.logTestInfo("after clicking savebtn for text");
	  
  }
  public void clickuploadphotolink()
  { 
	 Actions act=new Actions(driver);
	 act.moveToElement(mousovertoupdatephoto).perform();
	 String currentwindow1=	 driver.getWindowHandle();
	 waitUntilVisible(uploadPhoto);
	 clickElement(uploadPhoto);
	 driver.switchTo().frame("uploadPhotoContentId");
	 waitUntilVisible(broweseBtnForphotoupload);	 
	 broweseBtnForphotoupload.sendKeys("C:\\Downloads\\kite.jpg");
	 waitUntilVisible(saveprofilePhoto);
	 clickElement(saveprofilePhoto);
	 driver.switchTo().window(currentwindow1);
	  
  }
  public String pofilrEditedOnAboutTab(WebElement userprofileEdit, WebElement about,WebElement fName,WebElement lName,WebElement saveBtn,WebElement editedNameChange,String lastnamechange)
	{
	clickElement(userprofileEdit);
	Set<String> windows =driver.getWindowHandles();	

	
	 /*Set<String> allwindows =driver.getWindowHandles();
	 ArrayList<String>  tabs=new ArrayList<String>(allwindows);
	 driver.switchTo().window(tab+s.get(0));*/
	driver.switchTo().frame("contactInfoContentId");
	waitUntilVisible(about);
	clickElement(about);
	report.logTestInfo("about button is clicked");
	waitUntilVisible(fName);
	waitUntilVisible(lName);
	//input[@id='lastName']
	lName.clear();
	//String changelastname="abcd";
	lName.sendKeys(lastnamechange);
	report.logTestInfo(lastnamechange);
	 waitUntilVisible(saveBtn);
	 clickElement(saveBtn);
	 waitUntilVisible(editedNameChange);
	 String usernamechange= editedNameChange.getText();
	 return usernamechange;
		
	}
	
	
	

}
