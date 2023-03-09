package com.livraison.projet.RestController;

import com.livraison.projet.Entities.Admin;
import com.livraison.projet.Entities.AffectationCommande;
import com.livraison.projet.Entities.Livreur;
import com.livraison.projet.Repository.AdminRepository;
import com.livraison.projet.Repository.LivreurRepository;
import com.livraison.projet.Services.AffectationLivraisonService;
import com.livraison.projet.Services.LivreurService;
import com.livraison.projet.beans.AffectationCommandeDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/livreur")
public class LivreurRestController {

    @Autowired
    LivreurService livreurService;



    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Livreur modifierLivreur(@PathVariable("id") Long id, @RequestBody Livreur livreur) {
        livreur.setMdp(this.bCryptPasswordEncoder.encode(livreur.getMdp()));
        Livreur savedLivreur = livreurRepository.save(livreur);
 return savedLivreur;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Livreur> getAllLivreur() {
        return livreurService.listeLivreur();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void supprimerLivreur(@PathVariable("id") Long id) {
        livreurService.supprimerById(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Livreur> getLivreurById(@PathVariable("id") Long id) {
        return livreurService.getLivreurById(id);
    }


    @Autowired
    private LivreurRepository livreurRepository;

    @Autowired
    private AffectationLivraisonService affectationLivraisonService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @PostMapping(path = "registerLivreur")
    public ResponseEntity<?> addlivreur(@RequestBody Livreur livreur) {
        if(livreurRepository.existsByEmail(livreur.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        livreur.setMdp(this.bCryptPasswordEncoder.encode(livreur.getMdp()));
        Livreur savedUser = livreurRepository.save(livreur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PostMapping(path = "login")
    public ResponseEntity<Map<String, Object>> loginStudent(@RequestBody Livreur livreur)
    {

        HashMap<String, Object> response = new HashMap<>();

        Livreur userFromDB = livreurRepository.findLivreurByEmail(livreur.getEmail());

        if (userFromDB == null) {
            response.put("message", "admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else
        {

            Boolean compare = this.bCryptPasswordEncoder.matches(livreur.getMdp(), userFromDB.getMdp());

            if (!compare)
            {
                response.put("message", "mot de passe not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            else
            {

                String token = Jwts.builder()
                        .claim("data",userFromDB)

                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();


                response.put("token", token);
                System.out.println("hhh "+token);
                return ResponseEntity.status(HttpStatus.OK).body(response);

            }
        }
    }

    @GetMapping("mon-list-a-livrer/{id}")
    public List<AffectationCommande> findAllListALivrerByIdLivreur(@PathVariable Long id)
    {
        System.out.println(id);
        return  affectationLivraisonService.findAllByLivreurId(id);

    }

}
