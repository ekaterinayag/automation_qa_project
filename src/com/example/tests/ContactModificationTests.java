package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().InitContactModification(1);
		ContactData Contact = new ContactData();
		Contact.firstname = "new firstname";
		app.getContactHelper().fillContactForm(Contact);
		app.getContactHelper().submitContactModification(1);
		app.getContactHelper().returnToHomePage();
	}
}
