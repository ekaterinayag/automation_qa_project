package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openContactCreationPage() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData Contact) {
		type(By.name("firstname"), Contact.firstname);
	    type(By.name("lastname"), Contact.lastname);
	    type(By.name("address"), Contact.address1);
	    type(By.name("home"), Contact.home);
	    type(By.name("mobile"), Contact.mobile);
	    type(By.name("work"), Contact.work);
	    type(By.name("email"), Contact.email1);
	    type(By.name("email2"), Contact.email2);
	    selectByText(By.name("bday"), Contact.bday);
	    selectByText(By.name("bmonth"), Contact.bmonth);
	    //selectByText(By.name("new_group"), "group 1");
	    type(By.name("byear"), Contact.byear);
	    type(By.name("address2"), Contact.address2);
	    type(By.name("phone2"), Contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home"));
	}

	public void InitContactModification(int index) {
		click(By.xpath("//table/tbody/tr[" + index + "]//img[@alt='Edit']"));
	}

    public void submitContactModification() {
    	click(By.xpath("//input[@name='update'][@value='Update']"));
	}

	public void deleteContact() {
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}

}
