package com.livraison.projet.Repository;

import beans.AffectationCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AffectationCommandeRepository extends JpaRepository<AffectationCommande,Long> {

    List<AffectationCommande> findByLivreurId(Long id);
    boolean existByCommandeIdAndLivreurId(Long idC,Long idL);

}
