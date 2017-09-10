package org.banque.metier;

import java.util.Date;

import org.banque.dao.CompteRepository;
import org.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteMetierImpl implements CompteMetier {

	@Autowired
	private CompteRepository compteRepository;

	@Override
	public Compte saveCompte(Compte cp) {
		cp.setDateCreation(new Date());
		return compteRepository.save(cp);
	}

	@Override
	public Compte getCompte(String code) {
		Compte cp = compteRepository.findOne(code);
		if (cp == null){
			throw new RuntimeException("Compte inexistant !!");
		}
		return cp;
	}
	
	

}
