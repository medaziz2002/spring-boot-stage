package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.beans.CommandeDto;
import com.livraison.projet.beans.LivraisonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Long> {


    Optional<LivraisonDto> findByCommandeId(Long id);








}
