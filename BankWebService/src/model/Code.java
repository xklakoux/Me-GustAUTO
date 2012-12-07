package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the codes database table.
 * 
 */
@Entity
@Table(name="codes")
public class Code implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="confirmation_codes")
	private String confirmationCodes;

	public Code() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConfirmationCodes() {
		return this.confirmationCodes;
	}

	public void setConfirmationCodes(String confirmationCodes) {
		this.confirmationCodes = confirmationCodes;
	}

}