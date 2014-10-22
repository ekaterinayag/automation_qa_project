package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().InitContactModification(2);
	    ContactData Contact = new ContactData();
		Contact.firstname = "VALENTINA";
		app.getContactHelper().fillContactForm(Contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
	}
}
