package tn.esprit.rh.achat.controllers;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.rh.achat.services.ICategorieProduitService;

@ContextConfiguration(classes = {CategorieProduitController.class})
@ExtendWith(SpringExtension.class)
class CategorieProduitControllerTest {
    @Autowired
    private CategorieProduitController categorieProduitController;

    @MockBean
    private ICategorieProduitService iCategorieProduitService;

    /**
     * Method under test: {@link CategorieProduitController#getCategorieProduit()}
     */
    @Test
    void testGetCategorieProduit() throws Exception {
        when(iCategorieProduitService.retrieveAllCategorieProduits()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/categorieProduit/retrieve-all-categorieProduit");
        MockMvcBuilders.standaloneSetup(categorieProduitController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link CategorieProduitController#getCategorieProduit()}
     */
    @Test
    void testGetCategorieProduit2() throws Exception {
        when(iCategorieProduitService.retrieveAllCategorieProduits()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders
                .get("/categorieProduit/retrieve-all-categorieProduit");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(categorieProduitController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

