package com.ossama.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable

public class Adresse implements Serializable {
    @Column(name="adresse1")
    private String adresse1;
    @Column(name="adresse2")
    private String adresse2;
    @Column(name="ville")
    private String ville;
    @Column(name="codePostale")
    private String codePostale;
    @Column(name="pays")
    private String pays;
}
