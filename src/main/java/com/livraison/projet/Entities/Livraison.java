package com.livraison.projet.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livraison  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;







}
