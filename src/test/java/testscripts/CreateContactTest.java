package testscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateContactTest extends BaseClass {
	@Test
	public void creteNewContactTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(),"Contacts");
		Thread.sleep(3000);
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(),"Creating New Contact");
		
		Map<String,String> map=excel.readFromExcel("Create Contact","ContactsTestData");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newContact.getPageHeader().contains(lastName));
		Thread.sleep(3000);
		newContact.clickContactsLink();
		
		if(contact.getNewContactName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create Contact","Pass",IConstantPath.EXCEL_PATH,"ContactsTestData");
		}
		else {
          System.out.println("Test Fail");
          excel.updateTestStatus("Create Contact","Fail",IConstantPath.EXCEL_PATH,"ContactsTestData");
          
		}
		soft.assertAll();
	}

}
