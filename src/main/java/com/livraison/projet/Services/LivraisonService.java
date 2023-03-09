package com.livraison.projet.Services;

import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.beans.CommandeDto;
import com.livraison.projet.beans.LivraisonDto;

import java.util.List;

public interface LivraisonService {

    Livraison confirmer(Long id);

    List<CommandeDto> listeCommandeNonLivred();

    CommandeDto commandeToCommandeDto(final Livraison livraison, CommandeDto commandeDto);


    LivraisonDto livraisonToLivraisonDto(final Livraison livraison,final LivraisonDto livraisonDto);



}
