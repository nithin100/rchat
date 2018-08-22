package com.rsrit.rchat.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RchatContacts {

	@Id
	@GeneratedValue
	private int contact_id;

	@OneToMany
	private List<RchatDupUser> contactList;

	public List<RchatDupUser> getContactList() {
		return contactList;
	}

	public void setContactList(List<RchatDupUser> contactList) {
		this.contactList = contactList;
	}

	public RchatContacts(int contact_id, List<RchatDupUser> contactList) {
		super();
		this.contact_id = contact_id;
		this.contactList = contactList;
	}

}
