package es.uc3m.ctw.me_gustauto.controller;

import java.util.List;

public class AutoAdListBean {
	
	public List<Object> getList() {
		return MySQLConnector.executeQuery("SELECT a FROM AutoAd a");
	}
}
