package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SecteurActiviteMockitoImp {
    @Mock
    SecteurActiviteRepository secteurActiviteRepository;
    @InjectMocks
    SecteurActiviteServiceImpl secteurActiviteService;
    SecteurActivite secteur = new SecteurActivite("test", "test");
    List<SecteurActivite> listSecteur = new ArrayList<SecteurActivite>() {
        {
            add(new SecteurActivite("code1", "secteur1"));
            add(new SecteurActivite("code2", "secteur2"));
        }
    };

    @Test

    void retreiveSecteurActivite() {
        Mockito.when(secteurActiviteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(secteur));
        SecteurActivite secteur1 = secteurActiviteService.retrieveSecteurActivite(1L);
        Assertions.assertNotNull(secteur1);
    }
}
