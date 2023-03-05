package com.livraison.projet.Services;


import beans.*;
import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livreur;
import com.livraison.projet.Repository.AffectationCommandeRepository;
import com.livraison.projet.Repository.CommandeRepository;
import com.livraison.projet.Repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AffectationCommandeServiceImpl implements AffectationCommandeService {

    AffectationCommandeDto affectationCommandeToAffectationCommandeDto(final AffectationCommande affectationCommande, final AffectationCommandeDto affectationCommandeDto);
    List<AffectationCommandeDto> findAllByLivreurId(Long id);
    ResponseEntity<?> addAffect(AffectationCommandeLRq affictationCommandeLRq );

    @Autowired
    private AffectationCommandeRepository affectationCommandeRepository;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private LivreurRepository livreurRepository;
    @Autowired
    private LivreurService livreurService;


    @Override
    public AffectationCommandeDto affectationCommandeToAffectationCommandeDto(AffectationCommande affectationCommande, AffectationCommandeDto affectationCommandeDto) {
        if(affectationCommande==null)
            return null;
        else
        {
            affectationCommandeDto.setCommandeDto(affectationCommande.getCommande()==null?null:commandeService.commandeToCommandeDto(affectationCommande.getCommande(),new CommandeDto()));
            affectationCommandeDto.setLivreurDto(affectationCommande.getLivreur()==null?null:livreurService.livreurToLivreurDto(affectationCommande.getLivreur(),new LivreurDto()));
            affectationCommandeDto.setId(affectationCommande.getId());
            return affectationCommandeDto;
        }
    }

    @Override
    public List<AffectationCommandeDto> findAllByLivreurId(Long id) {
        return affectationCommandeRepository.findByLivreurId(id).stream().map(affectationCommande -> affectationCommandeToAffectationCommandeDto(affectationCommande,new AffectationCommandeDto())).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<?> addAffect(AffectationCommandeLRq affictationCommandeLRq) {
        boolean testExist=affectationCommandeRepository.existByCommandeIdAndLivreurId(affictationCommandeLRq.getCommande(), affictationCommandeLRq.getLivreur());
        System.out.println("testExist"+testExist);
        if(!testExist){
            Optional<Livreur> liv = livreurRepository.findById(affictationCommandeLRq.getLivreur());
            Optional<Commande> comd = commandeRepository.findById(affictationCommandeLRq.getCommande());
            if(liv.isPresent() && comd.isPresent())
            {
                AffectationCommande aff = affectationCommandeRepository.save(new AffectationCommande(comd.get(), liv.get()));
                return new ResponseEntity<AffectationCommande>(aff,HttpStatus.CREATED);
            }else
                return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }else
            return new ResponseEntity<Void>(HttpStatus.FOUND);
    }

        }
