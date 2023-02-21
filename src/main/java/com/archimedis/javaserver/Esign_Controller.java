package com.archimedis.javaserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;    
import java.util.Date;
import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin
@RestController
public class Esign_Controller {

	@Autowired
	EntryService service;

	@GetMapping("/redirect/{id}/{accountID}/{action}")
	public void method(@PathVariable String id, @PathVariable String accountID, @PathVariable String action,
			HttpServletResponse httpServletResponse) {
		service.initialPostToDB(id, accountID, action);
		httpServletResponse.setHeader("Location", "http://localhost:3000/" + id + "");
		httpServletResponse.setStatus(302);
	}

	@GetMapping("/getstatus/{id}")
	public String getStatus(@PathVariable String id) {
		return service.getResponse(id);
	}

	@GetMapping("/putstatus/{id}/{emailID}/{isCompleted}")
	public void putStatus(@PathVariable String id, @PathVariable String emailID, @PathVariable boolean isCompleted) {
		long millis=System.currentTimeMillis();  
		Date date = new Date(millis);
		java.sql.Timestamp time= new Timestamp(date.getTime());  
		System.out.println(id + " " + emailID + " " + date + isCompleted);
		service.setResponse(id, emailID, isCompleted,time);
	}
}
