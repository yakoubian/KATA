package org.banque.metier;

import java.util.Date;

import org.banque.dao.CompteRepository;
import org.banque.dao.EmployeRepository;
import org.banque.dao.OperationRepository;
import org.banque.entities.Compte;
import org.banque.entities.Employe;
import org.banque.entities.Operation;
import org.banque.entities.Retrait;
import org.banque.entities.Versement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationMetierImpl implements OperationMetier{

	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	EmployeRepository employeRepository;
	
	
	@Override
	@Transactional
	public boolean verser(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);

		Employe employe = employeRepository.findOne(codeEmp);
		
		Operation o = new Versement();
		o.setDateOperaion(new Date());
		o.setMontant(montant);
		o.setEmplye(employe);
		o.setCompte(cp);
		operationRepository.save(o);
		
		cp.setSolde(cp.getSolde()+montant);
		compteRepository.save(cp);
		return true;
	}


	@Override
	@Transactional
	public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
		retirer(cpte1, montant, codeEmp);
		verser(cpte2, montant, codeEmp);
		return true;
	}

	@Override
	@Transactional
	public boolean retirer(String code, double montant, Long codeEmp) {
		Compte cp = compteRepository.findOne(code);
		if(cp.getSolde()<montant){
			throw new RuntimeException("Solde insuffisant");
		}
		
		Employe e = employeRepository.findOne(codeEmp);
		Operation r = new Retrait();
		r.setCompte(cp);
		r.setDateOperaion(new Date());
		r.setMontant(montant);
		r.setEmplye(e);
		operationRepository.save(r);
		
		cp.setSolde(cp.getSolde()-montant);
		compteRepository.save(cp);
		
		return true;
	}


	@Override
	public PageOperation getOperations(String codeCompte, int page, int size) {
		Page<Operation> ops = operationRepository.getOperations(codeCompte, new PageRequest(page, size));
		PageOperation pOp = new PageOperation();
		pOp.setOperations(ops.getContent());
		pOp.setNombreOperations(ops.getNumberOfElements());
		pOp.setPage(ops.getNumber());
		pOp.setTotalOperations(ops.getSize());
		pOp.setTotalPages(ops.getTotalPages());
		
		return pOp;
	}

}
