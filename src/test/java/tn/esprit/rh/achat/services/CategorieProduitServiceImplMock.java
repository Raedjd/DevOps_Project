package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategorieProduitServiceImplMock {

    @Mock
    CategorieProduitRepository categorieProduitRepository;

    @InjectMocks
    CategorieProduitServiceImpl categorieProduitService;

    CategorieProduit categorieProduit1 = new CategorieProduit(1L,"fffff","fefefe", Collections.emptySet());
    CategorieProduit categorieProduit2 = new CategorieProduit(2L,"fffff","fefefe", Collections.emptySet());
    CategorieProduit categorieProduit3 = new CategorieProduit(3L,"fffff","fefefe", Collections.emptySet());
    CategorieProduit categorieProduit4 = new CategorieProduit(4L,"fffff","fefefe", Collections.emptySet());

    List<CategorieProduit> listCP = new ArrayList<CategorieProduit>() {
        {
            add(categorieProduit1);
            add(categorieProduit2);
            add(categorieProduit3);
            add(categorieProduit4);
        }
    };

    @Test
    void testRetrieveCategorieProduit() {
        Mockito.when(categorieProduitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieProduit1));
        CategorieProduit CP1 = categorieProduitService.retrieveCategorieProduit(1L);
        Assertions.assertNotNull(CP1);
    }


}
