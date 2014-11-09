package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

public class ContactCreation extends TestBase{
	
@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	
 @Test (dataProvider = "contactsFromFile")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
            
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



  
