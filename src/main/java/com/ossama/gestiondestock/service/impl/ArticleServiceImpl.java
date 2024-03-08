package com.ossama.gestiondestock.service.impl;

import com.ossama.gestiondestock.dto.ArticleDto;
import com.ossama.gestiondestock.exception.EntityNotFoundException;
import com.ossama.gestiondestock.exception.ErrorCodes;
import com.ossama.gestiondestock.exception.InvalidEntityException;
import com.ossama.gestiondestock.model.Article;
import com.ossama.gestiondestock.repository.ArticleRepository;
import com.ossama.gestiondestock.service.ArticleService;
import com.ossama.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if(id==null){
            log.error("Article ID is null ");
            return null;
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto dto =ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException(
                "Aucun article avec l'ID = "+id+" n'ete trouver dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );

    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Article Code is null ");
            return null;
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        ArticleDto dto =ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(()-> new EntityNotFoundException(
                "Aucun article avec le code  = "+codeArticle+" n'ete trouver dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {

        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Article ID is null ");
            return ;
        }
        articleRepository.deleteById(id);

    }
}
