package es.uc3m.ctw.me_gustauto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the confirmation_codes database table.
 * 
 */
@Entity
@Table(name="confirmation_codes")
public class ConfirmationCode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cc_id")
	private int ccId;

	@Column(name="confirmation_code")
	private String confirmationCode;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to AutoAd
	@ManyToOne
	@JoinColumn(name="ad_id")
	private AutoAd autoAd;

	//bi-directional many-to-one association to GeneralAd
	@ManyToOne
	@JoinColumn(name="gen_id")
	private GeneralAd generalAd;

	public ConfirmationCode() {
	}

	public int getCcId() {
		return this.ccId;
	}

	public void setCcId(int ccId) {
		this.ccId = ccId;
	}

	public String getConfirmationCode() {
		return this.confirmationCode;
	}

	public void setConfirmationCode(String confirmationCode) {
		this.confirmationCode = confirmationCode;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AutoAd getAutoAd() {
		return this.autoAd;
	}

	public void setAutoAd(AutoAd autoAd) {
		this.autoAd = autoAd;
	}

	public GeneralAd getGeneralAd() {
		return this.generalAd;
	}

	public void setGeneralAd(GeneralAd generalAd) {
		this.generalAd = generalAd;
	}

}