package es.uc3m.ctw.me_gustauto.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AutoAdListBean {
	
	private List<AutoAdBean> list = new LinkedList<AutoAdBean>();
	
	public AutoAdListBean() {
		ResultSet rs = MySQLConnector.executeQuery("SELECT * FROM auto_ads;");
		try {
			while (rs.next()) {
				AutoAdBean bean = new AutoAdBean();
				bean.fillWithData(); // TODO
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<AutoAdBean> getList() {
		return list;
	}
}
