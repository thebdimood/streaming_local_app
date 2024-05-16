package com.enspd.release.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "contenus_playlist_table")
public class ContenuPlaylistEntity {

    @Column(name="id_contenu_playlist")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "odre_du_cntenu_dans_playlist")
    private Integer ordre;
    
    @ManyToOne
    @JoinColumn(name="id_contenu")
    ContenusEntity contenus;

    @ManyToOne
    @JoinColumn(name="id_playlist")
    PlaylistEntity playlists;
}
