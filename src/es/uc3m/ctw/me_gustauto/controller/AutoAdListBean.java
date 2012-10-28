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
				bean.setAd_id(rs.getInt("ad_id"));
				bean.setTitle(rs.getString("title"));
				bean.setBrand(rs.getString("brand"));
				bean.setModel(rs.getString("model"));
				bean.setEngine(rs.getString("engine"));
				bean.setRegistration_number(rs.getString("registration_number"));
				bean.setYears(rs.getString("years"));
				bean.setPrice(rs.getDouble("price"));
				bean.setMileage(rs.getInt("mileage"));
				bean.setColour(rs.getString("colour"));
				bean.setDescription(rs.getString("description"));
				bean.setUser_id(rs.getInt("user_id"));
				bean.setAuto_moto(rs.getString("auto_moto"));
				bean.setAdd_date(rs.getString("add_date"));
				bean.setValid_to(rs.getString("valid_to"));
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
