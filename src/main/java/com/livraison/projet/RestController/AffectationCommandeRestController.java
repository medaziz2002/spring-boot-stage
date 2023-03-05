package com.livraison.projet.RestController;

import beans.AffectationCommandeLRq;
import com.livraison.projet.Services.AffectationCommandeService;
import com.livraison.projet.Services.CommandeService;
import com.livraison.projet.Services.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AffectationCommandeRestController {

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private LivreurService livreurService;
    @Autowired
    private AffectationCommandeService affectationCommandeService;

    @PostMapping("add")
    public ResponseEntity<?> addAffect(@RequestBody AffectationCommandeLRq affictationCommandeLRq) {
        return affectationCommandeService.addAffect(affictationCommandeLRq);

    }
}
