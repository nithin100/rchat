package com.rsrit.rchat.models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "rchat_conversations")
public class RchatConversation {

	@Id
	@GeneratedValue
	private int conversationId;

	@Column(name = "participant_user1")
	private String participant1UserName;

	@Column(name = "participant_user2")
	private String participant2UserName;

	/*
	 * @JsonProperty(access = Access.READ_ONLY)
	 * 
	 * @ManyToMany private List<RchatUser> participants;
	 */

	@JsonProperty(access = Access.READ_ONLY)
	@Transient
	private int numberOfUnreadMessages;

	@JsonProperty(access = Access.READ_ONLY)
	@Transient
	private Timestamp lastMessageSentAt;

	@JsonIgnore
	@OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RchatMessage> messagesOfTheConversation;
	
	@Transient
	@JsonProperty(access=Access.READ_ONLY)
	public String secondParticipant;

	public RchatConversation() {

	}

	public RchatConversation(String participant1UserName, String participant2UserName) {
		this.participant1UserName = participant1UserName;
		this.participant2UserName = participant2UserName;
	}

	public RchatConversation(int conversationId, String participant1UserName, String participant2UserName) {
		this.conversationId = conversationId;
		this.participant1UserName = participant1UserName;
		this.participant2UserName = participant2UserName;
	}

	public int getConversation_Id() {
		return conversationId;
	}

	public String getParticipant1UserName() {
		return participant1UserName;
	}

	public void setParticipant1UserName(String participant1UserName) {
		this.participant1UserName = participant1UserName;
	}

	public String getParticipant2UserName() {
		return participant2UserName;
	}

	public void setParticipant2UserName(String participant2UserName) {
		this.participant2UserName = participant2UserName;
	}

	/*
	 * public List<RchatUser> getParticipants() { return participants; }
	 * 
	 * public void setParticipants(List<RchatUser> participants) { this.participants
	 * = participants; }
	 */

	public int getNumberOfUnreadMessages() {
		return numberOfUnreadMessages;
	}

	public void setNumberOfUnreadMessages(int numberOfUnreadMessages) {
		this.numberOfUnreadMessages = numberOfUnreadMessages;
	}

	public Timestamp getLastMessageSentAt() {
		return lastMessageSentAt;
	}

	public void setLastMessageSentAt(Timestamp lastMessageSentAt) {
		this.lastMessageSentAt = lastMessageSentAt;
	}

	public List<RchatMessage> getMessagesOfTheConversation() {
		return messagesOfTheConversation;
	}

	public void setMessagesOfTheConversation(List<RchatMessage> messagesOfTheConversation) {
		this.messagesOfTheConversation = messagesOfTheConversation;
	}
	
	

	public String getSecondParticipant() {
		return secondParticipant;
	}

	public void setSecondParticipant(String secondParticipant) {
		this.secondParticipant = secondParticipant;
	}

	@Override
	public String toString() {
		return "RchatConversation [conversationId=" + conversationId + ", participant1UserName=" + participant1UserName
				+ ", participant2UserName=" + participant2UserName + "]";
	}

}
