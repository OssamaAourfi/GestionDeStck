package com.ossama.gestiondestock.repository;

import com.ossama.gestiondestock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository< Article,Integer> {

}
