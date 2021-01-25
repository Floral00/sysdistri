

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace="http://www.polytech.nancy.fr")
public class MonService {
	
	public static List<Product> produits = new ArrayList<>();
	static {
		produits.add(new Product(1,"Tablette",25));
		produits.add(new Product(2,"ordinateur",150));
		produits.add(new Product(3,"Cable",255222));
		produits.add(new Product(4,"Camion",25888888));
		produits.add(new Product(5,"bonbon",1));
		produits.add(new Product(6,"r",257));
	}
	
	
	@WebMethod(operationName="AfficherLesproduits")
	public List<Product> afficherTousLesProduits() {
		return produits;
	}
	
	
	//ecrire une methode qui permet d'ajouter un produit

	@WebMethod(operationName="addProduct ")
	public Product addProduct(int code, String objet, double prix) {
		Product produit = new Product(code, objet, prix);
		produits.add(produit);
		return produit;
	}
	
	//ecireune methode qui permet de supprimer un produit 

	@WebMethod(operationName="delProduct")
	public String delProduct(int code) {
		for(Product p : produits) {
			if(p.getCode() == code) {
				produits.remove(p);
				return "Le produit ayant pour code "+ code + " a été supprimé";
			}
			
		}
		return "Le produit avec le code "+ code+" n'a pas pu être supprimé";
	}
	
	// ecrire une methode qui permet d'afficher tous es produits dont le prix est sup a celui afffiché

	@WebMethod(operationName="prixSupProduit")
	public List<Product> prixSupProduit(double prixSup) {
		List<Product> produits2 = new ArrayList<>();	
		
		for(Product p : produits) {
			if(p.getPrix()>= prixSup) {
				produits2.add(p);
			}
		}
		
		return produits2;
	}
	
	// annotation de JAX-WS
	@WebMethod(operationName="mamethode")
	public double convertir(@WebParam(name="montant")  double mt) {
		return mt*1.6;
	}
	
	public double somme(double a, double b) {
		return a+b;
	}
	
	public Product afficherProduit(int code) {
		return new Product(code, "Tablette", 25);
	}
}
