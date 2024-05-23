package com.enspd.release.DTO;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PlaylistResponseDTO {

    private Integer id;

    private String descrption;

    private Date date_creation;

    private String cover_path;
    
    private Integer likes;

    List<ContentResponseForPlaylistDTO> contenus;
}
