package com.enspd.release.services;

import java.util.List;

import com.enspd.release.DTO.AddContentToPlaylistDTO;
import com.enspd.release.DTO.CommentaireCreationRequestDTO;
import com.enspd.release.DTO.CommentaireResponseDTO;
import com.enspd.release.DTO.ContentCreationRequestDTO;
import com.enspd.release.DTO.ContentResponseDTO;
import com.enspd.release.DTO.ContentUpdateRequestDTO;
import com.enspd.release.DTO.PlaylistCreationRequestDTO;
import com.enspd.release.DTO.PlaylistResponseDTO;
import com.enspd.release.DTO.PlaylistUpdateRequestDTO;

public interface ContentService {
  /*
   * service interface for content management in the platform
   * 
   */

  /*
   * first section: comment section
   */

  public CommentaireResponseDTO CreateComment(CommentaireCreationRequestDTO commentaireCreationRequestDTO);

  public void DeleteCommentaire();

  /*
   * 
   * playlist section: playlist content management
   */

  public void CreatePlaylist(PlaylistCreationRequestDTO playlistCreationRequestDTO);

  public void DeletePlaylist(Integer id);

  public PlaylistResponseDTO updatePlaylistParam(PlaylistUpdateRequestDTO playlistUpdateRequestDTO);

  public List<PlaylistResponseDTO> TrendingHot();

  public List<PlaylistResponseDTO> TrendingNew();

  public PlaylistResponseDTO GetplaylistByid(Integer Id);

  public List<PlaylistResponseDTO> SearchPlaylist(String name);

  public void AddLike(Integer id_playlist);

  /*
   * 
   * contents management fonctions
   */

  public ContentResponseDTO CreateContent(ContentCreationRequestDTO contentCreationRequestDTO);

  public ContentResponseDTO UpdateContent(ContentUpdateRequestDTO contentUpdateRequestDTO);

  public List<ContentResponseDTO> HotContents(String content_type);

  public List<ContentResponseDTO> NewContents(String content_type);

  public List<ContentResponseDTO> SearchContent(String Content_type, String titre);

  public void DeleteContent(Integer id);

  public void AddtoPlaylists(List<AddContentToPlaylistDTO> addContentToPlaylistDTOs);

  public void UpdateFluxContenu(Integer id);

}
