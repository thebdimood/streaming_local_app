package com.enspd.release.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enspd.release.models.PlaylistEntity;

public interface PlaylistRepository extends JpaRepository<PlaylistEntity,Integer> {
    
}
