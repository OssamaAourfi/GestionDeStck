package com.ossama.gestiondestock.service.impl;

import com.ossama.gestiondestock.dto.ArticleDto;
import com.ossama.gestiondestock.exception.ErrorCodes;
import com.ossama.gestiondestock.exception.InvalidEntityException;
import com.ossama.gestiondestock.repository.ArticleRepository;
import com.ossama.gestiondestock.service.ArticleService;
import com.ossama.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j

public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository articleRepository;
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}",dto);
            throw new InvalidEntityException("l'artocle n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID,errors);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Integer id) {
        return null;
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return null;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
