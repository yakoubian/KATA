package org.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4636238991974794509L;

	public Versement(Long numeroOperation, Date dateOperaion, double montant) {
		super(numeroOperation, dateOperaion, montant);
		// TODO Auto-generated constructor stub
	}

	public Versement() {
		// TODO Auto-generated constructor stub
	}

}
