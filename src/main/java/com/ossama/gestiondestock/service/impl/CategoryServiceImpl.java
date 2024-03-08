package com.ossama.gestiondestock.service.impl;

import com.ossama.gestiondestock.dto.ArticleDto;
import com.ossama.gestiondestock.dto.CategoryDto;
import com.ossama.gestiondestock.exception.EntityNotFoundException;
import com.ossama.gestiondestock.exception.ErrorCodes;
import com.ossama.gestiondestock.exception.InvalidEntityException;

import com.ossama.gestiondestock.model.Article;
import com.ossama.gestiondestock.repository.ArticleRepository;
import com.ossama.gestiondestock.repository.CategoryRepository;
import com.ossama.gestiondestock.service.CategoryService;
import com.ossama.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    private ArticleRepository articleRepository;
@Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository,ArticleRepository articleRepository) {
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }
    @Override
    public CategoryDto save(CategoryDto dto){
        List<String> errors = CategoryValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Cetagory is not valid {}",dto);
            throw new InvalidEntityException("la category n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID,errors);
        }

        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
    if(id==null){
        log.error("Category Id is null");
        return null;
    }

        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucune category avec l'ID="+id+"n'ete trouver dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND
                ));
    }

    @Override
    public CategoryDto findByCode(String code) {
    if(!StringUtils.hasLength(code)){
        log.error("Category code is null");
        return null;
    }
        return categoryRepository.findCategoryByCode(code)
                .map(CategoryDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException(
                                "Aucune category avec le code"+code+"n'ete trouver dans la BDD",
                                ErrorCodes.CATEGORY_NOT_FOUND
                        ));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id==null){
            log.error("Category Id not found ");
            return ;
        }
        categoryRepository.deleteById(id);
    }
}
