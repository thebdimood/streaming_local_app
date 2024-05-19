package com.enspd.release.DTO;

import lombok.Data;

@Data
public class PlaylistUpdateRequestDTO {
    
    private Integer id;

    private String nom;

    private String description;

    private String cover_path;
}
