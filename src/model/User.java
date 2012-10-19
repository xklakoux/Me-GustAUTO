package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private int userId;

	private String address;

	private String email;

	@Column(name="full_name")
	private String fullName;

	private String hash;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="join_date")
	private Date joinDate;

	private String phone;

	private int role;

	private String salt;

	private String username;

	//bi-directional many-to-one association to AutoAd
	@OneToMany(mappedBy="user")
	private List<AutoAd> autoAds;

	//bi-directional many-to-one association to GeneralAd
	@OneToMany(mappedBy="user")
	private List<GeneralAd> generalAds;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return this.role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<AutoAd> getAutoAds() {
		return this.autoAds;
	}

	public void setAutoAds(List<AutoAd> autoAds) {
		this.autoAds = autoAds;
	}

	public List<GeneralAd> getGeneralAds() {
		return this.generalAds;
	}

	public void setGeneralAds(List<GeneralAd> generalAds) {
		this.generalAds = generalAds;
	}

}