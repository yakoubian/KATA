package org.banque.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4257261142450035226L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(Long numeroOperation, Date dateOperaion, double montant) {
		super(numeroOperation, dateOperaion, montant);
		// TODO Auto-generated constructor stub
	}


}
