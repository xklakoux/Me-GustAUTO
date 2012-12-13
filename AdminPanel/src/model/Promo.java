package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promos database table.
 * 
 */
@Entity
@Table(name="promos")
public class Promo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="promo_id")
	private int promoId;

	private String name;

	private int perc;

	private boolean valid;

	public Promo() {
	}

	public int getPromoId() {
		return this.promoId;
	}

	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPerc() {
		return this.perc;
	}

	public void setPerc(int perc) {
		this.perc = perc;
	}

	public boolean getValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}