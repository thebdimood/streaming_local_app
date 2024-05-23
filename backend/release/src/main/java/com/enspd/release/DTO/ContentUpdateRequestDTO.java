package com.enspd.release.DTO;

import lombok.Data;

@Data
public class ContentUpdateRequestDTO {

private Integer id;

private String titre;

private String description;

private String auteur;

private String langue;

private String genre;
}
