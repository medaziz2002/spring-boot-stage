package com.livraison.projet.Repository;

import com.livraison.projet.Entities.Commande;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {

}
