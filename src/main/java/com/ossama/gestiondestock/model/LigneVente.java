package com.ossama.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name="lignevente")

public class LigneVente extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;
}
