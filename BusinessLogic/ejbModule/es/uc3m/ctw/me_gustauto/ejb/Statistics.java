package es.uc3m.ctw.me_gustauto.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Statistics
 */
@Stateless
public class Statistics implements StatisticsRemote {
	
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
	
	@Override
	public int getAutoAdsCount() {
		int result = -1;
		try {
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM auto_ads;");
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {e.printStackTrace();}
		return result;
	}
	
	@Override
	public int getGeneralAdsCount() {
		int result = -1;
		try {
			ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM general_ads;");
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {e.printStackTrace();}
		return result;
	}
	
	@Override
	public double getTotalIncome() {
		double result = -1;
		int autoAdsCount = getAutoAdsCount();
		double autoAdsPrice;
		int generalAdsCount = getGeneralAdsCount();
		double generalAdsPrice;
		try {
			ResultSet rs = statement.executeQuery("SELECT price FROM prices WHERE name = '1 month';");
			rs.next();
			autoAdsPrice = rs.getDouble(1);
			
			rs = statement.executeQuery("SELECT price FROM prices WHERE name = '3 month';");
			rs.next();
			generalAdsPrice = rs.getDouble(1);
			
			result = autoAdsCount*autoAdsPrice + generalAdsCount*generalAdsPrice;
		} catch (SQLException e) {e.printStackTrace();}
		return result;
	}

}
