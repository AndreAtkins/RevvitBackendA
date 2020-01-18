package com.revature.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "revvits")
@Component
public class Revvit {


	
	
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "revvit_id")
private int revvit_id;	
	


@ManyToOne
private User author;



private String text;


private byte[] photo;



@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
       name = "user_liked_revvit", 
       joinColumns =  {@JoinColumn(name = "revvit_id",referencedColumnName = "revvit_id") },
       inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )	
private List<User> likes = new ArrayList<User>();	



@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(
       name = "user_rerevvit", 
       joinColumns =  {@JoinColumn(name = "revvit_id",referencedColumnName = "revvit_id") },
       inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}
    )	
private List<User> rerevs = new ArrayList<User>();



public Revvit() {
	super();
	// TODO Auto-generated constructor stub
}


public Revvit(int revvit_id, User author, String text, byte[] photo, List<User> likes, List<User> rerevs) {
	super();
	this.revvit_id = revvit_id;
	this.author = author;
	this.text = text;
	this.photo = photo;
	this.likes = likes;
	this.rerevs = rerevs;
}





public int getRevvit_id() {
	return revvit_id;
}



public void setRevvit_id(int revvit_id) {
	this.revvit_id = revvit_id;
}



public User getAuthor() {
	return author;
}



public void setAuthor(User author) {
	this.author = author;
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



public List<User> getLikes() {
	return likes;
}



public void setLikes(List<User> likes) {
	this.likes = likes;
}



public List<User> getRerevs() {
	return rerevs;
}



public void setRerevs(List<User> rerevs) {
	this.rerevs = rerevs;
}



@Override
public String toString() {
	return "Revvit [revvit_id=" + revvit_id + ", author=" + author + ", text=" + text + ", photo="
			+ Arrays.toString(photo) + ", likes=" + likes + ", rerevs=" + rerevs + "]";
}	





	
}
