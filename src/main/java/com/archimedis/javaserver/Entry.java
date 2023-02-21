package com.archimedis.javaserver;

import java.sql.Timestamp;


import jakarta.persistence.Basic;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Entry {
	@Id	
	private String UUID;
	
	@Column(nullable = true, updatable = false)
        @CreationTimestamp
	private Timestamp timestamp;
	
	private String action;
	
	private String accountID;
	
	private String emailID;
	
	@Column(nullable = true)
	private boolean isCompleted;

	public Entry(String uUID, Timestamp timestamp, String action, String accountID, String emailID,
			boolean isCompleted) {
		super();
		UUID = uUID;
		this.timestamp = timestamp;
		this.action = action;
		this.accountID = accountID;
		this.emailID = emailID;
		this.isCompleted = isCompleted;
}
	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Entry() {

	}
}
