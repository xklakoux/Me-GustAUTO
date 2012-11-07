package es.uc3m.ctw.me_gustauto.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import es.uc3m.ctw.me_gustauto.model.User;


public class ClientBean {
	
	private String username = "";
	private String name = "";
	private String email = "";
	private String address = "";
	private String phone = "";
	private String password1 = "";
	
	public void storeClient() {
		StringBuilder salt = new StringBuilder();
		for (int i=0; i<MySQLConnector.SALTLENGTH; i++) {
			salt.append((char) (Math.random()*25.0 + 65));
		}
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(MySQLConnector.PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		User u = new User();
		em.persist(u);
		u.setUsername(username);
		u.setFullName(name);
		u.setHash(MySQLConnector.sha1(password1, salt.toString()));
		u.setSalt(salt.toString());
		u.setEmail(email);
		u.setPhone(phone);
		u.setAddress(address);
		
		tx.commit();
		em.close();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
}
