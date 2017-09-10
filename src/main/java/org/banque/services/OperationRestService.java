package org.banque.services;

import org.banque.metier.OperationMetier;
import org.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

	@Autowired
	private OperationMetier operationMetier;

	/**
	 * 
	 * @param code
	 * @param montant
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/versement", method=RequestMethod.PUT)
	public boolean verser(
							@RequestParam String code, 
							@RequestParam double montant, 
							@RequestParam Long codeEmp) {
		
		return operationMetier.verser(code, montant, codeEmp);
	}

	
	/**
	 * 
	 * @param code
	 * @param solde
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/retrait", method=RequestMethod.PUT)
	public boolean retirer(
							@RequestParam String code, 
							@RequestParam double montant, 
							@RequestParam Long codeEmp) {
		
		return operationMetier.retirer(code, montant, codeEmp);
	}

	/**
	 * 
	 * @param cpte1
	 * @param cpte2
	 * @param montant
	 * @param codeEmp
	 * @return
	 */
	@RequestMapping(value="/virement", method=RequestMethod.PUT)
	public boolean virement(
							@RequestParam String cpte1, 
							@RequestParam String cpte2, 
							@RequestParam double montant, 
							@RequestParam Long codeEmp) {
		
		return operationMetier.virement(cpte1, cpte2, montant, codeEmp);
	}
	
	/**
	 * 
	 * @param codeCompte
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value="/operations",method=RequestMethod.GET)
	public PageOperation getOperations(
							@RequestParam String codeCompte, 
							@RequestParam int page, 
							@RequestParam int size) {
		
		return operationMetier.getOperations(codeCompte, page, size);
	}
	
}
