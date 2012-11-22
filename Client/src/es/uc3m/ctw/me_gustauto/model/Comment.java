package es.uc3m.ctw.me_gustauto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the comments database table.
 * 
 */
@Entity
@Table(name="comments")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String content;

	//bi-directional many-to-one association to AutoAd
	@ManyToOne
	@JoinColumn(name="ad_id")
	private AutoAd autoAd;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Comment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public AutoAd getAutoAd() {
		return this.autoAd;
	}

	public void setAutoAd(AutoAd autoAd) {
		this.autoAd = autoAd;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}