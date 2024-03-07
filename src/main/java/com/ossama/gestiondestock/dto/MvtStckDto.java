package com.ossama.gestiondestock.dto;

import com.ossama.gestiondestock.model.MvtStk;
import com.ossama.gestiondestock.model.TypeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data
@Builder

public class MvtStckDto {
    private Integer id;

    private Integer idEntreprise;

    private Instant dateMvt;


    private BigDecimal quantite;


    private ArticleDto article;


    private TypeMvtStk typeMvt;
    public static MvtStckDto fromEntity(MvtStk mvtStk) {
        if (mvtStk == null) {
            return null;
        }

        return MvtStckDto.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .typeMvt(mvtStk.getTypeMvt())
//                .sourceMvt(mvtStk.getSourceMvt())
               .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }

    public static MvtStk toEntity(MvtStckDto dto) {
        if (dto == null) {
            return null;
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(dto.getId());
        mvtStk.setDateMvt(dto.getDateMvt());
        mvtStk.setQuantite(dto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(dto.getArticle()));
        mvtStk.setTypeMvt(dto.getTypeMvt());
//        mvtStk.setSourceMvt(dto.getSourceMvt());
      mvtStk.setIdEntreprise(dto.getIdEntreprise());
        return mvtStk;
    }



}
