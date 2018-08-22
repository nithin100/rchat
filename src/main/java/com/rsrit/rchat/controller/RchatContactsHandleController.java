package com.rsrit.rchat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rsrit.rchat.models.RchatContact;
import com.rsrit.rchat.models.RchatUser;
import com.rsrit.rchat.service.RchatContactService;

/*
 *toDO: Get principle id from spring security 
 * 
 */

@RestController
@RequestMapping("/rchat/api/contacts/")
public class RchatContactsHandleController {

	@Autowired
	RchatContactService contactService;

	@GetMapping("search")
	public List<RchatUser> searchForContactByUserName(@RequestParam("userName") String userName) {
		return contactService.findPossibleUsersWithUsername(userName);
	}

	@PostMapping("add")
	public RchatContact addContact(@RequestBody RchatContact contact) {
		return contactService.addContact(contact);
	}

}
