package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Client;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Integer > {
}
