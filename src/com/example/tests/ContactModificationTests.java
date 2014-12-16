package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTests extends TestBase{

	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
	}

	
 @Test (dataProvider = "contactsFromFile")
	public void modifySomeContact(ContactData contact) {
				
		//save old state
	 SortedListOf<ContactData> oldList 
	   = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getContactHelper().modifyContact(index, contact);
	   	    			
		//save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	  
	  	//compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
}
