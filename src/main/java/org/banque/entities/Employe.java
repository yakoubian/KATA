package org.banque.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Employe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7498874536841537742L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codeEmplye;
	private String nomEmplye;
	
	@ManyToOne
	@JoinColumn(name="code_emp_sup")
	private Employe emplyeSup;
	
	@ManyToMany
	@JoinColumn(name="EMP_GR")
	private Collection<Groupe> groupes;

	public Long getCodeEmplye() {
		return codeEmplye;
	}

	public void setCodeEmplye(Long codeEmplye) {
		this.codeEmplye = codeEmplye;
	}

	public String getNomEmplye() {
		return nomEmplye;
	}

	public void setNomEmplye(String nomEmplye) {
		this.nomEmplye = nomEmplye;
	}

	@JsonIgnore
	@XmlTransient
	public Employe getEmplyeSup() {
		return emplyeSup;
	}

	@JsonSetter
	public void setEmplyeSup(Employe emplyeSup) {
		this.emplyeSup = emplyeSup;
	}

	@JsonIgnore
	@XmlTransient
	public Collection<Groupe> getGroupes() {
		return groupes;
	}

	@JsonSetter
	public void setGroupes(Collection<Groupe> groupes) {
		this.groupes = groupes;
	}
	
	
}
