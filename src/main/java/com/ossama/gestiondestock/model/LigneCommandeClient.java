package com.ossama.gestiondestock.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="lignecommandeclient")

public class LigneCommandeClient extends AbstractEntity {
    @ManyToOne()
    @JoinColumn(name = "idarticle")
    private Article article;
    @ManyToOne()
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;
}
