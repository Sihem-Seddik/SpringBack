package soa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soa.entities.Categorie;
import soa.entities.Produit;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    // This method is already provided by JpaRepository, so you don't need to declare it.
    // List<Categorie> findAll();

    // Example of a custom query if you need it
    @Query("SELECT c FROM Categorie c WHERE c.libelle = :libelle")
    List<Categorie> findByNom(@Param("libelle") String libelle);

    // Example of a query to find products by category
    @Query("SELECT p FROM Produit p WHERE p.categorie.id = :categorieId")
    List<Produit> findProduitsByCategorieId(@Param("categorieId") Long categorieId);
}