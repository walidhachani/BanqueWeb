package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.BanqueLocal;
import metier.entities.Compte;

@WebService
public class BanqueService {

	@EJB    // authowired avec spring
	private BanqueLocal metier ;
	
	@WebMethod
	public Compte addCompte(@WebParam(name="montant")double mt) {
		Compte cp = new Compte();
		cp.setSolde(mt);
		cp.setDateCreation(new Date());
		return metier.addCompte(cp);
	}

	@WebMethod
	public Compte getCompte(@WebParam(name="code")Long code) {
		return metier.getCompte(code);
	}

	@WebMethod
	public List<Compte> listComptes() {
		return metier.listComptes();
	}

	@WebMethod
	public void verser(@WebParam(name="code")Long code ,@WebParam(name="montant") double mt){
		metier.verser(code, mt);
		
	}
	
	@WebMethod
	public void retirer(@WebParam(name="code")Long code ,@WebParam(name="montant") double mt){
		metier.retirer(code, mt);
		
	}
	
	@WebMethod
	public void virement(@WebParam(name="code1")Long code1,@WebParam(name="code2")Long code2 ,@WebParam(name="montant") double mt){
		metier.virement(code1, code2, mt);;
		
	}
	
}
