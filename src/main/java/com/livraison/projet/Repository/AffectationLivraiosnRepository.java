package com.livraison.projet.Repository;


import com.livraison.projet.Entities.AffectationCommande;
import com.livraison.projet.beans.AffectationCommandeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AffectationLivraiosnRepository extends JpaRepository<AffectationCommande,Long> {



    List<AffectationCommande> findByLivreurId(Long id);
   // boolean existByLivrasionIdAndLivreurId(Long idC,Long idL);







}
