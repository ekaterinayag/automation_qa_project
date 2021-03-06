package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}	
		
		
		private void rebuildCache() {
			cachedContacts = new SortedListOf<ContactData>();
			
			manager.navigateTo().mainPage();
			List<WebElement> rows = getTableRows();
			for (WebElement row : rows) {
					String firstname = row.findElement(By.xpath(".//td[3]")).getText();
					String lastname = row.findElement(By.xpath(".//td[2]")).getText();
					cachedContacts.add(new ContactData().withFirstName(firstname).withLastName(lastname));
			}
			
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		openContactCreationPage();
		fillContactForm(contact, CREATION);
		//String bday = "15"
		//String bmonth = "January"
		//String byear = "1989";
		contact.group = "Bob1";
		submitContactCreation();
		returnToHomePage();
		rebuildCache();
		return this;
	    		
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		InitContactModification(index);
    	fillContactForm(contact, MODIFICATION);
    	submitContactModification();
    	returnToHomePage();
    	rebuildCache();
		return this;
		
	}

	public ContactHelper deleteContact(int index) {
		InitContactModification(index);
		submitContactDeletion(index);
		returnToHomePage();
		rebuildCache();
		return this;
	}

	
	//----------------------------------------------------------------------------------------------------
	
	public ContactHelper openContactCreationPage() {
		manager.navigateTo().mainPage();
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getFirstname());
	    type(By.name("lastname"), contact.getLastname());
	    type(By.name("address"), contact.getAddress1());
	    type(By.name("home"), contact.getHome());
	    type(By.name("mobile"), contact.getMobile());
	    type(By.name("work"), contact.getWork());
	    type(By.name("email"), contact.getEmail1());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    if (formType == CREATION) {
	    	//selectByText(By.name("new_group"), "group 1");
	    } else {
	    	if (driver.findElements(By.name("new group")).size() !=0) {
	    		throw new Error ("Group selector exists in contact modification form");
	    	}
	    }
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home"));
		//cachedContacts = null;
		return this;
	}

	public ContactHelper InitContactModification(int index) {
		manager.navigateTo().mainPage();
		click(By.xpath("//table/tbody/tr["+ (index+2)+"]//img[@alt='Edit']"));
		return this;
	}

    public ContactHelper submitContactModification() {
    	click(By.xpath("//input[@name='update'][@value='Update']"));
    	cachedContacts = null;
    	return this;
	}

	private List<WebElement> getTableRows() {
		return driver.findElements(By.xpath("//table//tr[@name='entry']"));
	}

	public void submitContactDeletion(int index) {
		click(By.xpath("//input[@name='update'][@value='Delete']"));
		cachedContacts = null;
	}
		
		
}