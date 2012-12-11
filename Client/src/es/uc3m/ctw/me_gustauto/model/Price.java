package es.uc3m.ctw.me_gustauto.model;

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

	@Lob
	private String descr;

	private int id;

	private String name;

	private BigDecimal price;

	public Price() {
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}