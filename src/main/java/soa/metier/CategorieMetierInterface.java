package soa.metier;

import soa.entities.Categorie;
import java.util.List;

public interface CategorieMetierInterface {
    Categorie ajouterCategorie(Categorie c);
    List<Categorie> listeCategories();
}