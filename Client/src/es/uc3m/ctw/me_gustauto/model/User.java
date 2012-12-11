package es.uc3m.ctw.me_gustauto.model;

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

	private String role;

	private String salt;

	private String username;

	//bi-directional many-to-one association to AutoAd
	@OneToMany(mappedBy="user")
	private List<AutoAd> autoAds;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to ConfirmationCode
	@OneToMany(mappedBy="user")
	private List<ConfirmationCode> confirmationCodes;

	//bi-directional many-to-one association to Fav
	@OneToMany(mappedBy="user")
	private List<Fav> favs;

	//bi-directional many-to-one association to GeneralAd
	@OneToMany(mappedBy="user")
	private List<GeneralAd> generalAds;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user1")
	private List<Message> messages1;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user2")
	private List<Message> messages2;

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

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
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

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<ConfirmationCode> getConfirmationCodes() {
		return this.confirmationCodes;
	}

	public void setConfirmationCodes(List<ConfirmationCode> confirmationCodes) {
		this.confirmationCodes = confirmationCodes;
	}

	public List<Fav> getFavs() {
		return this.favs;
	}

	public void setFavs(List<Fav> favs) {
		this.favs = favs;
	}

	public List<GeneralAd> getGeneralAds() {
		return this.generalAds;
	}

	public void setGeneralAds(List<GeneralAd> generalAds) {
		this.generalAds = generalAds;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

}