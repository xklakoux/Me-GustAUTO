package es.uc3m.ctw.me_gustauto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_added")
	private Date dateAdded;

	private int id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to AutoAd
	@ManyToOne
	@JoinColumn(name="ad_id")
	private AutoAd autoAd;

	public Comment() {
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateAdded() {
		return this.dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}