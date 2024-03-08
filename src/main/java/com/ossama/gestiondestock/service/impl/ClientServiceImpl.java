package com.ossama.gestiondestock.service.impl;

import com.ossama.gestiondestock.dto.ClientDto;
import com.ossama.gestiondestock.exception.EntityNotFoundException;
import com.ossama.gestiondestock.exception.ErrorCodes;
import com.ossama.gestiondestock.exception.InvalidEntityException;
import com.ossama.gestiondestock.model.CommandeClient;
import com.ossama.gestiondestock.repository.ClientRepository;
import com.ossama.gestiondestock.repository.CommandeClientRepository;
import com.ossama.gestiondestock.service.ClientService;
import com.ossama.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    private CommandeClientRepository commandeClientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository,CommandeClientRepository commandeClientRepository) {
        this.clientRepository=clientRepository;
        this.commandeClientRepository=commandeClientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Client is not valid {}",dto);
            throw new InvalidEntityException("Client is not valid", ErrorCodes.CLIENT_NOT_FOUND,errors);
        }
        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                ));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id==null){
            log.error("Client id is null");
            return null;
        }

        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException(
                        "Aucun client avec l'ID"+id+"n'ete trouver",ErrorCodes.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Client ID is null");
            return;
        }

        clientRepository.deleteById(id);
    }


}
