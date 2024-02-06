package org.dhiraj.SpringMVCPhoneBookApp.service;

import java.util.List;

import org.dhiraj.SpringMVCPhoneBookApp.model.Contacts;
import org.dhiraj.SpringMVCPhoneBookApp.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contactsService")
public class ContactsService {
@Autowired
ContactsRepository contactsRepository;

//ContactsRepository contactsRepository;
//public boolean isDataSaved(Contacts contacts) {
//	return contactsRepository.isDataSaved(contacts);
//}

public int isDataSaved(Contacts contacts) {
	return contactsRepository.isDataSaved(contacts);
}

public List<Contacts> getAllContact() {
	return contactsRepository.getAllContacts();
}

public List<Contacts> getAllContactBySearch(String user){
	return contactsRepository.getAllContactBySearch(user);
}

public boolean deleteDataUsingId(Integer id) {
	return contactsRepository.deleteDataUsingId(id);
}

public int checkEmail(String email) {
	return contactsRepository.checkEmail(email);
}

public int checkUsername(String username) {
	return contactsRepository.checkUsername(username);
}

public int checkContact(String contact) {
	return contactsRepository.checkContact(contact);
}

public List<Contacts> getAllContactForUpdate(Integer id) {
	return contactsRepository.getAllContactForUpdate(id);
}

public int UpdateUserData(Contacts contacts, Integer id) {
	return contactsRepository.UpdateUserData(contacts,id);
}

}
