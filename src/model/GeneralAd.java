package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	private String title;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_to")
	private Date validTo;

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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}