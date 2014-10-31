package com.example.tests;

import org.openqa.selenium.WebElement;

public class ContactData implements Comparable<ContactData> {
	public String firstname;
	public String lastname;
	public String address1;
	public String home;
	public String mobile;
	public String work;
	public String email1;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String group;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	public ContactData(String firstname, String lastname, String address1,
			String home, String mobile, String work, String email1,
			String email2, String bday, String bmonth, String byear,
			String group, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group = group;
		this.address2 = address2;
		this.phone2 = phone2;
	}
	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname + "]";
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		//if (email1 == null) {
			//if (other.email1 != null)
			//	return false;
		//} else if (!email1.equals(other.email1))
		//	return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		//if (home == null) {
			//if (other.home != null)
			//	return false;
		//} else if (!home.equals(other.home))
		//	return false;
		return true;
	}
		
	@Override
	public int compareTo(ContactData other) {
						
			int result = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
			if (result !=0) {
				return result;
			}
			result =  this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
			if(result !=0) {
				return result;
			}
			return 0;
			}
		
}
		
