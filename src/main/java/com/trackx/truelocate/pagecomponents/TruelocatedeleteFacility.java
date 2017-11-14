package com.trackx.truelocate.pagecomponents;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.trackx.truelocate.common.utils.Constants;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;


public class TruelocatedeleteFacility{
	
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

@FindBy(id="discontinued")
WebElement txt_discondate;


@FindBy(xpath="//*[@id='main']/form[2]/input")
WebElement btn_delete;



	public TruelocatedeleteFacility(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
}
	

	public void computername(String sCompname){
		
		try{
			
			//Thread.sleep(1000);
			
		   inAction.inputText(driver,txt_search,sCompname, "Enter sCompname:  + sCompname"); 
		   
		   inAction.buttonClick(driver,  btn_filter, "Click Filterbtn : + Filterbtn");
		   
		}
		catch(Exception e){
			e.printStackTrace();
		}
		}


// Computername click
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
					//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
					
					 
				}
			
			}
			}
		}
			
		
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}

	
public void deleteClick(String sdisdate) {
	
	
	try{
		
		Thread.sleep(1000);
		inAction.inputText(driver, txt_discondate,sdisdate, "Enter sdisdate:  + sdisdate");
		inAction.buttonClick(driver,  btn_delete, "Click Delete:  Delete btn");
		//inAction.buttonClick(driver,  btn_cancel, "Click Cancel :  btn_Cancel");
		
}
	catch(Exception e){
		
		e.printStackTrace();
	}
	
}

	
@DataProvider
public static Object[][] getData(){
	
	return GeneralActions.getData("Delete");
}
}





	


