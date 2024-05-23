package com.enspd.release.DTO;

import lombok.Data;

@Data
public class ContentCreationRequestDTO {
    
    private String titre;

    private String description;

    private String path;

    private String genre;

    private String langue;

    private String contenu;

    private String auteur;

    private String duree;
    
    private String type_contenu;

    private String cover_path;
}
