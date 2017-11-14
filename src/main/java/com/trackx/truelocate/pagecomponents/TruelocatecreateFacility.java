package com.trackx.truelocate.pagecomponents;


import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;


public class TruelocatecreateFacility
{
	WebDriver driver;
	String Title,Value;
	ReusableActions inAction = new ReusableActions();
	GeneralActions genAction = new GeneralActions();
	Constants constants=new Constants();
	public Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	
	
@FindBy(id="searchbox")
WebElement txt_search;


@FindBy(id="searchsubmit")
WebElement btn_filter;

@FindBy(xpath="//*[@id='main']/table/tbody/tr[1]/td[1]")
WebElement compname_click;

@FindBy(id="name") 
WebElement txt_compname;

@FindBy(id ="introduced")
WebElement txt_introdate;


@FindBy(id ="company")
WebElement dropdown_companyname;

@FindBy(xpath ="//*[@id='main']/form/div/input")
WebElement btn_create;



	public TruelocatecreateFacility(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
}

	public void computername(String sCompname){
		try{
			//Thread.sleep(1000);
		   inAction.inputText(driver,txt_search,sCompname, "Enter sCompname:  + sCompname"); 
		   inAction.buttonClick(driver,  btn_filter, "Click brs :  brs_btn");
		   
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}


// Computername click
	
	public void clickcomp(String cname){
		try{
			//txt_passortexp.click();
			//ReusableActions.selectValueFromDropdown(driver, year_pick, year, "Select passwordexp");
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
					//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
					
					 
				}
			
			}
			}
		}
			
		
				 
		
		
	catch(Exception e){
		e.printStackTrace();
	}
	}
//Thr
		

public void enterCompName(String sCompname,String sCompDate,String sCompanyname) {
	try{
	
	
	inAction.inputText(driver, txt_compname,sCompname , "Enter sCompname : " + sCompname);			
	inAction.inputText(driver, txt_introdate, sCompDate, "Enter sCompDate : " + sCompDate);
	inAction.buttonClick(driver, dropdown_companyname,"Click company : + company");
	//Thread.sleep(1000);

	ReusableActions.selectItemFromDropdown(driver, dropdown_companyname, sCompanyname, "Select Companyename");
	dropdown_companyname.click();
}
catch(Exception e){
	e.printStackTrace();
	
}
}


public void clickCreateButton() {
	try{
		
	inAction.buttonClick(driver, btn_create, "Click button : btn_Login");
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}


		
@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("Update");
}
}