package com.trackx.truelocate.pagecomponents;

//import java.awt.List;
import java.util.List;
import org.apache.bcel.generic.RETURN;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;




public class Truelocatesiteedit
{
	
	WebDriver driver;
	String Title,Value;
	int i=0;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	@FindBy(xpath="//*[@id='left-panel']/nav/ul[6]/li/a")
	WebElement btn_adminclick;

	@FindBy(xpath="//*[@id='left-panel']/nav/ul[6]/li/ul/li[1]/a")
	WebElement btn_siteclick;
	
	@FindBy(xpath="//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody/tr/td/div[1]")
	WebElement btn_editclick;
	
	@FindBy(xpath="//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody/tr")
	WebElement btn_editclick1;
	
	@FindBy(xpath="//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody/tr[1]/td")
	WebElement btn_editclick2;
	
	
	@FindBy(xpath="//*[@id='view-form']/fieldset[2]/div/section/button[1]")
	WebElement btn_editclick3;
	
	@FindBy(xpath="//*[@id='createCode']")
	WebElement txt_createedit;
	
	@FindBy(id="createName")
	WebElement txt_nameedit;
	
	@FindBy(xpath="//*[@id='edit-form']/fieldset[2]/div/section[2]/div/button[1]")
	WebElement btn_updateclick;
	
	@FindBy(id="errorContent")
	WebElement txt_validate;
	
	
	@FindBy(xpath="//*[@id='filterSlider']/header/button")
	WebElement title_headersite;
	
	
	
	//*[@id='ribbon']/ol/li[2]
	
	//*[@id='view-form']/fieldset[2]/div/section/button[1]
	
@FindBy(id="searchbox")
WebElement txt_search;


@FindBy(id="searchsubmit")
WebElement btn_filter;

@FindBy(xpath="//*[@id='main']/table/tbody/tr[1]/td")
WebElement compname_click1;

@FindBy(xpath="//*[@id='main']/table/tbody/tr[1]/td[1]")
WebElement compname_click;

@FindBy(xpath="//*[@id='main']/form[1]/div/a")
WebElement btn_cancel;



	public Truelocatesiteedit(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
}
	

	public void computername(String sCompname){
		try{
			Thread.sleep(1000);
		   inAction.inputText(driver,txt_search,sCompname, "Enter sCompname:  + sCompname"); 
		   inAction.buttonClick(driver,  btn_filter, "Click Filterbtn : + Filterbtn");
		   
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}


// computername click
public void compClick() {
	
	try{
		
		Thread.sleep(1000);
			
				//ReusableActions.mouseHover(driver,compname_click1);
		compname_click1.click();
		inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
		
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}


public void adminClick() {
	
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


	public void clickcomp(String cname) {
		try {

			WebElement htmltable = driver.findElement(By
					.xpath("//*[@id='main']/table[1]/tbody"));

			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));

			for (WebElement rowElement : rows)

			{

				List<WebElement> columns = rowElement.findElements(By
						.tagName("td"));

				System.out.println("Number of columns:" + columns.size());

				for (WebElement colElement : columns)

				{

					if (colElement.getText().equalsIgnoreCase(cname)) {
						System.out
								.println("*******Computer Value Found*********** ");

						rowElement.findElement(By.linkText(cname)).click();

						Thread.sleep(1000);
						//btn_editclick1.click();
						//btn_editclick2.click();
						 inAction.buttonClick(driver, btn_cancel, "Click Cancel :  btn_Cancel");

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


	public void editsite(String sName) {
		try {

			WebElement htmltable = driver.findElement(By.xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody"));

			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
			
			Thread.sleep(1000);

			System.out.println("Number of rows:" + rows.size());
		

			for (WebElement rowElement : rows)

			{

				List<WebElement> columns = rowElement.findElements(By.tagName("td"));
				

				//System.out.println("Number of columns:" + columns.size());
				

				for (WebElement colElement : columns)

				{

						if (colElement.getText().equalsIgnoreCase(sName))
							
					//Thread.sleep(1000);
					
					{
						System.out.println("******* Value Found*********** ");
						
						System.out.println(colElement.getText() + "******* element value*********** ");
						
						Thread.sleep(1000);
						
						//rowElement.findElement(By.className(sitename)).click();
						//ssitecode.click();
						
						rowElement.click();
						
						//colElement.click();
						
						Thread.sleep(1000);
						
						//inAction.buttonClick(driver, btn_editclick3, "Click Cancel :  btn_editclick3");
							
						btn_editclick3.click();
						
						
						//btn_editclick3.click();
						
						//colElement.findElement(By.linkText(sitename)).click();
						
						//btn_editclick3.click();
						//Thread.sleep(1000);
						// btn_editclick.click();
					/*	inAction.buttonClick(driver, btn_editclick,
								"Click editclick : btn_editclick");*/
			
				
				}
				
				}
			}
				
		}	
		
		catch(Exception e){
			//e.printStackTrace();
		}
		}
	//Thread.sleep(2000);
	
	
	public void editcode(String sCode, String sNameedit){
		
		try{
			//Thread.sleep(1000);
		   inAction.inputText(driver,txt_createedit,sCode, "Enter sCode:  + sCode"); 
		   inAction.inputText(driver,txt_nameedit,sNameedit, "Enter sNameedit:  + sNameedit");
		   btn_updateclick.click();
		      
		   //inAction.buttonClick(driver,  btn_filter, "Click Filterbtn : + Filterbtn");
		   
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}

	
	public boolean validation() throws InterruptedException {
		
		System.out.println("Msg:" + txt_validate.getText());
	
		Thread.sleep(1000);
		
		if(txt_validate.getText().equalsIgnoreCase(constants.success_sitemsg)){
			
			//Thread.sleep(1000);
			
		  // Assert.assertEquals(txt_validate.getText(),constants.success_sitemsg);
		    return true;
		   }
		
		   else{
			   Reporter.log("Fail");
			   return false;
		   }
	
	}
	
		public void validation1() {
		try{
		
		title_headersite.getText();
	}

		catch(Exception e){
			e.printStackTrace();
		}
		}
		
	
	public void editsite2(String sitename) {
		try {
			WebElement htmltable = driver
					.findElement(By.xpath("//*[@id='filterSlider']/div/div/form[3]/div/div/div/div[2]/table/tbody/tr[1]/td[1]"));
			
			List<WebElement> rows = htmltable.findElements(By.tagName("tr"));
			System.out.println("Number of rows:" + rows.size());
			
			
			for (WebElement rowElement : rows)
			{
				List<WebElement> columns = rowElement.findElements(By.tagName("td[]"));
				System.out.println("Number of columns:" + columns.size());
				for (WebElement colElement : columns)
				{
				
					if (colElement.getText().equalsIgnoreCase(sitename)) {
						System.out.println("******* Value Found*********** ");
						System.out.println(colElement.getText() + "******* elment value*********** ");

						colElement.click();
						
						//colElement.findElement(By.xpath(sitename)).click();

						//Thread.sleep(1000);
						// btn_editclick.click();
					/*	inAction.buttonClick(driver, btn_editclick,
								"Click editclick : btn_editclick");*/

					}
				
				}
				
				}
			}
					
			
		catch(Exception e){
			//e.printStackTrace();
		}
		}		
			
	
@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("Updatesite");
}
}


