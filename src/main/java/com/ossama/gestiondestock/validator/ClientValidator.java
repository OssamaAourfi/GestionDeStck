package com.ossama.gestiondestock.validator;

import com.ossama.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();
        if(clientDto==null){
            errors.add("veuillez remplir les champs du client");
            return errors;
        }
        if(!StringUtils.hasLength(clientDto.getNom())){
            errors.add("veuillez remplir le nom de client");
        }
        if(!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("veuillez remplir le prenom de client");
        }
        if(!StringUtils.hasLength(clientDto.getEmail())){
            errors.add("veuillez remplir l'email de client");
        }
        if(!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("veuillez remplir le telephone de client");
        }
        return errors;
    }
}
