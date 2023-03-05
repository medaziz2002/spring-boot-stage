package com.livraison.projet.Services;

import beans.AffectationCommande;
import beans.AffectationCommandeDto;
import beans.AffectationCommandeLRq;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AffectationCommandeService {

    AffectationCommandeDto affectationCommandeToAffectationCommandeDto(final AffectationCommande affectationCommande, final AffectationCommandeDto affectationCommandeDto);
    List<AffectationCommandeDto> findAllByLivreurId(Long id);
    ResponseEntity<?> addAffect(AffectationCommandeLRq affictationCommandeLRq );


}
