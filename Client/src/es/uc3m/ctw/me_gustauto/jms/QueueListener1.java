package es.uc3m.ctw.me_gustauto.jms;

import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import es.uc3m.ctw.me_gustauto.model.*;

import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Message-Driven Bean implementation class for: QueueListener1
 * 
 */
@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "jms/Queue")
public class QueueListener1 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public QueueListener1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		if (message instanceof TextMessage) {
			TextMessage text = (TextMessage) message;
			try {
				es.uc3m.ctw.me_gustauto.model.Message msg = new es.uc3m.ctw.me_gustauto.model.Message();
				EntityManager manager = Persistence.createEntityManagerFactory(
						"megustauto").createEntityManager();
				EntityTransaction et = manager.getTransaction();
				et.begin();
				manager.persist(msg);
				AutoAd ad = new AutoAd();
				ad = manager.find(AutoAd.class,text.getIntProperty("idAd"));
				msg.setAutoAd(ad);
				msg.setContent(text.getText());

				msg.setUser1((User) (manager
						.createQuery("SELECT c FROM User c WHERE c.username=:userName")
						.setParameter("userName",
								text.getStringProperty("username"))
										.getResultList().get(0)));
				msg.setDateAdded(new Date());
				msg.setUser2(ad.getUser());
				et.commit();
				manager.close();
				System.out.println("success");
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

}
