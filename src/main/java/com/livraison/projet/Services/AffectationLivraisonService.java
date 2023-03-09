package com.livraison.projet.Services;


import com.livraison.projet.Entities.AffectationCommande;
import com.livraison.projet.beans.AffectationCommandeDto;
import com.livraison.projet.beans.AffectationCommandeLRq;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AffectationLivraisonService {

    AffectationCommandeDto affectationCommandeToAffectationCommandeDto(final AffectationCommande affectationCommande, final AffectationCommandeDto affectationCommandeDto);
   List<AffectationCommande> findAllByLivreurId(Long id);
    ResponseEntity<?> addAffect(AffectationCommandeLRq affictationCommandeLRq );



}
