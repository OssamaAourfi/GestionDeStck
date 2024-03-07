package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.CommandeClient;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository<Integer, CommandeClient> {
}
