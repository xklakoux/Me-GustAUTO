package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the favs database table.
 * 
 */
@Entity
@Table(name="favs")
public class Fav implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fav_id")
	private int favId;

	//bi-directional many-to-one association to AutoAd
	@ManyToOne
	@JoinColumn(name="ad_id")
	private AutoAd autoAd;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Fav() {
	}

	public int getFavId() {
		return this.favId;
	}

	public void setFavId(int favId) {
		this.favId = favId;
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