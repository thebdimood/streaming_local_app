package com.enspd.release.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name= "commentaire_table")
@Data
public class CommentairesEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_commentaire")
    private Integer Id;


    @Column(name="texte_commentaires")
    private String texte;


    @Column(name = "date_commentaire",nullable = false)
    private Date  date;
    
    @ManyToOne
    @JoinColumn(name="id_utilisateur")
    AccountEntity accountEntity;

    
    @ManyToOne
    @JoinColumn(name="id_contenu")
    ContenusEntity contenusEntity;

    
}
