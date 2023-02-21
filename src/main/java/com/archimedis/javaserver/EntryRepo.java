package com.archimedis.javaserver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;

@Repository
public interface EntryRepo extends JpaRepository<Entry, String> {

	@Transactional
	@Modifying
	@Query(value = "insert into entry (uuid,accountid,action) values (:uid,:acntid,:action)", nativeQuery = true)
	public void insertInitData(@Param(value = "uid") String UUID, @Param(value = "acntid") String accountID,
			@Param(value = "action") String action);

	@Query(value = "select emailid from entry where uuid =  :uid", nativeQuery = true)
	public String getEmailID(@Param(value = "uid") String UUID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update entry set emailid = :emaild , is_completed = :isCompleted, timestamp = :date where uuid = :id ", nativeQuery = true)
	public void insertFinalData(@Param(value = "emaild") String emailid, 
			@Param(value = "id") String uuid,@Param(value = "isCompleted") boolean isCompleted ,
@Param(value = "date") Timestamp date);

}
