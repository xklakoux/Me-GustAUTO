

package jhc.ws;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import model.Code;



public class BankServices {
	/**
	 * 
	 * @return null for bad data or confirmation code for correct data
	 */
	public java.lang.String validateCreditCard(java.lang.String number, java.lang.String month, java.lang.String year){

		String number_pattern = "\\d{16}"; // 16 digits
		String month_pattern = "([1-9]|1[0-2]|0[1-9])"; // 1-9 or 10-12 or 01-09
		String year_pattern = "\\d\\d"; // 2 digits (as written on credit cards)

		if(!number.matches(number_pattern) || !month.matches(month_pattern) || !year.matches(year_pattern)){
			return null;
		}else{
			if(Long.valueOf(number)%(Long.valueOf(month.concat(year))) != 0){ // the algorithm specified by the sprint
				return null;
			}else{
				// create confirmation code
				Code c = new Code();
				String confirmation_code = number+month+year+String.valueOf((new Date().getTime()));
				
				EntityManager em = Persistence.createEntityManagerFactory("BankWebService").createEntityManager();
				EntityTransaction et = em.getTransaction();
				
				et.begin();
				// add confirmation code to the database table
				em.persist(c);
				
				c.setConfirmationCodes(confirmation_code);
				
				et.commit();
				
				em.close();						
				
				
				return confirmation_code;
			}
		}
	}
}
