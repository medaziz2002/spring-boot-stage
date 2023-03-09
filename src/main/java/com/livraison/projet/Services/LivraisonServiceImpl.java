package com.livraison.projet.Services;


import com.livraison.projet.Entities.Livraison;
import com.livraison.projet.Repository.CommandeRepository;
import com.livraison.projet.Repository.LivraisonRepository;
import com.livraison.projet.beans.CommandeDto;
import com.livraison.projet.beans.LivraisonDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonServiceImpl implements LivraisonService {


    @Autowired
    LivraisonRepository livraisonRepository;

  @Autowired
    CommandeRepository commandeRepository;

  @Autowired
  CommandeService commandeService;



@Transactional
    @Override
    public Livraison confirmer(Long id) {

        Optional<Livraison> fa=livraisonRepository.findById(id);

        if(fa.isPresent())
        {
            Livraison c=livraisonRepository.getReferenceById(id);
                    c.setLivred(true);
        return c;
        }else
            return null;
    }

    @Override
    public List<CommandeDto> listeCommandeNonLivred() {
        return null;
    }

    @Override
    public CommandeDto commandeToCommandeDto(Livraison livraison, CommandeDto commandeDto) {
        if (livraison != null) {
            commandeDto.setId(livraison.getId());
            commandeDto.setCommande(livraison.getCommande() == null ? null : commandeService.commandeToCommandeDto(livraison.getCommande(), new LivraisonDto()).getCommande());
            commandeDto.setLivred(livraison.isLivred());

            return commandeDto;
        } else
            return null;
    }


    @Override
    public LivraisonDto livraisonToLivraisonDto(Livraison livraison, LivraisonDto livraisonDto) {

        if(livraison!=null){
            livraisonDto.setId(livraison.getId());

            livraisonDto.setCommande(livraison.getCommande()==null?null: commandeService.commandeToCommandeDto(livraison.getCommande(),new LivraisonDto()).getCommande());
            return livraisonDto;}
        else
            return null;

    }


  /*  @Override
    public List<CommandeDto> listeCommandeNonLivred(Long id ) {
        return livraisonRepository.findByLivredIsFlase(id).stream().map(commande -> commandeToCommandeDto(commande, new CommandeDto())).collect(Collectors.toList());
    }*/





}
