package es.uc3m.ctw.me_gustauto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnector {
	
	public static final String CLIENT_IS_LOGGED_IN = "CLIENT_IS_LOGGED_IN";
	public static final String USERNAME_OF_CLIENT = "USERNAME_OF_CLIENT";
	public static final int SALTLENGTH = 10;
	
	private static Connection connection = null;
	private static Statement statement = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/me_gustauto", "root", "1234");
			statement = connection.createStatement();
		} catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static boolean execute(String sql) {
		try {
			return statement.execute(sql);
		} catch (SQLException e) {e.printStackTrace();}
		return false;
	}
	
	public static ResultSet executeQuery(String sql) {
		try {
			return statement.executeQuery(sql);
		} catch (SQLException e) {e.printStackTrace();}
		return null;
	}
	
	public static String sha1(String password, String salt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA1");
		} catch (NoSuchAlgorithmException e) {}
		
		byte[] dataBytes = new byte[password.length()];
		for (int i=0; i < password.length(); i++) {
			dataBytes[i] = (byte)password.charAt(i);
		}
		md.update(dataBytes);
		
		dataBytes = new byte[salt.length()];
		for (int i=0; i < salt.length(); i++) {
			dataBytes[i] = (byte)salt.charAt(i);
		}
		md.update(dataBytes);
		
		byte[] mdbytes = md.digest();
		
		//convert byte to hex format
		StringBuilder hexString = new StringBuilder();
		for (int i=0; i < mdbytes.length; i++) {
			hexString.append(String.format("%02x", 0xFF & mdbytes[i]));
		}
		return hexString.toString();
	}
	
	public static boolean verifyLogin(String username, String password) {
		ResultSet rs = executeQuery("SELECT * FROM users WHERE username = '" + username + "';");
		try {
			if (!rs.first()) return false;
			String hash = sha1(password, rs.getString("salt"));
			if (rs.getString("hash").equals(hash)) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
