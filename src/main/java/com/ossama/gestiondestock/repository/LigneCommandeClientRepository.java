package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.LigneCommandeClient;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<Integer, LigneCommandeClient> {
}
