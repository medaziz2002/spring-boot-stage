package com.livraison.projet.RestController;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.Commande;
import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.Services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/commande")
public class CommandeRestController {

    @Autowired
    CommandeService commandeService;


    @RequestMapping(value = "/cmd/{id}", method = RequestMethod.GET)
    public Optional<Commande> getCommandeById(@PathVariable("id") Long id) {
        return commandeService.getCommandeById(id);
    }




    @RequestMapping(method = RequestMethod.POST)
    public Commande ajoutCommande(@RequestBody Commande commande)
    {
        return commandeService.ajouterCommande(commande);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Commande> getAllCommande()
    {
       return  commandeService.listeCommande();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Commande modifierCommande(@PathVariable("id") Long id ,@RequestBody Commande commande)
    {
        return commandeService.modifierCommande(commande);
    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
    public void supprimerCommande(@PathVariable("id") Long id)
    {
        commandeService.supprimerById(id);
    }



    @GetMapping("/not-livred")
    public List<Commande> afficherLivraison()
    {
        return commandeService.afficherListLivraison();
    }
}
