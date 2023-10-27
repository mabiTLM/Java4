package com.java4.classweb.user.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java4.classweb.user.dao.UserDAO;
import com.java4.classweb.user.domain.User;

@Service
public class UserService {
	
	@Autowired
	UserDAO userDAO;
	
	
	public void add(User user) {
		System.out.println(cryptoPassword(user.getPassword(),"SHA-512"));
		user.setPassword(cryptoPassword(user.getPassword(),"SHA-256"));
		userDAO.add(user);
		System.out.println(user);
	}
	
	public User login(User user) {
		User tempUser = userDAO.get(user.getUserId());
		if(tempUser != null &&tempUser.getPassword().equals(cryptoPassword(user.getPassword(),"SHA-256"))) {
			return tempUser;
		}else return null;
	}
	
	private String cryptoPassword(String password, String method) {
		try {
			MessageDigest md = MessageDigest.getInstance(method);
			md.update(password.getBytes());
			byte[] sha256Hash = md.digest();
			StringBuilder sb = new StringBuilder();
			
			for(byte b : sha256Hash) {
				sb.append(String.format("%02x", b));
			}
			
			return sb.toString();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
