package com.ossama.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;


@Data

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @CreatedDate
    @Column(name="creationDate",nullable = false)
    @JsonIgnore
    private Instant creationDate;
    @LastModifiedDate
    @Column(name="lastModifiedDate")
    @JsonIgnore
    private Instant lastModifiedDate;
}
