package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

public class FavListBean {	
	public List<?> getList(String username) {
		return MySQLConnector.executeQuery("SELECT f FROM Fav f WHERE f.user.username = '" + username + "'");
	}
}
