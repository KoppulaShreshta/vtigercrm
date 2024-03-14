package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactsPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.Leadspage;
import pomPages.Loginpage;
import pomPages.NewContactDetailsPage;
import pomPages.NewEventdetailsPage;
import pomPages.NewLeadDetailsPage;
import pomPages.NewOrgDetailsPage;
import pomPages.OrganizationsPage;

public class BaseClass {
	// @BeforeSuite
	// @BeforeTest

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected JavaUtility jutil;

	protected WebDriver driver;

	protected Loginpage login;
	protected HomePage home;
	protected OrganizationsPage org;
	protected ContactsPage contact;
	protected Leadspage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewLeadPage createLead;
	protected CreateNewEventPage createEvent;
	protected DuplicatingLeadPage duplicateLead;
	protected NewOrgDetailsPage newOrg;
	protected NewContactDetailsPage newContact;
	protected NewLeadDetailsPage newLead;
	protected NewEventdetailsPage newEvent;

	@BeforeClass
	public void classSetup() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();

		property.propertesInit(IConstantPath.PROPERTIES_PATH);
		driver = web.launchBrowserAndMaximize(property.readFromProperties("browser"));
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));

	}

	@BeforeMethod
	public void methodSetup() {
		login = new Loginpage(driver);
		home = new HomePage(driver);
		org = new OrganizationsPage(driver);
		contact = new ContactsPage(driver);
		lead = new Leadspage(driver);
		createOrg = new CreateNewOrganizationPage(driver);
		createContact = new CreateNewContactPage(driver);
		createLead = new CreateNewLeadPage(driver);
		createEvent = new CreateNewEventPage(driver);
		newOrg = new NewOrgDetailsPage(driver);
		newContact = new NewContactDetailsPage(driver);
		newLead = new NewLeadDetailsPage(driver);
		newEvent = new NewEventdetailsPage(driver);
		duplicateLead = new DuplicatingLeadPage(driver);

		excel.excelInit(IConstantPath.EXCEL_PATH);
		web.navigateToApp(property.readFromProperties("url"));
		login.loginToVtiger(property.readFromProperties("username"), property.readFromProperties("password"));

	}

	@AfterMethod
	public void methodTearDown() {
		home.signOutOfApp(web);
		excel.closeExcel();
	}

	@AfterClass
	public void classTeardown() {
		web.quitAllWindows();

	}
	// @AfterTest
	// @AfterSuite

}
