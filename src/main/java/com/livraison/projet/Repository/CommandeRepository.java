package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Commande;

import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.beans.CommandeDto;
import com.livraison.projet.beans.LivraisonDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

    @Override
    Optional<Commande> findById(Long id);



}
