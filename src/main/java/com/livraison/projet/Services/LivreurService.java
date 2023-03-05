package com.livraison.projet.Services;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.Livreur;


import java.util.List;
import java.util.Optional;

public interface LivreurService {
    Livreur ajouterLivreur(Livreur livreur);

    Livreur modifierLivreur(Livreur livreur);

    void supprimerLivreur(Livreur livreur);

    List<Livreur> listeLivreur();

    void supprimerById(Long id);

    Optional<Livreur> getLivreurById(Long id);
}