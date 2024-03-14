package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateLeadTest extends BaseClass{
	@Test
	public void  createLeadTest() throws InterruptedException  {
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(),"Leads");
		Thread.sleep(3000);
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(),"Create New Lead");
		
		Map<String, String>map=excel.readFromExcel("Create lead", "LeadsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(lastName));
		Thread.sleep(3000);
		newLead.clickLeadsLink();
		if(lead.getNewLeadName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create lead", "pass", IConstantPath.EXCEL_PATH,"LeadsTestData" );
		}
		else {
			System.out.println("Test Fal");
			excel.updateTestStatus("Create lead", "fail", IConstantPath.EXCEL_PATH,"LeadsTestData" );
		}
		soft.assertEquals(org.getNewOrgName(), lastName);
		//soft.assertAll();
	}

}
