package com.trackx.truelocate.flow;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;
import com.trackx.truelocate.pagecomponents.Truelocatesite;
import com.trackx.truelocate.pagecomponents.Truelocatesiteedit;


public class SiteEditFlow extends GeneralActions {
	static WebDriver driver;
	
	Truelocatelogin truelocatelogin;
	Truelocatesite truelocatesite;
	Truelocatesiteedit truelocatesiteupdate;

	//Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	

	 @BeforeClass
	  public void setUp() throws IOException {
		
		  driver = launchBrowser(driver, "chrome");
		  truelocatelogin= PageFactory.initElements(driver, Truelocatelogin.class);
		  truelocatesite = PageFactory.initElements(driver, Truelocatesite.class);
		  truelocatesiteupdate= PageFactory.initElements(driver, Truelocatesiteedit.class);
		  
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 
	
	/**
	 * Login Checkout Flow Test Script
     */
	 
	 @Test(priority=1,dataProviderClass=Truelocatelogin.class, dataProvider="getData")
		public void LoginFlow(String sUsername,String sPassword) throws Exception {
	 
			try{
				
				 truelocatelogin.enterUsernamepassword(sUsername, sPassword);
					if( truelocatelogin.validation())
						
					{
			
				 TestNGResults.put("2", new Object[] {  "Login screen", "Login successful", "Pass" });	
				 Assert.assertTrue(true);
				 
			     Reporter.log("##########-------Login Successful,----------############");
			}
			
			 else
				 
    		 {
    				TestNGResults.put("2", new Object[] {  "Login screen screen", "Login not successful", "Fail" });
    				Assert.assertTrue(false);
    		 }
		}
		
			catch(Exception e){
				 
				e.printStackTrace();
				
				 }
		    		 	
	}

	 
	 @Test( priority = 2, dataProviderClass=Truelocatesiteedit.class, dataProvider="getData")
	 public void siteEditFlow(String sName, String sCode, String sNameedit) throws Exception {
    	 
		 try {
			 truelocatesite.siteClick();
    		 truelocatesiteupdate.editsite(sName); 
    		 truelocatesiteupdate.editcode(sCode,sNameedit);
    		
    		 Thread.sleep(1000);
    		 boolean result =truelocatesiteupdate.validation();
    		 
    		 if(result)
    		 {
   		      TestNGResults.put("3", new Object[] {  "Site screen", "Site created successfully", "Pass" });
   		      
   		      Assert.assertTrue(true);
   		      
    		 } 
    		 else
    		 {
    				TestNGResults.put("3", new Object[] { "Site screen", "Site not created", "Fail" });
    				Assert.assertTrue(false);
    		 }
 	    
		   
		 }   
		 
		catch(Exception e){
			e.printStackTrace();	
	
		}
	 }
	
		
      @AfterClass
	  public void quitDriver(){	 
		 
        try
     {
	
	 Thread.sleep(5000);
	 
	 driver.quit();
	 }
	  catch (Exception e) {
	 e.printStackTrace();
	 }

}


}




