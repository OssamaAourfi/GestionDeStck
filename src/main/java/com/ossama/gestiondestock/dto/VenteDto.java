package com.ossama.gestiondestock.dto;
import com.ossama.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
@Data
@Builder

public class VenteDto {
    private Integer id;

    private Integer idEntreprise;

    private String code;

    private Instant dateVente;

    private String commentaire;
    public static VenteDto fromEntity(Ventes vente) {
        if (vente == null) {
            return null;
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .commentaire(vente.getCommentaire())
              .idEntreprise(vente.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VenteDto dto) {
        if (dto == null) {
            return null;
        }
        Ventes ventes = new Ventes();
        ventes.setId(dto.getId());
        ventes.setCode(ventes.getCode());
        ventes.setCommentaire(dto.getCommentaire());
        ventes.setIdEntreprise(dto.getIdEntreprise());
        return ventes;
    }

}
