package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.MvtStk;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {
}
