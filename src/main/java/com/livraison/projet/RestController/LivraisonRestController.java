package com.livraison.projet.RestController;


import com.livraison.projet.Entities.Contact;
import com.livraison.projet.Services.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value ="/livraison")
public class LivraisonRestController {

    @Autowired
    LivraisonService livraisonService;



}
