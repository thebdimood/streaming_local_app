package com.enspd.release.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enspd.release.models.PlaylistEntity;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity,Integer> {


    @Query("SELECT  p FROM playlist_table p WHERE p.nom LIKE %:name% ")
    List<PlaylistEntity> findLikeName(@Param("name") String name);
    
}
