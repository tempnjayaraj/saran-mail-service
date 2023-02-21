package com.archimedis.javaserver;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService {

	@Autowired
	EntryRepo repo;

	public void initialPostToDB(String UUID, String AccountID, String action) {
		repo.insertInitData(UUID, AccountID, action);
	}

	public String getResponse(String UUID) {
		return repo.getEmailID(UUID);
	}

	public void setResponse(String id, String emailID, boolean isCompleted,Timestamp date) {
		repo.insertFinalData(emailID, id, isCompleted,date);
	}
}
