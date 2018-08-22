package com.rsrit.rchat.models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class RchatMessage {

	@Id
	@GeneratedValue
	private int message_Id;

	@ManyToOne
	@JoinColumn(name = "conversation_id")
	private RchatConversation conversation;

	private String messageSender;

	private String messageReceiver;

	private String messageContent;

	@JsonProperty(access = Access.READ_ONLY)
	private Timestamp messageSentAt;

	@JsonProperty(access = Access.READ_ONLY)
	private boolean isMessageRead;

	public RchatMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RchatMessage(RchatConversation conversation, String messageSender, String messageReceiver,
			String messageContent, Timestamp messageSentAt, boolean isMessageRead) {
		super();
		this.conversation = conversation;
		this.messageSender = messageSender;
		this.messageReceiver = messageReceiver;
		this.messageContent = messageContent;
		this.messageSentAt = messageSentAt;
		this.isMessageRead = isMessageRead;
	}

	public RchatConversation getConversation() {
		return conversation;
	}

	public void setConversation(RchatConversation conversation) {
		conversation.getMessagesOfTheConversation().add(this);
		this.conversation = conversation;
	}

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	public String getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(String messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Timestamp getMessageSentAt() {
		return messageSentAt;
	}

	public void setMessageSentAt(Timestamp messageSentAt) {
		this.messageSentAt = messageSentAt;
	}

	public boolean isMessageRead() {
		return isMessageRead;
	}

	public void setMessageRead(boolean isMessageRead) {
		this.isMessageRead = isMessageRead;
	}

}
