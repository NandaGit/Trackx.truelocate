package com.trackx.truelocate.pagecomponents;

//import java.awt.List;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;


public class Truelocatesite
{
	
	WebDriver driver;
	String Title,Value;
	int i=0;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	//public Logger log4jlogger =Logger.getLogger("devpinoyLogger");


@FindBy(id="searchsubmit")
WebElement btn_filter;


@FindBy(xpath="//*[@id='main']/form[1]/div/a")
WebElement btn_cancel;


@FindBy(xpath="//*[@id='left-panel']/nav/ul[6]/li/a")
WebElement btn_adminclick;


@FindBy(xpath="//*[@id='left-panel']/nav/ul[6]/li/ul/li[1]/a")
WebElement btn_siteclick;

@FindBy(xpath="//*[@id='filterSlider']/header/button")
WebElement btn_createclick;


@FindBy(xpath="//*[@id='createCode']")
WebElement txt_code;

@FindBy(xpath="//*[@id='createName']")
WebElement txt_name;


@FindBy(xpath="//*[@id='s2id_applicationType']/a/span[2]/b")
WebElement dropdown_apptype;

@FindBy(xpath="//*[@id='s2id_autogen2_search']")
WebElement corp_apptype;

//*[@id='select2-result-label-232']

@FindBy(xpath="//*[@id='s2id_autogen2_search']")
WebElement txt_apptype;


@FindBy(xpath="//*[@id='s2id_autogen3_search']")
WebElement txt_entitytype;


@FindBy(xpath="//*[@id='s2id_entityType']/a/span[2]/b")
WebElement dropdown_entitytype;

@FindBy(xpath="//*[@id='createLatitude']")
WebElement txt_latitude;

@FindBy(xpath="//*[@id='createLongitude']")
WebElement txt_longitude;


@FindBy(xpath="//*[@id='edit-form']/fieldset[2]/div/section[1]/div/button[1]")
WebElement btn_createclick1;

@FindBy(xpath="//*[@id='errorContent']")
WebElement sitetxt_msg;



	public Truelocatesite(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
}
	

public void siteClick() {
	
	try{
		
		Thread.sleep(1000);
		//ReusableActions.mouseHover(driver,compname_click1);
		btn_adminclick.click();
		btn_siteclick.click();
		//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
		
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}

public void createClick() {
	
	try{
		
		Thread.sleep(1000);
			
		//ReusableActions.mouseHover(driver,compname_click1);
		btn_createclick.click();
		//btn_siteclick.click();
		//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
		
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}


public void entersitedetails(String sCode,String sName,String sApplicationtype,String sEntitytype,String sLatitude,String sLongitude) {
	try{
	
	inAction.inputText(driver, txt_code,sCode , "Enter sCode : " + sCode);			
	inAction.inputText(driver, txt_name, sName, "Enter sName : " + sName);
	dropdown_apptype.click();
	inAction.inputText(driver, txt_apptype, sApplicationtype, "Enter sApplicationtype : " + sApplicationtype);
	//corp_apptype.click();
	txt_apptype.sendKeys(Keys.ENTER);

	//ReusableActions.selectValueFromDropdowndriver, dropdown_apptype, sApplicationtype, "SelectsApplicationtype");
	dropdown_entitytype.click();
	
	inAction.inputText(driver, txt_entitytype, sEntitytype, "Enter sName : " + sEntitytype);
	txt_entitytype.sendKeys(Keys.ENTER);
	
	//ReusableActions.selectItemFromDropdown(driver, dropdown_entitytype, sEntitytype, "Select sEntitytype");
	//dropdown_entitytype.click();
	
	inAction.inputText(driver, txt_latitude,sLatitude , "Enter sLatitudesUsername : " + sLatitude);			
	inAction.inputText(driver, txt_longitude, sLongitude, "Enter sLongitude : " + sLongitude);
	btn_createclick1.click();
	Thread.sleep(1000);
	
}
	catch(Exception e){
		e.printStackTrace();
		
	}

}



public void createfinalclick() {
	
	try{
		
		Thread.sleep(1000);
			
				//ReusableActions.mouseHover(driver,compname_click1);
		btn_createclick1.click();
		//btn_siteclick.click();
		//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
		
		
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}


public boolean sitevalidation(){
	
	System.out.println("Msg:" + sitetxt_msg.getText());
	
	//Thread.sleep(1000);
	
	if(sitetxt_msg.getText().equalsIgnoreCase(constants.success_sitemsg)){
	
		//Thread.sleep(1000);
		
	     Assert.assertEquals( sitetxt_msg.getText(),constants.success_sitemsg);
	     
	    return true;
	   }
	
	   else{
		   Reporter.log("Fail");
		   return false;
	   }

}


public void clickcomp(String cname){
			try{
				
				WebElement htmltable=driver.findElement(By.xpath("//*[@id='main']/table[1]/tbody"));

				List<WebElement> rows=htmltable.findElements(By.tagName("tr"));

				 
				for(WebElement rowElement:rows)
				

				{

				List<WebElement> columns=rowElement.findElements(By.tagName("td"));
				 

				System.out.println("Number of columns:"+columns.size());

				 
                 for(WebElement colElement:columns)

				{
					
					if (colElement.getText().equalsIgnoreCase(cname))
					{           
						System.out.println("*******Computer Value Found*********** " );

						rowElement.findElement(By.linkText(cname)).click();
						
						Thread.sleep(1000);
						inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
						
						
					}
				
				}
				}
			}
				
					
			
		catch(Exception e){
			//e.printStackTrace();
		}
		}
	//Thread.sleep(2000);
				
				
			
		
		//inAction.buttonClick(driver,  compname_click, "Click Compname:  Compname_click");

	
	
@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("Site");
}
}


