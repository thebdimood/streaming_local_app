package com.enspd.release.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enspd.release.models.ContenuPlaylistEntity;

public interface ContenuPlaylistRepository extends JpaRepository<ContenuPlaylistEntity,Integer> {
    
    @Query("SELECT c FROM playlist_table pt JOIN pt.contenus_playlists c WHERE pt.Id=:id  ")
    List<ContenuPlaylistEntity> ListOfContents(@Param("id")Integer id);
}
