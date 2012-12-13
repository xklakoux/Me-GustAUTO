package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the auto_ads database table.
 * 
 */
@Entity
@Table(name="auto_ads")
public class AutoAd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ad_id")
	private int adId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="add_date")
	private Date addDate;

	@Column(name="auto_moto")
	private String autoMoto;

	private String brand;

	private String colour;

	@Lob
	private String description;

	private String engine;

	private int mileage;

	private String model;

	private int months;

	private boolean paid;

	private BigDecimal price;

	@Column(name="registration_number")
	private String registrationNumber;

	private String title;

	private boolean valid;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="valid_to")
	private Date validTo;

	private String years;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="autoAd")
	private List<Comment> comments;

	//bi-directional many-to-one association to ConfirmationCode
	@OneToMany(mappedBy="autoAd")
	private List<ConfirmationCode> confirmationCodes;

	//bi-directional many-to-one association to Fav
	@OneToMany(mappedBy="autoAd")
	private List<Fav> favs;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="autoAd")
	private List<Message> messages;

	public AutoAd() {
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

	public String getAutoMoto() {
		return this.autoMoto;
	}

	public void setAutoMoto(String autoMoto) {
		this.autoMoto = autoMoto;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEngine() {
		return this.engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public int getMileage() {
		return this.mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMonths() {
		return this.months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public boolean getPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
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

	public String getYears() {
		return this.years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}