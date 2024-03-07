package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Utilisateur;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Integer, Utilisateur> {
}
