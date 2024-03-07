package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Entreprise;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Integer, Entreprise> {
}
