package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{

	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
	    app.getContactHelper().InitContactModification(1);
	    ContactData contact = new ContactData();
	    contact.firstname = "3Val";
		contact.lastname = "3Muller";
		contact.home = "333";
		contact.email1 = "kotobox@mail.ru";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
	    List<ContactData> newList = app.getContactHelper().getContacts();
	  
	  	//compare states
	   
	    oldList.remove(1);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
