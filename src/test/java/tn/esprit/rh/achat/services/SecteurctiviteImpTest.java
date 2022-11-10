package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecteurctiviteImpTest {
   /* @Autowired
    private  ISecteurActiviteService secteurActiviteService;
    @Test
    @Order(1)
    public void testRetrieveAllSecteurs() {
        List<SecteurActivite> listUsers = secteurActiviteService.retrieveAllSecteurActivite();
        Assertions.assertEquals(0, listUsers.size());
    }
    @Test
    void testaddSecteurActivite() {
        SecteurActivite sa = new SecteurActivite();
        sa.setLibelleSecteurActivite("stock 1");
        sa.setLibelleSecteurActivite("test");
        sa.setCodeSecteurActivite("123");

        SecteurActivite savedSecteur= secteurActiviteService.addSecteurActivite(sa);
        //assertEquals(sa.getLibelleSecteurActivite(), savedSecteur1.getLibelleSecteurActivite());
    }
    @Test
    void TestdeleteSecteurActivite() {
        secteurActiviteService.deleteSecteurActivite(1L);
    }
    @Test
    void TestretrieveStock() {
        secteurActiviteService.retrieveSecteurActivite(0L);
    }*/
}
