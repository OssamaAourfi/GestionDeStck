package com.ossama.gestiondestock.dto;

import com.ossama.gestiondestock.model.Client;
import com.ossama.gestiondestock.model.CommandeClient;
import com.ossama.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
@Data
@Builder

public class CommandeClientDto {
    private Integer id;
    private String code;

    private Instant dateCommande;
    private Integer idEntreprise;

    private Client client;

    private List<LigneCommandeClientDto> ligneCommandeClients;
    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
//                .etatCommande(commandeClient.getEtatCommande())
                .client(commandeClient.getClient())
               .idEntreprise(commandeClient.getIdEntreprise())
                .build();

    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(dto.getId());
        commandeClient.setCode(dto.getCode());
        commandeClient.setClient(ClientDto.toEntity(dto.getClient()));
        commandeClient.setDateCommande(dto.getDateCommande());
//        commandeClient.setEtatCommande(dto.getEtatCommande());
      commandeClient.setIdEntreprise(dto.getIdEntreprise());
        return commandeClient;
    }

//    public boolean isCommandeLivree() {
//        return EtatCommande.LIVREE.equals(this.etatCommande);
//    }
}
