package com.livraison.projet.Services;


import com.livraison.projet.Repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonServiceImpl implements LivraisonService {


    @Autowired
    LivraisonRepository livraisonRepository;

    @Override
    public void ajouterLivraison1(Long id1) {

    }

    @Override
    public void ajouterLivraison2(Long id2) {

    }
}
