package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
@Slf4j
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduit addCategorieProduit(CategorieProduit cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	@Override
	public CategorieProduit updateCategorieProduit(CategorieProduit cp) {
		categorieProduitRepository.save(cp);
		log.info("category product get updated");
		return cp;
	}

	@Override
	public CategorieProduit retrieveCategorieProduit(Long id) {
		return categorieProduitRepository.findById(id).orElse(null);
	}

}
