package es.uc3m.ctw.me_gustauto.controller;

import java.util.LinkedList;
import java.util.List;

import es.uc3m.ctw.me_gustauto.model.AutoAd;

public class AutoAdListBean {
	
	private List<AutoAdBean> list = new LinkedList<AutoAdBean>();
	
	public AutoAdListBean() {
		List<Object> result = MySQLConnector.executeQuery("SELECT a FROM AutoAd a");
		for (Object o : result) {
			AutoAd autoAd = (AutoAd) MySQLConnector.createDeepCopy(o);
			if (autoAd == null) continue;
			
			AutoAdBean bean = new AutoAdBean();
			bean.setAd_id(autoAd.getAdId());
			bean.setTitle(autoAd.getTitle());
			bean.setBrand(autoAd.getBrand());
			bean.setModel(autoAd.getModel());
			bean.setEngine(autoAd.getEngine());
			bean.setRegistration_number(autoAd.getRegistrationNumber());
			bean.setYears(autoAd.getYears());
			bean.setPrice(autoAd.getPrice().doubleValue());
			bean.setMileage(autoAd.getMileage());
			bean.setColour(autoAd.getColour());
			bean.setDescription(autoAd.getDescription());
			bean.setUser_id(autoAd.getUser().getUserId());
			bean.setAuto_moto(autoAd.getAutoMoto());
			bean.setAdd_date(autoAd.getAddDate() == null ? null : autoAd.getAddDate().toString());
			bean.setValid_to(autoAd.getValidTo() == null ? null : autoAd.getValidTo().toString());
			list.add(bean);
		}
	}
	
	public List<AutoAdBean> getList() {
		return list;
	}
}
