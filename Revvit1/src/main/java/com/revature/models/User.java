package com.revature.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "users")
@Component
public class User implements Serializable {

	private static final long serialVersionUID = -4553508689874995351L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private byte[] profilepicture;
	
	
	
	@OneToMany
	
	private List<Revvit> revvits = new ArrayList<>();
	
	
	
	@OneToMany(mappedBy="sender", fetch = FetchType.LAZY)
	private List<Message> send_messages = new ArrayList<>();
	
	

	@OneToMany(mappedBy="receiver", fetch = FetchType.LAZY)
	private List<Message> received_messages = new ArrayList<>();

	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	       name = "user_liked_revvit", 
	       joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "user_id") }, 
	       inverseJoinColumns = {@JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }
	    )
	private List<Revvit> liked;
	
	@ManyToMany( fetch = FetchType.EAGER)
	@JoinTable(
	        name = "user_reRevvited", 
	        joinColumns = { @JoinColumn(name = "user_id",referencedColumnName = "user_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "revvit_id", referencedColumnName = "revvit_id") }
	    )
	private List<Revvit> reRevvited;
		
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_followers",
				joinColumns = {@JoinColumn(name = "source_id", referencedColumnName = "user_id")},
				inverseJoinColumns = {@JoinColumn(name = "target_id", referencedColumnName = "user_id")})
	private List<User> followers;
	
	
	@Column
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_following",
				joinColumns = {@JoinColumn(name = "target_id", referencedColumnName = "user_id")},
				inverseJoinColumns = {@JoinColumn(name = "source_id", referencedColumnName = "user_id")})
	private List<User> following;

	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String username, String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", profilepicture=" + Arrays.toString(profilepicture)
				+ ", revvits=" + revvits + ", send_messages=" + send_messages + ", received_messages="
				+ received_messages + ", liked=" + liked + ", reRevvited=" + reRevvited + ", followers=" + followers
				+ ", following=" + following + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(byte[] profilepicture) {
		this.profilepicture = profilepicture;
	}

	public List<Revvit> getRevvits() {
		return revvits;
	}

	public void setRevvits(List<Revvit> revvits) {
		this.revvits = revvits;
	}

	public List<Message> getSend_messages() {
		return send_messages;
	}

	public void setSend_messages(List<Message> send_messages) {
		this.send_messages = send_messages;
	}

	public List<Message> getReceived_messages() {
		return received_messages;
	}

	public void setReceived_messages(List<Message> received_messages) {
		this.received_messages = received_messages;
	}

	public List<Revvit> getLiked() {
		return liked;
	}

	public void setLiked(List<Revvit> liked) {
		this.liked = liked;
	}

	public List<Revvit> getReRevvited() {
		return reRevvited;
	}

	public void setReRevvited(List<Revvit> reRevvited) {
		this.reRevvited = reRevvited;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}
	
	
	
	
	
		
}