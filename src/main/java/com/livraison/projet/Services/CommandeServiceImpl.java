package com.livraison.projet.Services;


import com.livraison.projet.Entities.Commande;

import com.livraison.projet.Repository.CommandeRepository;


import com.livraison.projet.beans.LivraisonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    LivreurService livreurService;


    @Override
    public Commande ajouterCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande modifierCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public void supprimerCommande(Commande commande) {
       commandeRepository.delete(commande);
    }

    @Override
    public List<Commande> listeCommande() {
        return commandeRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
     commandeRepository.deleteById(id);
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    @Override
    public LivraisonDto commandeToCommandeDto(Commande commande, LivraisonDto livraisonDto) {
        if (commande != null) {
            livraisonDto.setId(commande.getId());
          // livraisonDto.setCommande(commande.getCommande());
            livraisonDto.setLivred(livraisonDto.isLivred());

            return livraisonDto;
        } else
            return null;
    }

    @Override
    public List<Commande> afficherListLivraison() {
        return commandeRepository.findAll();
    }
}
