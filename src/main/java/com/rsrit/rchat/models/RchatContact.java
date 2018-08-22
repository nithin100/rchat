package com.rsrit.rchat.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class RchatContact {

	@Id
	@GeneratedValue
	private int id;

	private String initiator;

	private String acceptor;

	/*@ElementCollection
	private Set<String> participants;*/

	@JsonProperty(access = Access.READ_ONLY)
	private int status;

	public RchatContact(String initiator, String acceptor, Set<String> participants, int status) {
		this.initiator = initiator;
		this.acceptor = acceptor;
		//this.participants = participants;
		this.status = 0;
	}

	public RchatContact() {

	}

	public String getInitiator() {
		return initiator;
	}

	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}

	public String getAcceptor() {
		return acceptor;
	}

	public void setAcceptor(String acceptor) {
		this.acceptor = acceptor;
	}

	/*public Set<String> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<String> participants) {
		this.participants = participants;
	}*/

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
