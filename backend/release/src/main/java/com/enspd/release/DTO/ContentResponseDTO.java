package com.enspd.release.DTO;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ContentResponseDTO {
    
private String titre;

private String description;

private String path;

private String cover_path;

private String auteur;

private String content_type;

private Date publication_date;

private String duree;

private Integer nb_de_flux;

List<CommentaireResponseDTO> commentaires;

private Integer id_playlist;

}
