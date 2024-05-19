package com.enspd.release.DTO;

import lombok.Data;

@Data
public class CommentaireCreationRequestDTO {

    private Integer id_user;

    private Integer id_contenu;

    private String texte;
    
}
