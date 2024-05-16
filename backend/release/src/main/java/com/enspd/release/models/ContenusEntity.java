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

@Data
@Entity(name = "contenu_table")
public class ContenusEntity {
    
/*   - ID_contenu (clé primaire)
   - Titre
   - Type de contenu (musique, vidéo, podcast, etc.)
   - Description
   - URL (lien vers le contenu)
   - Date de publication
   - Durée (pour les vidéos et les chansons)
   - Genre
   - Langue
 */
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name= "titre_contenu", nullable = false)
    private String titre;

    @Column(name= "name_contenu", nullable = false)
    private String description;

    @Column(name= "path_contenu", nullable = false)
    private String path;

    @Column(name= "publication_date_contenu", nullable = false)
    private Date publication_date;

    @Column(name= "genre_contenu" )
    private String genre;

    @Column(name= "langue_contenu")
    private String langue;

    @Column(name= "type_contenu")
    private String type_contenu;

    @Column(name= "duree_contenu")
    private String duree;

    @Column(name="nbre_de_flux_contenu")
    private Integer nbre_de_flux;

    @OneToMany(mappedBy = "contenusEntity")
    Set<CommentairesEntity> commentaires;

    @OneToMany(mappedBy = "contenus")
    Set<ContenuPlaylistEntity> contenus_playlists;
}
