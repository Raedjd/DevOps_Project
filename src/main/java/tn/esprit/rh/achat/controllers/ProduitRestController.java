package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
@CrossOrigin("*")
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;

	// http://localhost:8089/SpringMVC/produit/retrieve-all-produits
	// @GetMapping("/retrieve-all-produits") This vulnerability by SonarQube
	@RequestMapping(path = "/retrieve-all-produits", method = RequestMethod.GET)
	@ResponseBody
	public List<Produit> getProduits() {
	 return  produitService.retrieveAllProduits();

	}

	// http://localhost:8089/SpringMVC/produit/retrieve-produit/8
	//@GetMapping("/retrieve-produit/{produit-id}")
	@RequestMapping(path = "/retrieve-produit/{produit-id}", method = RequestMethod.GET)
	@ResponseBody
	public Produit retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	/* Ajouter en produit tout en lui affectant la catégorie produit et le stock associés */
	// http://localhost:8089/SpringMVC/produit/add-produit/{idCategorieProduit}/{idStock}
	//@PostMapping("/add-produit")
	@RequestMapping(path = "/add-produit", method = RequestMethod.POST)
	@ResponseBody
	public Produit addProduit(@RequestBody Produit produit) {
		return produitService.addProduit(produit);

	}

	// http://localhost:8089/SpringMVC/produit/remove-produit/{produit-id}
	//@DeleteMapping("/remove-produit/{produit-id}")
	@RequestMapping(path = "/remove-produit/{produit-id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	// http://localhost:8089/SpringMVC/produit/modify-produit/{idCategorieProduit}/{idStock}
	//@PutMapping("/modify-produit")
	@RequestMapping(path = "/modify-produit", method = RequestMethod.PUT)
	@ResponseBody
	public Produit modifyProduit(@RequestBody Produit produit) {
		return produitService.updateProduit(produit);
	}


	// http://localhost:8089/SpringMVC/produit/assignProduitToStock/1/5
	//@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	@RequestMapping(path = "/assignProduitToStock/{idProduit}/{idStock}", method = RequestMethod.PUT)
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}


}
