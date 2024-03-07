package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Fournisseur;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Integer, Fournisseur> {
}
