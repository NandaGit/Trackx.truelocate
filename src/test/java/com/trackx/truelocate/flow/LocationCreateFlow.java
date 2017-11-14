package com.trackx.truelocate.flow;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
import com.trackx.truelocate.pagecomponents.TruelocatedeleteFacility;

//import com.sun.jna.platform.FileUtils;

public class LocationCreateFlow {
 
	static WebDriver driver;

	TruelocatedeleteFacility heroukappdelete;
	HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");
	
	

	 @BeforeClass
	  public void setUp() throws IOException {
		 
		// create a new work book
					workbook = new HSSFWorkbook();
					// create a new work sheet
					sheet = workbook.createSheet("TestNG Result Summary");
					TestNGResults = new LinkedHashMap<String, Object[]>();
					// add test result excel file column header
					// write the header in the first row
					//TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
			 
		  driver = GeneralActions.launchBrowser(driver, "chrome");
		  
		  heroukappdelete=PageFactory.initElements(driver, TruelocatedeleteFacility.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 

	/**
	 * Login Checkout Flow Test Script
     */



	@Test( priority = 1, dataProviderClass=TruelocatedeleteFacility.class, dataProvider="getData")
	
	public void deleteFlow(String sCompname,String cname,String sdisdate) throws Exception {
		try {
			     
			heroukappdelete.computername(sCompname);
			heroukappdelete.clickcomp(cname);
			heroukappdelete.deleteClick(sdisdate);
			
			   log4jlogger.info("##########-------Login application-------##########");
			      log4jlogger.info("##########-------Login Successfully,----------############");
			     // TestNGResults.put("2", new Object[] { 1d, "Delete Operation", "Delete operation done successfully", "Pass" });
			}
			catch(Exception e){
				//TestNGResults.put("2",new Object[] { 1d, "Delete operration ", "Delete operration failed", "Fail" });
				//e.printStackTrace();
				
			}
		}
		
		
	
	@AfterClass
	public static void quitDriver()  {
	 try{
		
		 Thread.sleep(5000);
		 driver.quit();
		 }
		  catch (Exception e) {
		 //e.printStackTrace();
		 }
	
}

	
}