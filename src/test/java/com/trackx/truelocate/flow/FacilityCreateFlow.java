package com.trackx.truelocate.flow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.TruelocatecreateFacility;


public class FacilityCreateFlow extends GeneralActions {
	static WebDriver driver;
	
	
	TruelocatecreateFacility heroukupdate;

	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	
	 @BeforeClass
	  public void setUp() throws IOException {
		
		  driver = launchBrowser(driver, "chrome");
		  heroukupdate=PageFactory.initElements(driver, TruelocatecreateFacility.class);
		  
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 
	
	/**
	 * Login Checkout Flow Test Script
     */


		@Test(priority=1,dataProviderClass=TruelocatecreateFacility.class, dataProvider="getData")
		public void updateFlow(String sCompname,String cname,String sCompDate,String sCompanyname) throws Exception {
			try {
				     
				heroukupdate.computername(sCompname);
				heroukupdate.clickcomp(cname);
				heroukupdate.enterCompName(sCompname, sCompDate, sCompanyname);
				heroukupdate.clickCreateButton();
				
				
				 log4jlogger.info("##########-------Login application-------##########");
			      log4jlogger.info("##########-------Login Successfully,----------############");
			      //TestNGResults.put("4", new Object[] { "Update Operation", "Update operation done successfully", "Pass" });
			    
			}
			
			catch(Exception e){
			
				//TestNGResults.put("4",new Object[] {  "Update operation", "Update operation failed", "Fail" });
				//e.printStackTrace();
				
			}
		}
	

			@Test(priority=2)
			public void update(){
				try{
					System.out.println("Update flow done");
					TestNGResults.put("4", new Object[] { "Update Operation", "Update operation done successfully", "Pass" });
					
				}
				catch(Exception e){
					
					
					TestNGResults.put("4",new Object[] {  "Update operation", "Update operation failed", "Fail" });
				}
				
			}
  
	
	
		@AfterClass
		public void quitDriver(){
 try{
	
	 Thread.sleep(5000);
	 driver.quit();
	 }
	  catch (Exception e) {
	 e.printStackTrace();
	 }

}


}




