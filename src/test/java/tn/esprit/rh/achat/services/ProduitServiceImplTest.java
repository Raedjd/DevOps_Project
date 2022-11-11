package tn.esprit.rh.achat.services;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.DetailFacture;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

@ContextConfiguration(classes = {ProduitServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProduitServiceImplTest {
    @MockBean
    private CategorieProduitRepository categorieProduitRepository;

    @MockBean
    private ProduitRepository produitRepository;

    @Autowired
    private ProduitServiceImpl produitServiceImpl;

    @MockBean
    private StockRepository stockRepository;

    /**
     * Method under test: {@link ProduitServiceImpl#assignProduitToStock(Long, Long)}
     */
    @Test
    void testAssignProduitToStock() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setCodeCategorie("Code Categorie");
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setLibelleCategorie("Libelle Categorie");
        categorieProduit.setProduits(new HashSet<>());

        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setLibelleStock("Libelle Stock");
        stock.setProduits(new HashSet<>());
        stock.setQte(1);
        stock.setQteMin(1);

        Produit produit = new Produit();
        produit.setCategorieProduit(categorieProduit);
        produit.setCodeProduit("Code Produit");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit.setDateCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit.setDateDerniereModification(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        produit.setDetailFacture(new HashSet<>());
        produit.setIdProduit(1L);
        produit.setLibelleProduit("Libelle Produit");
        produit.setPrix(10.0f);
        produit.setStock(stock);
        Optional<Produit> ofResult = Optional.of(produit);

        CategorieProduit categorieProduit1 = new CategorieProduit();
        categorieProduit1.setCodeCategorie("Code Categorie");
        categorieProduit1.setIdCategorieProduit(1L);
        categorieProduit1.setLibelleCategorie("Libelle Categorie");
        categorieProduit1.setProduits(new HashSet<>());

        Stock stock1 = new Stock();
        stock1.setIdStock(1L);
        stock1.setLibelleStock("Libelle Stock");
        stock1.setProduits(new HashSet<>());
        stock1.setQte(1);
        stock1.setQteMin(1);

        Produit produit1 = new Produit();
        produit1.setCategorieProduit(categorieProduit1);
        produit1.setCodeProduit("Code Produit");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit1.setDateCreation(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit1.setDateDerniereModification(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        produit1.setDetailFacture(new HashSet<>());
        produit1.setIdProduit(1L);
        produit1.setLibelleProduit("Libelle Produit");
        produit1.setPrix(10.0f);
        produit1.setStock(stock1);
        when(produitRepository.save((Produit) any())).thenReturn(produit1);
        when(produitRepository.findById((Long) any())).thenReturn(ofResult);

        Stock stock2 = new Stock();
        stock2.setIdStock(1L);
        stock2.setLibelleStock("Libelle Stock");
        stock2.setProduits(new HashSet<>());
        stock2.setQte(1);
        stock2.setQteMin(1);
        Optional<Stock> ofResult1 = Optional.of(stock2);
        when(stockRepository.findById((Long) any())).thenReturn(ofResult1);
        produitServiceImpl.assignProduitToStock(1L, 1L);
        verify(produitRepository).save((Produit) any());
        verify(produitRepository).findById((Long) any());
        verify(stockRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link ProduitServiceImpl#assignProduitToStock(Long, Long)}
     */
    @Test
    void testAssignProduitToStock2() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setCodeCategorie("Code Categorie");
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setLibelleCategorie("Libelle Categorie");
        categorieProduit.setProduits(new HashSet<>());

        Stock stock = new Stock();
        stock.setIdStock(1L);
        stock.setLibelleStock("Libelle Stock");
        stock.setProduits(new HashSet<>());
        stock.setQte(1);
        stock.setQteMin(1);
        Produit produit = mock(Produit.class);
        doNothing().when(produit).setCategorieProduit((CategorieProduit) any());
        doNothing().when(produit).setCodeProduit((String) any());
        doNothing().when(produit).setDateCreation((Date) any());
        doNothing().when(produit).setDateDerniereModification((Date) any());
        doNothing().when(produit).setDetailFacture((Set<DetailFacture>) any());
        doNothing().when(produit).setIdProduit((Long) any());
        doNothing().when(produit).setLibelleProduit((String) any());
        doNothing().when(produit).setPrix(anyFloat());
        doNothing().when(produit).setStock((Stock) any());
        produit.setCategorieProduit(categorieProduit);
        produit.setCodeProduit("Code Produit");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit.setDateCreation(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit.setDateDerniereModification(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        produit.setDetailFacture(new HashSet<>());
        produit.setIdProduit(1L);
        produit.setLibelleProduit("Libelle Produit");
        produit.setPrix(10.0f);
        produit.setStock(stock);
        Optional<Produit> ofResult = Optional.of(produit);

        CategorieProduit categorieProduit1 = new CategorieProduit();
        categorieProduit1.setCodeCategorie("Code Categorie");
        categorieProduit1.setIdCategorieProduit(1L);
        categorieProduit1.setLibelleCategorie("Libelle Categorie");
        categorieProduit1.setProduits(new HashSet<>());

        Stock stock1 = new Stock();
        stock1.setIdStock(1L);
        stock1.setLibelleStock("Libelle Stock");
        stock1.setProduits(new HashSet<>());
        stock1.setQte(1);
        stock1.setQteMin(1);

        Produit produit1 = new Produit();
        produit1.setCategorieProduit(categorieProduit1);
        produit1.setCodeProduit("Code Produit");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit1.setDateCreation(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        produit1.setDateDerniereModification(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        produit1.setDetailFacture(new HashSet<>());
        produit1.setIdProduit(1L);
        produit1.setLibelleProduit("Libelle Produit");
        produit1.setPrix(10.0f);
        produit1.setStock(stock1);
        when(produitRepository.save((Produit) any())).thenReturn(produit1);
        when(produitRepository.findById((Long) any())).thenReturn(ofResult);

        Stock stock2 = new Stock();
        stock2.setIdStock(1L);
        stock2.setLibelleStock("Libelle Stock");
        stock2.setProduits(new HashSet<>());
        stock2.setQte(1);
        stock2.setQteMin(1);
        Optional<Stock> ofResult1 = Optional.of(stock2);
        when(stockRepository.findById((Long) any())).thenReturn(ofResult1);
        produitServiceImpl.assignProduitToStock(1L, 1L);
        verify(produitRepository).save((Produit) any());
        verify(produitRepository).findById((Long) any());
        verify(produit).setCategorieProduit((CategorieProduit) any());
        verify(produit).setCodeProduit((String) any());
        verify(produit).setDateCreation((Date) any());
        verify(produit).setDateDerniereModification((Date) any());
        verify(produit).setDetailFacture((Set<DetailFacture>) any());
        verify(produit).setIdProduit((Long) any());
        verify(produit).setLibelleProduit((String) any());
        verify(produit).setPrix(anyFloat());
        verify(produit, atLeast(1)).setStock((Stock) any());
        verify(stockRepository).findById((Long) any());
    }
}

