package org.dhiraj.SpringMVCPhoneBookApp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.dhiraj.SpringMVCPhoneBookApp.model.Contacts;
import org.dhiraj.SpringMVCPhoneBookApp.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
@Autowired
ContactsService contactsService;
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}

	@RequestMapping(value="/home")
	public String HomeContact() {
		return "home";
	}
	
	@RequestMapping(value="/NewContact")
	public String AddNewContact() {
		return "addnewcontact";
	}

//	@RequestMapping(value="/save" ,method=RequestMethod.POST)
//	public String saveContacts(Contacts contacts, Map map) {
//	boolean b=contactsService.isDataSaved(contacts);
//	if(b) {
//		map.put("msg", "Record save successfully...............");
//	}else {
//		map.put("msg", "some problem is there..................");
//	}
//		return "addnewcontact";
//	}

	@RequestMapping(value="/save" ,method=RequestMethod.POST)
	public String saveContacts(Contacts contacts, Map map) {
	int b=contactsService.isDataSaved(contacts);
	if(b==1) {
		map.put("msg", "Record save successfully...............");
	}else if(b==-1){
		map.put("msg", "Email should not be duplicate..........");
	}else if(b==-2){
		map.put("msg", "Contact should not be duplicate........");
	}else if(b==-3){
		map.put("msg", "Username should not be duplicate.......");
	}else {
		map.put("msg", "some problem is there..................");
	}
		return "addnewcontact";
	}

	public List getContactsData() {
		List<Contacts> list=contactsService.getAllContact();
		return list;

	}
	@RequestMapping(value="viewrecords")
	public String viewRecords(Map map) {
		int count=1;
		map.put("list", getContactsData());
		return "view_all_contact";
	}

	@RequestMapping(value="checkemail", method=RequestMethod.GET)
	@ResponseBody
	public String checkEmailAvailability(@RequestParam("sendEmail") String email) {
		int rs=contactsService.checkEmail(email);
		if(rs>0)
			return "not available";
		else
			return "available";
	}

	@RequestMapping(value="checkusername", method=RequestMethod.GET)
	@ResponseBody
	public String checkUsernameAvailability(@RequestParam("sendUsername") String username) {
		int rs=contactsService.checkUsername(username);
		if(rs>0)
			return "not available";
		else
			return "available";
	}

	@RequestMapping(value="checkContact", method=RequestMethod.GET)
	@ResponseBody
	public String checkContactAvailability(@RequestParam("sendContact") String contact) {
		int rs=contactsService.checkContact(contact);
		if(rs>0)
			return "not available";
		else
			return "available";
	}

	@RequestMapping(value="search", method=RequestMethod.GET)
	@ResponseBody
	public String searchUserUsingFilter(@RequestParam("userSearch") String data) {
//		System.out.println(data);
		List<Contacts> list=contactsService.getAllContactBySearch(data);

		String str = "<table>";
		str=str+"<tr><th>Sr. No</th><th>Name</th><th>Email</th><th>Contact</th><th>UserName</th><th>Address</th><th>Delete</th><th>Update</th></tr>";
		int count=1;
		for(Contacts c:list) {

			str=str+"<tr><td>"+count+"</td><td>"+c.getName()+"</td><td>"+c.getEmail()+"</td><td>"+c.getContact()+"</td><td>"+c.getUsername()+"</td><td>"+c.getAddress()+"</td><td><a href='delete.do?id="+c.getId()+"'class='delete' ><i class='fa-regular fa-trash-can'></i>&nbsp Delete</a></td><td><a href='updatedataid.do?id="+c.getId()+"'class='update'><i class='fa-solid fa-pen-to-square'></i>&nbsp Update</a></td></tr>";
			count++;
		}
		str=str+"</table>";
//		System.out.println(str);
		return str;
	}

	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteData(@RequestParam("id") Integer id ,Map map) {
		boolean b= contactsService.deleteDataUsingId(id);
		int count=1;
		map.put("list", getContactsData());
		return "view_all_contact";
	}

	@RequestMapping(value="updatedataid", method=RequestMethod.GET)
	public String getDataForUpdate(@RequestParam("id") Integer id, Map map) {
		List<Contacts> list=contactsService.getAllContactForUpdate(id);
		map.put("list", list);
		return "update_data";
	}

	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateData(@RequestParam("userId") Integer id, Contacts contacts,Map map, Model model) {
		int b = contactsService.UpdateUserData(contacts,id);
		if(b>0)
			model.addAttribute("msg", "Record Update Successfully");
		else
			model.addAttribute("msg", "Record not update some problem is there");
		int count=1;
		map.put("list", getContactsData());
		return "view_all_contact";
	}
}
