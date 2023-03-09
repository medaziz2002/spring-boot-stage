package com.livraison.projet.RestController;

import com.livraison.projet.beans.AffectationCommandeLRq;

import com.livraison.projet.Services.AffectationLivraisonService;
import com.livraison.projet.Services.CommandeService;
import com.livraison.projet.Services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/affectation")
public class AffectationCommandeRestController {

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private LivreurService livreurService;
    @Autowired
    private AffectationLivraisonService affectationLivraisonService;

    @PostMapping("add")
    public ResponseEntity<?> addAffect(@RequestBody AffectationCommandeLRq affictationCommandeLRq) {
        return affectationLivraisonService.addAffect(affictationCommandeLRq);

    }



}
