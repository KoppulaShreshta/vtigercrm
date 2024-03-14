package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateContactWithExistingOrgTest extends BaseClass{
	@Test
	
	public void createContactWithOrgTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(),"Contacts");
		 Thread.sleep(3000);
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		 Thread.sleep(3000);
		Map<String, String>map=excel.readFromExcel("Create Contact With Organization", "ContactsTestData");
		String lastName=map.get("Last Name")+ jutil.generateRandomNum(100);
	    createContact.setLastName(lastName);
	    createContact.selectExistingOrg(web, map.get("Organzation Name"));
	    
	    Thread.sleep(3000);
	    createContact.clickSave();
	    soft.assertTrue(newContact.getPageHeader().contains(lastName));
	    
	    Thread.sleep(3000);
	    newContact.clickContactsLink();
	    
	    if(contact.getNewContactName().equals(lastName)) {
	    	System.out.println("Test pass");
	    	excel.updateTestStatus("Create Contact With Organization", "pass", IConstantPath.EXCEL_PATH,"ContactsTestData");
	    }
	    else {
	    	System.out.println("Test Fail");
	    	excel.updateTestStatus("Create Contact With Organization", "fail", IConstantPath.EXCEL_PATH,"ContactsTestData");
	    }
	    soft.assertTrue(contact.getNewContactName().contains(lastName));
	    soft.assertAll();
	}



}
