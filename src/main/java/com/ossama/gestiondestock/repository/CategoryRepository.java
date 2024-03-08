package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.dto.CategoryDto;
import com.ossama.gestiondestock.model.Category;
import com.ossama.gestiondestock.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer > {



    Optional<Category>findCategoryByCode(String code);
}
