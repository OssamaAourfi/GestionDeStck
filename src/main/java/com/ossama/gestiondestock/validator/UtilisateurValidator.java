package com.ossama.gestiondestock.validator;

import com.ossama.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();
        if(utilisateurDto==null){
            errors.add("Veuillez remplir les champs d'utilistaur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuillez remplir le nom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuillez remplir le prenom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuillez remplir l'email d'utilisateur");
        }if(!StringUtils.hasLength(utilisateurDto.getMoteDePasse())){
            errors.add("Veuillez remplir le mot de passe d'utilisateur");
        }
        if(utilisateurDto.getAdresse()==null){
            errors.add("Veuillez remplir l'adresse d'utilisateur");
        }else{
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("l'adresse 1 est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Le champs ville est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Le champs code postale est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Le champs pays est obligatoire");
            }

        }

        return errors;
    }
}
