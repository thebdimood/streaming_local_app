package com.enspd.release.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enspd.release.models.ContenusEntity;

public interface ContenusRepository extends JpaRepository<ContenusEntity,Integer> {


    @Query("SELECT c FROM contenu_table c WHERE c.type_contenu  LIKE %:content_type% ORDER BY c.publication_date DESC LIMIT 10")
    List<ContenusEntity> TrendingNew( @Param("content_type")String content_type);


    @Query("SELECT c FROM contenu_table c  WHERE c.type_contenu  LIKE %:content_type% ORDER BY c.nbre_de_flux DESC LIMIT 10 ")
    List<ContenusEntity> TrendingHot( @Param("content_type") String content_type);


    @Query("SELECT c FROM contenu_table c  WHERE c.titre LIKE %:param%")
    List<ContenusEntity> findNameLike(@Param("param")String param);


    @Query("SELECT c FROM contenu_table c WHERE c.path LIKE %:path_request%")
    ContenusEntity findUsedPath(@Param("path_request") String path);



    
    
}
