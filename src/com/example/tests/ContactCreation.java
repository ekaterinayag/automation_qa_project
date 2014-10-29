package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactCreation extends TestBase{
  
	@Test	
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
        
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().openContactCreationPage();
    ContactData contact = new ContactData();
    contact.firstname = "1Val";
	contact.lastname = "1Muller";
	contact.address1 = "vesnast";
	contact.home = "99999999999999999999";
	contact.mobile = "888888888888888888888";
	contact.work = "7777777777777777777777";
	contact.email1 = "jkgh@sdf.com";
	contact.email2 = "sdjkfh@sdlfk.com";
	contact.bday = "1";
	contact.bmonth = "January";
	contact.byear = "1989";
	contact.group = "Freunde";
	contact.address2 = "naukipr";
	contact.phone2 = "6666666666666666666666";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  
  	//save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
  
  	//compare states
   
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
	
	}
}



  
