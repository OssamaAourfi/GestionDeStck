package com.ossama.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import javax.swing.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="client")

public class Client extends AbstractEntity {
    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
    @Embedded
    private Adresse adresse;
    @Column(name="photo")
    private String photo;
    @Column(name="email")
    private String email;
    @Column(name="numTel")
    private String numTel;
    @Column(name = "identreprise")
    private Integer idEntreprise;
    @OneToMany(mappedBy="client")
    private List<CommandeClient> commandeClients;
}
