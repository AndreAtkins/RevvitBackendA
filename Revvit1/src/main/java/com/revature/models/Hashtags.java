package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "hashtags")
@Component
public class Hashtags {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
private int hashtag_id;

@Column
private String text;


@Column
private transient List<Revvit> revvits = new ArrayList<Revvit>();


public Hashtags() {
	super();
	// TODO Auto-generated constructor stub
}


public Hashtags(int hashtag_id, String text, List<Revvit> revvits) {
	super();
	this.hashtag_id = hashtag_id;
	this.text = text;
	this.revvits = revvits;
}


public int getHashtag_id() {
	return hashtag_id;
}


public void setHashtag_id(int hashtag_id) {
	this.hashtag_id = hashtag_id;
}


public String getText() {
	return text;
}


public void setText(String text) {
	this.text = text;
}


public List<Revvit> getRevvits() {
	return revvits;
}


public void setRevvits(List<Revvit> revvits) {
	this.revvits = revvits;
}


@Override
public String toString() {
	return "Hashtags [hashtag_id=" + hashtag_id + ", text=" + text + "]";
}
	





}








