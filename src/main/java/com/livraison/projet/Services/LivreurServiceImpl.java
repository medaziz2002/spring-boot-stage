package com.livraison.projet.Services;

import com.livraison.projet.beans.LivreurDto;
import com.livraison.projet.Entities.Livreur;
import com.livraison.projet.Repository.LivreurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreurServiceImpl implements LivreurService {

    @Autowired
    LivreurRepository livreurRepository;
    @Override
    public Livreur ajouterLivreur(Livreur livreur) {
       return livreurRepository.save(livreur);
    }

    @Override
    public Livreur modifierLivreur(Livreur livreur) {
      return  livreurRepository.save(livreur);
    }

    @Override
    public void supprimerLivreur(Livreur livreur) {
      livreurRepository.delete(livreur);
    }

    @Override
    public List<Livreur> listeLivreur() {
        return livreurRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
   livreurRepository.deleteById(id);
    }

    @Override
    public Optional<Livreur> getLivreurById(Long id) {
       return livreurRepository.findById(id);
    }

    @Override
    public LivreurDto livreurToLivreurDto(Livreur livreur, LivreurDto livreurDto) {
        if(livreur==null)
        {
            return null;
        }else
        {
            livreurDto.setEmail(livreur.getEmail());
            livreurDto.setId(livreur.getId());
            livreurDto.setLivreur(livreur.isLivreur());
            livreurDto.setNom(livreur.getNom());
            livreurDto.setNumtel(livreur.getNumtel());
            livreurDto.setPrenom(livreur.getPrenom());

            return livreurDto;
        }

    }
}
