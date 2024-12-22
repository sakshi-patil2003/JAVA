package com.sakshi.contactmanager.data;

import com.sakshi.contactmanager.entity.Contact;

public interface Data {

	void addContact(Contact contact);
	
	void deleteContact(int id);
	
	Contact findContactById(int id);
	
	Contact[] findAllContacts();
}
