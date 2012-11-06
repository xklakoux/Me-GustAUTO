package es.uc3m.ctw.me_gustauto.controller;


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
		
		String query = "INSERT INTO users (username,full_name,hash,salt,email,phone,address) VALUES ('" + username + "','" + name + "','"
		+ MySQLConnector.sha1(password1, salt.toString())+ "','" + salt.toString() + "','" + email + "','" + phone + "','" + address + "');";
		
		MySQLConnector.execute(query);
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
