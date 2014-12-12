package com.example.tests;

import org.openqa.selenium.WebElement;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String firstname;
	private String lastname;
	private String address1;
	private String home;
	private String mobile;
	private String work;
	private String email1;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	public String group;
	private String address2;
	private String phone2;

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
	
	public ContactData withID(String id) {
		this.id = id;
		return this;
	}
	
	public ContactData withFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}
	public ContactData withLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}
	public String getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getGroup() {
		return group;
	}
	public ContactData withAddress1(String address1) {
		this.address1 = address1;
		return this;
	}
	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}
	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}
	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	public String getFirstName() {
		return firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public String getAddress1() {
		return address1;
	}
	public String getHome() {
		return home;
	}
	public String getMobile() {
		return mobile;
	}
	public String getWork() {
		return work;
	}
	public String getEmail1() {
		return email1;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBday() {
		return bday;
	}
	public String getBmonth() {
		return bmonth;
	}
	public String getByear() {
		return byear;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}
	public void setByear(String byear) {
		this.byear = byear;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	
}
		
