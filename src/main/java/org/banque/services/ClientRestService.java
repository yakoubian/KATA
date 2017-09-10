package org.banque.services;

import java.util.List;

import org.banque.entities.Client;
import org.banque.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientRestService {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients", method=RequestMethod.POST) // on suppose que les données sont envoyées sous format Json (@RequestBody)
	//@ResponseBody  //le resultat va etre formaté en frmat json dans le corp de la reponse 
	//@ResponseBody  si on utilise @Controller au lieu de RestController
	public Client saveClient(@RequestBody Client c) {
		return clientMetier.saveClient(c);
	}

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> listClient() {
		return clientMetier.listClient();
	}
	
	
}
