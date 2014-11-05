package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase{
	
 @Test (dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
    app.navigateTo().mainPage();
        
    //save old state
    ContactHelper contactHelper = app.getContactHelper();
    SortedListOf<ContactData> oldList = contactHelper.getContacts();
    
    //actions
	app.getContactHelper().createContact (contact);
	   
  	//save new state
	SortedListOf<ContactData> newList = contactHelper.getContacts();
  
  	//compare states
	assertThat(newList, equalTo(oldList.withAdded(contact)));
	
	}
}



  
