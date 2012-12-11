package es.uc3m.ctw.me_gustauto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the general_ads database table.
 * 
 */
@Entity
@Table(name="general_ads")
public class GeneralAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ad_id")
	private int adId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_date")
	private Date addDate;

	@Lob
	private String descr;

	private boolean paid;

	private String title;

	private boolean valid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_to")
	private Date validTo;

	//bi-directional many-to-one association to ConfirmationCode
	@OneToMany(mappedBy="generalAd")
	private List<ConfirmationCode> confirmationCodes;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public GeneralAd() {
	}

	public int getAdId() {
		return this.adId;
	}

	public void setAdId(int adId) {
		this.adId = adId;
	}

	public Date getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean getPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean getValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public List<ConfirmationCode> getConfirmationCodes() {
		return this.confirmationCodes;
	}

	public void setConfirmationCodes(List<ConfirmationCode> confirmationCodes) {
		this.confirmationCodes = confirmationCodes;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}