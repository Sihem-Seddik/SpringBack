package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.metier.CategorieMetierInterface;

import java.util.List;

@RestController // pour déclarer un service web de type REST
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")  //    http://localhost:8080/produits // Toutes les URLs de ce contrôleur commencent par /categories
public class CategorieRESTController {

    @Autowired // Injection de dépendance
    private CategorieMetierInterface categorieMetier;

    // Endpoint pour récupérer toutes les catégories
    @GetMapping(value = "/", produces = "application/json")
    public List<Categorie> getAllCategories() {
        return categorieMetier.listeCategories();
    }

    // Endpoint pour ajouter une catégorie
    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public Categorie addCategorie(@RequestBody Categorie c) {
        return categorieMetier.ajouterCategorie(c);
    }

    // Endpoint pour récupérer une catégorie par son ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public Categorie getCategorieById(@PathVariable Long id) {
        return categorieMetier.listeCategories().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Endpoint pour supprimer une catégorie par son ID
    @DeleteMapping(value = "/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieMetier.listeCategories().removeIf(c -> c.getId().equals(id));
    }
}