package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.LigneCommandeFournisseur;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFournisseurRepository extends JpaRepository<Integer, LigneCommandeFournisseur> {
}
