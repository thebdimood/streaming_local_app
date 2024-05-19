package com.enspd.release.DTO;

import lombok.Data;

@Data
public class AddContentToPlaylistDTO {
    private Integer id_playlist;

    private Integer id_contenu;

    private Integer position;
}
