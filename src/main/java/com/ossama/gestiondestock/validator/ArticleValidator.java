package com.ossama.gestiondestock.validator;

import com.ossama.gestiondestock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public static List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();
        if(articleDto==null){
            errors.add("veillez remplir les champs");
            return errors;
        }
        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("veuillez remplir le code d'article");
        }
        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("veuillez remplir la designation de l'article");
        }
        if(articleDto.getPrixUnitaireHt()==null){
            errors.add("veuillez remplir le prix unitaire de l'article");
        }
        if(articleDto.getTauxTva()==null){
            errors.add("veuillez remplir le taux tca de l'article");
        }
        if(articleDto.getPrixUnitaireTtc()==null){
            errors.add("veuillez remplir le prix unitaire TTC de l'article");
        }
        if(articleDto.getCategory()==null){
            errors.add("veuillez selectionez une categorie");
        }
        return errors;
    }
}
