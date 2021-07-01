package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Summary_Page {
	
	WebDriver driver;
	BasePage basePage = new BasePage();

	public Summary_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library

	@FindBy(how = How.XPATH, using = "//a[@href='https://techfios.com/billing/?ng=contacts/list/']")
	WebElement LIST_CUSTOMER_FIELD;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Summary')]")
	WebElement SUMMARY_TEXT_FIELD;

	// Interactive Methods

	public void clickListCustomers() {
		basePage.waitForElement(driver, SUMMARY_TEXT_FIELD, 20);
		
		

		LIST_CUSTOMER_FIELD.click();
	}

}
