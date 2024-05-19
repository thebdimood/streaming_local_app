package com.enspd.release.DTO;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PlaylistResponseDTO {

    private String id;

    private String descrption;

    private Date date_creation;

    private String cover_path;

    List<ContentResponseForPlaylistDTO> contenus;
}
