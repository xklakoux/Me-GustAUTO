package es.uc3m.ctw.me_gustauto.ejb;

import javax.ejb.Remote;

@Remote
public interface StatisticsRemote {
	public int getAutoAdsCount();
	public int getGeneralAdsCount();
	public double getTotalIncome();
}
