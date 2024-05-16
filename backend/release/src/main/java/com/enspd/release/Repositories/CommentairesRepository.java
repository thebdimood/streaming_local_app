package com.enspd.release.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enspd.release.models.CommentairesEntity;

public interface CommentairesRepository  extends JpaRepository<CommentairesEntity,Integer>{

    @Query("SELECT c FROM contenu_table ct join ct.commentaires  c WHERE ct.Id =:id_contenu")
    List<CommentairesEntity> ListOfComments(Integer id_contenu);
    
}
