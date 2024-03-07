package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, CategoryRepository> {
}
