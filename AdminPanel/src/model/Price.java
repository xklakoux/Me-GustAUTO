package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the prices database table.
 * 
 */
@Entity
@Table(name="prices")
public class Price implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="price_id")
	private int priceId;

	private int months;

	private String name;

	private BigDecimal price;

	private String typ;

	public Price() {
	}

	public int getPriceId() {
		return this.priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
	}

	public int getMonths() {
		return this.months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

}