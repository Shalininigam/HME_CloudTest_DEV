import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ByXPath
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

boolean TCflag=true
try{
	WebUI.navigateToUrl(GlobalVariable.devPublicCloudUrl)

	CustomKeywords.'projectSpecific.Reusability.login'(CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudUsername"),CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudPassword"))

	WebUI.delay(GlobalVariable.MED_DELAY)
	
	WebDriver driver = DriverFactory.getWebDriver()
	//Pre-Condition: fetching store name from stores list

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/storesLink'))

	/*CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/store_secondrowview1'))

	String storelabel= WebUI.getAttribute(findTestObject('StorePage/storeName'), "value")
	storelabel= storelabel.trim()

	System.out.println(" the storename is--"+storelabel.trim())

	WebUI.delay(GlobalVariable.MIN_DELAY)


	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/zoomlabel'))

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/zoomViewDetails'))

	String storenumber=CustomKeywords.'uiaction.CommonUIActions.getText'(findTestObject('StorePage/storeID'))



	System.out.println(" the store number is--"+storenumber.trim())
*/
	driver.findElement(By.xpath("(//div[@class='ctable']/table//tr/td[3][contains(text(),'McDonald4')]/../td//span)[1]")).click()
	
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/zoomlabel'))

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/zoomViewDetails'))

	String storenumber=CustomKeywords.'uiaction.CommonUIActions.getText'(findTestObject('StorePage/storeID'))
	String storeValue=storenumber.trim()
	System.out.println(" the store number is--"+storeValue)

	WebUI.delay(GlobalVariable.MIN_DELAY)


	System.out.println(" the store number is--"+storenumber.trim())


	WebUI.delay(GlobalVariable.MED_DELAY)
	

	//Step 1: To verify that admin is able to select a store

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('UsersPage/reportsLink'))

	WebUI.verifyElementPresent(findTestObject('SummarizedReportPage/SummaryReportheader'), 10)

	println "Summary Reports screen will be displayed"

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/welcomeLink'))
//	CustomKeywords.'projectSpecific.Reusability.login'(CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudUsername"),CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudPassword"))

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/storesLink'))

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/ManageReportGroupsButtton'))

	'Click on Add New Group button'
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/addNewGroup'))

	CustomKeywords.'uiaction.CommonUIActions.enter'(findTestObject('ReportingGroupManagement/groupNameTxt'),

	CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportingGroupManagementPage","Summarygrp"))
	CustomKeywords.'uiaction.CommonUIActions.enter'(findTestObject('ReportingGroupManagement/groupDescTxt'),

	CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportingGroupManagementPage","GroupDesc"))


	String groupmain=CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportingGroupManagementPage","Summarygrp")

	WebUI.delay(GlobalVariable.MED_DELAY)


	List<WebElement> grouplist = driver.findElements(By.xpath("//ul[@class='unlinked-grouplist']/li"))
	WebUI.delay(GlobalVariable.MED_DELAY)

	for(int i=0; i<grouplist.size();i++){

	//	println grouplist.get(i).getText()

		if(grouplist.get(i).getText().contains(storeValue.trim())){

			driver.findElement(By.xpath("(//ul[@class='unlinked-grouplist']/li/label)["+(i+1)+"]")).click()
			driver.findElement(By.xpath("//button[contains(text(),'>')]")).click()
			break;
		}
	}

	WebUI.delay(GlobalVariable.MED_DELAY)

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/secondSelectAllCB'))

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/saveBtn'))
	WebUI.delay(GlobalVariable.MED_DELAY)
	
	
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('UsersPage/reportsLink'))

	WebUI.delay(GlobalVariable.MED_DELAY)
	driver.findElement(By.xpath("//span[contains(text(),'"+groupmain+"')]/../../../../span[1]")).click()

	WebUI.delay(4)
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportsPage/AllStoresCheckbox'))

	List<WebElement> storesCheckBoxList = driver.findElements(By.xpath(findTestData('OR_file').getValue(2, 4)))

	List<WebElement> storesCheckBoxListChecked = driver.findElements(By.xpath(findTestData('OR_file').getValue(2, 14)))

	if(storesCheckBoxList.size()==storesCheckBoxListChecked.size())
	{
		System.out.println("All Store checkboxes are checked after selecting SelectAll button")

	}

	else{
		if(TCflag)
			TCflag=false
		System.out.println("Store checkboxes are unchecked")
	}

	WebUI.delay(4)

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportsPage/AllStoresCheckbox'))
	WebUI.delay(4)

	driver.findElement(By.xpath("//span[contains(text(),'"+groupmain+"')]/../../../../span[2]")).click()


	//step 2: To select the time measure


	List<WebElement> timemeasureoptions= driver.findElements(By.xpath("//select[@class='time-measures']/option"))

	int count=0

	for(int i=0;i<timemeasureoptions.size();i++){

		println timemeasureoptions.get(i).getText()

		if(timemeasureoptions.get(i).getText()=="Week"){

			timemeasureoptions[i].click()
			count++;
			break;
		}

	}


	if(count<4){
		System.out.println("Week option is selected")

	}else{
		if(TCflag)
			TCflag=false
		println "to Date is not selected properly"

	}

	//step 3: To select the date

	WebUI.delay(GlobalVariable.MIN_DELAY)

	WebUI.click(findTestObject('ReportsPage/fromDateSelector'))

	WebUI.delay(GlobalVariable.MIN_DELAY)

	String monthText=WebUI.getText(findTestObject('ReportsPage/monthText'))
	String[] monthTextArray= monthText.split(" ")
	String month = monthTextArray[0]

	String monthTextValue=CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","Month_May")

	if(!monthTextValue.equals(month))
	{
		while(!monthTextValue.equals(month))
		{
			WebUI.click(findTestObject('ReportsPage/previousDateSelector'))
			monthText=WebUI.getText(findTestObject('ReportsPage/monthText'))
			monthTextArray= monthText.split(" ")
			month = monthTextArray[0]

		}

	}

	String data = CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","startdate_TC8")
	String startDate="(//td[text()='"+data+"'])[1]"
	println startDate
	WebElement startdateEle=driver.findElement(By.xpath(startDate))
	startdateEle.click()

	WebUI.delay(GlobalVariable.MIN_DELAY)

	WebUI.click(findTestObject('ReportsPage/toDateSelector'))

	monthText=WebUI.getText(findTestObject('ReportsPage/monthText2'))
	monthTextArray= monthText.split(" ")
	month = monthTextArray[0]

	if(!monthTextValue.equals(month))
	{
		while(!monthTextValue.equals(month))
		{
			WebUI.click(findTestObject('ReportsPage/previousDateSelector2'))
			monthText=WebUI.getText(findTestObject('ReportsPage/monthText2'))
			monthTextArray= monthText.split(" ")
			month = monthTextArray[0]

		}


	}

	String endDate=CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","EndDate6")

	String toDate="(//td[text()='"+endDate+"'])[2]"

	WebElement toDateEle=driver.findElement(By.xpath(toDate))
	toDateEle.click()

	WebUI.delay(GlobalVariable.MIN_DELAY)

	String dateAttr =WebUI.getAttribute(findTestObject('ReportsPage/selectedDate1'),"value")

	String fromDateValue =CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","May_SelectedDate2")
	if(!dateAttr.equals(fromDateValue))
	{
		if(TCflag)
			TCflag=false
		println "From date is not selected properly"
		WebUI.takeScreenshot()
	}

	dateAttr =WebUI.getAttribute(findTestObject('ReportsPage/selectedDate2'),"value")

	String toDateValue =CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","May_SelectedDate")
	if(!dateAttr.equals(toDateValue))
	{
		if(TCflag)
			TCflag=false
		println "to Date is not selected properly"
		WebUI.takeScreenshot()
	}



	//step 4: To include longest time and system statistics
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportsPage/Include_logesttime'))


	//step 5: To verify Generate report.

	WebUI.click(findTestObject('ReportsPage/report_submit'))


	WebUI.delay(GlobalVariable.MED_DELAY)
	
	WebUI.verifyElementPresent(findTestObject('SummarizedReportPage/Summary_avaragereport'), 10)

	WebUI.verifyElementPresent(findTestObject('SummarizedReportPage/summary_avaragetime_sec'), 10)


	List<WebElement> averagetime_headersfromapp= driver.findElements(By.xpath("//table[@class='summaryreport-table']//th[@class='reportTableAttributesHeading']"))

	String averagetime_headersfrom_excel= CustomKeywords.'projectSpecific.Reusability.getTestData'("ReportsPage","averagetime_headers_08")


	String[] averagetime_excelsplit=averagetime_headersfrom_excel.split(',')

	for(int i=0;i<averagetime_headersfromapp.size();i++){

		if(averagetime_headersfromapp.get(i).getText()==averagetime_excelsplit[i]){

			System.out.println("Headers are displayed correctly ")

		}else{
			if(TCflag)
				TCflag=false
			System.out.println(" Headers are not displayed correctly")

		}

	}


	// for deleting created group
	WebUI.delay(GlobalVariable.MIN_DELAY)
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/welcomeLink'))
	WebUI.delay(GlobalVariable.MIN_DELAY)
//	CustomKeywords.'projectSpecific.Reusability.login'(CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudUsername"),CustomKeywords.'projectSpecific.Reusability.getTestData'("HomePage","cloudPassword"))
	
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/storesLink'))
	WebUI.delay(GlobalVariable.MIN_DELAY)

	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('StorePage/ManageReportGroupsButtton'))

	WebUI.delay(GlobalVariable.MED_DELAY)
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/Summarygrp'))
	WebUI.delay(GlobalVariable.MED_DELAY)
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/deleteBtn'))
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('ReportingGroupManagement/confirmToDelBtn'))
	CustomKeywords.'uiaction.CommonUIActions.click'(findTestObject('HomePage/logoutLink'))

}catch(Exception e){
	e.printStackTrace()
	println "Exception of element not found"
	if(TCflag)
		TCflag=false
}

assert TCflag==true




