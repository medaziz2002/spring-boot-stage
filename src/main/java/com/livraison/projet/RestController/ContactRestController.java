package com.livraison.projet.RestController;


import com.livraison.projet.Entities.Contact;
import com.livraison.projet.Services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value ="/contact")
public class ContactRestController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public Long countAll() {
        return contactService.countById();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Contact ajoutContact(@RequestBody Contact contact)
    {
        return contactService.ajouterContact(contact);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
     public Contact modifierContact(@PathVariable("id") Long id,@RequestBody Contact contact)
    {
        return contactService.modifierContact(contact);
    }

    @RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
    public void  supprimerContact(@PathVariable("id") Long id)
    {
        contactService.supprimerById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> getAllContact()
    {
      return   contactService.listeContact();
    }



}
