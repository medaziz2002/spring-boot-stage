package com.livraison.projet.Services;


import com.livraison.projet.Entities.Commande;
import com.livraison.projet.beans.LivraisonDto;


import java.util.List;
import java.util.Optional;

public interface CommandeService {
    Commande ajouterCommande(Commande commande);
    Commande modifierCommande(Commande commande);
    void supprimerCommande(Commande commande);
    List<Commande> listeCommande();
    void supprimerById(Long id);
    Optional<Commande> getCommandeById(Long id);

    LivraisonDto commandeToCommandeDto(final Commande commande, LivraisonDto livraisonDto);


    List<Commande>afficherListLivraison();
}
