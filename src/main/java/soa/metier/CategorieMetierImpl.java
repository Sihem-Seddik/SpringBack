package soa.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Categorie;
import soa.repository.CategorieRepository;
import java.util.List;

@Service
public class CategorieMetierImpl implements CategorieMetierInterface {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieMetierImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie ajouterCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public List<Categorie> listeCategories() {
        return categorieRepository.findAll();
    }
}