package com.enspd.release.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/***Table Playlists** :
   - ID_playlist (clé primaire)
   - Nom de la playlist
   - ID_utilisateur (clé étrangère faisant référence à la table Utilisateurs)
   - Date de création
 */

 @Entity(name = "playlist_table")
 @Data
public class PlaylistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name="nom_playlist")
    private String nom;

    @Column(name="description_playlist")
    private String description;

    @Column(name="date_creation_playlist")
    private Date date_creation;

    @Column(name="nombres_de_like_playlist")
    private Integer likes;

    @Column(name="url_cover_playlist")
    private String path_cover;
    
    @OneToMany(mappedBy = "playlists")
    Set<ContenuPlaylistEntity> contenus_playlists;
}
