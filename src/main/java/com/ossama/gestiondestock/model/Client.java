package com.ossama.gestiondestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.util.List;

@Data
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
    @OneToMany(mappedBy="client")
    private List<CommandeClient> commandeClients;
}
