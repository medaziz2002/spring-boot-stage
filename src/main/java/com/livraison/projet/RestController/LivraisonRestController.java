package com.livraison.projet.RestController;


import com.livraison.projet.Entities.Contact;
import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.Services.LivraisonService;
import com.livraison.projet.beans.LivraisonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value ="/livraison")
public class LivraisonRestController {

    @Autowired
    LivraisonService livraisonService;


/*
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Livraison confirmer(@PathVariable Long id)
    {

        return livraisonService.confirmer(id);
    }*/


    @PatchMapping("confirme/{id}")
    public Livraison confirmer(@PathVariable Long id)
    {
        return livraisonService.confirmer(id);
    }




}
