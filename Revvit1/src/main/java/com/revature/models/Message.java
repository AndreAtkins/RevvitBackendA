package com.revature.models;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "message")
@Component
public class Message {
	

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "message_id")
private int message_id;		
	

private String text;
 
 
byte [] photo;

@ManyToOne
private User sender;	

@ManyToOne
private User receiver;

public Message() {
	super();
	// TODO Auto-generated constructor stub
}

public Message(int message_id, String text, byte[] photo, User sender, User receiver) {
	super();
	this.message_id = message_id;
	this.text = text;
	this.photo = photo;
	this.sender = sender;
	this.receiver = receiver;
}

public int getMessage_id() {
	return message_id;
}

public void setMessage_id(int message_id) {
	this.message_id = message_id;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public byte[] getPhoto() {
	return photo;
}

public void setPhoto(byte[] photo) {
	this.photo = photo;
}

public User getSender() {
	return sender;
}

public void setSender(User sender) {
	this.sender = sender;
}

public User getReceiver() {
	return receiver;
}

public void setReceiver(User receiver) {
	this.receiver = receiver;
}

@Override
public String toString() {
	return "Message [message_id=" + message_id + ", text=" + text + ", photo=" + Arrays.toString(photo) + ", sender="
			+ sender + ", receiver=" + receiver + "]";
}




}
