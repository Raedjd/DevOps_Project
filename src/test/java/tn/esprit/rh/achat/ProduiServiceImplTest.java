/*
package tn.esprit.rh.achat;



import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ProduitServiceImplTest {
    @Autowired
    IProduitService produitService;

    @Autowired
    ProduitRepository produitRepository;

    Produit produit = new Produit("p", "pc" , 12 ,new Date() );
    @Test
    @Order(1)
    void testaddProdiut() {
        Produit produitAdded =  produitService.addProduit(produit);
        Assertions.assertEquals(produitAdded.getCodeProduit(), produitAdded.getCodeProduit());
    }

    @Test
    @Order(2)
    void testRetrieveAllProduits() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(listProduits.size(), listProduits.size());
    }



}
 */