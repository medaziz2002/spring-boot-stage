package com.livraison.projet.Services;



import com.livraison.projet.Entities.AffectationCommande;
import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.Entities.Livreur;

import com.livraison.projet.Repository.AffectationLivraiosnRepository;
import com.livraison.projet.Repository.CommandeRepository;
import com.livraison.projet.Repository.LivraisonRepository;
import com.livraison.projet.Repository.LivreurRepository;
import com.livraison.projet.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AffectationLivraisonServiceImpl implements AffectationLivraisonService {

    @Autowired
    private AffectationLivraiosnRepository affectationLivraisonRepository;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    LivreurRepository livreurRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private LivreurService livreurService;

    
    @Autowired
    private LivraisonRepository livraisonRepository;

    @Override
    public AffectationCommandeDto affectationCommandeToAffectationCommandeDto(AffectationCommande affectationCommande, AffectationCommandeDto affectationCommandeDto) {
        if(affectationCommande==null)
            return null;
        else
        {
            affectationCommandeDto.setLivraisonDto(affectationCommande.getCommande()==null?null:commandeService.commandeToCommandeDto(affectationCommande.getCommande(),new LivraisonDto()));
            affectationCommandeDto.setLivreurDto(affectationCommande.getLivreur()==null?null:livreurService.livreurToLivreurDto(affectationCommande.getLivreur(),new LivreurDto()));
            affectationCommandeDto.setId(affectationCommande.getId());
            return affectationCommandeDto;
        }
    }

    @Override
    public List<AffectationCommande> findAllByLivreurId(Long id) {

        System.out.println("debug");
        System.out.println(id);
        return affectationLivraisonRepository.findByLivreurId(id);
    }

    @Override
    public ResponseEntity<?> addAffect(AffectationCommandeLRq affictationCommandeLRq) {
        boolean testExist=false;
        // affectationLivraisonRepository.existByLivrasionIdAndLivreurId(affictationCommandeLRq.getLivraison(),affictationCommandeLRq.getLivreur());
        System.out.println("testExist"+testExist);
        if(!testExist){
            Optional<Livreur> liv = livreurRepository.findById(affictationCommandeLRq.getLivreur());
            Optional<Commande> comd = commandeRepository.findById(affictationCommandeLRq.getCommande());
            if(liv.isPresent() && comd.isPresent())
            {
                AffectationCommande aff = affectationLivraisonRepository.save(new AffectationCommande(comd.get(), liv.get()));
               // Commande c=commandeRepository.getReferenceById();
                livraisonRepository.save(new Livraison(false,comd.get()));
                return new ResponseEntity<AffectationCommande>(aff,HttpStatus.CREATED);
            }else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else
            return new ResponseEntity<Void>(HttpStatus.FOUND);
    }

        }
