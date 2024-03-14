package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateOrgTest extends BaseClass {
	@Test
	public void createNewOrgTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		home.clickOrganizations();
		org.clickPlusButton();
		soft.assertEquals(org.getPageHeader(),"Organization");
		Thread.sleep(3000);
		Map<String,String> map=excel.readFromExcel("Create Organization","OrganizationsTestData");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSave();
		Thread.sleep(3000);
		soft.assertTrue(newOrg.getPageHeader().contains(orgName));
		Thread.sleep(3000);
		newOrg.clickOrgLink();
		if(org.getNewOrgName().equals(orgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization","Pass",IConstantPath.EXCEL_PATH,"OrganizationsTestData");
		}
		else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Organization","Fail",IConstantPath.EXCEL_PATH,"OrganizationsTestData");
		}
		soft.assertEquals(org.getNewOrgName(), orgName);
		//soft.assertAll();
	}

}
