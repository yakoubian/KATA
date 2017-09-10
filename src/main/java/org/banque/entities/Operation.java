package org.banque.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(length=1)

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="type")
@JsonSubTypes({
	@Type(name="V", value=Versement.class),
	@Type(name="R", value=Retrait.class)
})
public class Operation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4293805884395187679L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroOperation; 
	
	private Date dateOperaion;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="CODE_CPTE")
	private Compte compte;
	
	@ManyToOne
	@JoinColumn(name="CODE_EMP")
	private Employe emplye;
	
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Operation(Long numeroOperation, Date dateOperaion, double montant) {
		super();
		this.numeroOperation = numeroOperation;
		this.dateOperaion = dateOperaion;
		this.montant = montant;
	}
	
	
	
	public Long getNumeroOperation() {
		return numeroOperation;
	}
	public void setNumeroOperation(Long numeroOperation) {
		this.numeroOperation = numeroOperation;
	}
	public Date getDateOperaion() {
		return dateOperaion;
	}
	public void setDateOperaion(Date dateOperaion) {
		this.dateOperaion = dateOperaion;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Employe getEmplye() {
		return emplye;
	}
	public void setEmplye(Employe emplye) {
		this.emplye = emplye;
	}
	
	
}
