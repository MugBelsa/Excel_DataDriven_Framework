package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.List_Customer;
import page.LoginPage;
import page.Summary_Page;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;

	ExcelReader exlread = new ExcelReader("src\\main\\java\\data\\TF_TestData.xlsx");

	String userName = exlread.getCellData("LoginInfo", "UserName", 2);
	String password = exlread.getCellData("LoginInfo", "Password", 2);
	String fullName = exlread.getCellData("AddContactInfo", "FullName", 2);
	String companyName = exlread.getCellData("AddContactInfo", "CompanyName", 2);
	String email = exlread.getCellData("AddContactInfo", "Email", 2);
	String phone = exlread.getCellData("AddContactInfo", "Phone", 2);
	String address = exlread.getCellData("AddContactInfo", "Address", 2);
	String city = exlread.getCellData("AddContactInfo", "City", 2);
	String country = exlread.getCellData("AddContactInfo", "Country", 2);
	String state = exlread.getCellData("AddContactInfo", "State", 2);
	String zip = exlread.getCellData("AddContactInfo", "Zip", 2);

	@Test
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		DashboardPage dashBoard = PageFactory.initElements(driver, DashboardPage.class);
		dashBoard.verifyDashboardPage();
		dashBoard.clickCustomersButton();
		dashBoard.clickAddCustomersButton();

		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompany(companyName);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.ClickSaveButtonOnAddContact();

		Summary_Page summaryPage = PageFactory.initElements(driver, Summary_Page.class);

		summaryPage.clickListCustomers();

		List_Customer listContactsPage = PageFactory.initElements(driver, List_Customer.class);

		listContactsPage.ContactAssertion();
		listContactsPage.deleteContact();

		BrowserFactory.tearDown();
	}

	 

}