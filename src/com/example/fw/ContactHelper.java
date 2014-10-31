package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.cell.CheckBoxTableCell;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openContactCreationPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.firstname);
	    type(By.name("lastname"), contact.lastname);
	    type(By.name("address"), contact.address1);
	    type(By.name("home"), contact.home);
	    type(By.name("mobile"), contact.mobile);
	    type(By.name("work"), contact.work);
	    type(By.name("email"), contact.email1);
	    type(By.name("email2"), contact.email2);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("byear"), contact.byear);
	    type(By.name("address2"), contact.address2);
	    type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home"));
	}

	public void InitContactModification(int index) {
		click(By.xpath("//table/tbody/tr["+ (index+2)+"]//img[@alt='Edit']"));
	}

    public void submitContactModification() {
    	click(By.xpath("//input[@name='update'][@value='Update']"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = getTableRows();
		for (WebElement row : rows) {
			ContactData contact = new ContactData();
				contact.firstname = row.findElement(By.xpath(".//td[3]")).getText();
				contact.lastname = row.findElement(By.xpath(".//td[2]")).getText();
				contacts.add(contact);
		}
		return contacts;
	}

	private List<WebElement> getTableRows() {
		return driver.findElements(By.xpath("//table//tr[@name='entry']"));
	}

		
}