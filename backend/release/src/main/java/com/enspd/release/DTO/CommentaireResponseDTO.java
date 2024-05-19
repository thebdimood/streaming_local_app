package com.enspd.release.DTO;

import java.util.Date;

import lombok.Data;

@Data
public class CommentaireResponseDTO {
    
   private String username;

   private String texte;

   private Date date_commentaire;
}
