package es.uc3m.ctw.me_gustauto.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uc3m.ctw.me_gustauto.model.User;

public class MySQLConnector {
	
	public static final String CLIENT_IS_LOGGED_IN = "CLIENT_IS_LOGGED_IN";
	public static final String USERNAME_OF_CLIENT = "USERNAME_OF_CLIENT";
	public static final String IS_ADMIN = "IS_ADMIN";
	public static final int SALTLENGTH = 10;
	
	public static final String PERSISTENCE_UNIT_NAME = "megustauto";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	private MySQLConnector() {}
	
	public static EntityManagerFactory getFactory() {
		return factory;
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
		EntityManager em = factory.createEntityManager();
		List<?> list = em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "'").getResultList();
		em.close();
		if (list.size() == 0) return false;
		User user = (User) createDeepCopy(list.get(0));
		if (user == null) return false;
		String hash = sha1(password, (user.getSalt()));
		if (user.getHash().equals(hash)) return true;
		return false;
	}
	
	public static boolean verifyAdmin(String username) {
		EntityManager em = factory.createEntityManager();
		List<?> list = em.createQuery("SELECT u FROM User u WHERE u.username = '" + username + "' AND u.role = 'admin'").getResultList();
		em.close();
		return list.size() != 0;
	}
	
	public static boolean favDoesNotExist(String username, int ad_id) {
		EntityManager em = factory.createEntityManager();
		List<?> list = em.createQuery("SELECT f FROM Fav f WHERE f.user.username = '" + username + "' AND f.autoAd.adId = " + ad_id).getResultList();
		em.close();
		return list.size() == 0;
	}
	
	public static Object createDeepCopy(Object o) {
		Object result = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(o);
			
			ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(out.toByteArray()));
			result = oin.readObject();
		} catch (Exception e) {e.printStackTrace();}
		return result;
	}
}
