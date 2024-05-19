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

public class ContentServiceImpl implements ContentService {

    @Override
    public CommentaireResponseDTO CreateComment(CommentaireCreationRequestDTO commentaireCreationRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreateComment'");
    }

    @Override
    public void DeleteCommentaire() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeleteCommentaire'");
    }

    @Override
    public void CreatePlaylist(PlaylistCreationRequestDTO playlistCreationRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreatePlaylist'");
    }

    @Override
    public void DeletePlaylist(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeletePlaylist'");
    }

    @Override
    public PlaylistResponseDTO updatePlaylistParam(PlaylistUpdateRequestDTO playlistUpdateRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlaylistParam'");
    }

    @Override
    public List<PlaylistResponseDTO> TrendingHot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TrendingHot'");
    }

    @Override
    public List<PlaylistResponseDTO> TrendingNew() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'TrendingNew'");
    }

    @Override
    public PlaylistResponseDTO GetplaylistByid(Integer Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'GetplaylistByid'");
    }

    @Override
    public List<PlaylistResponseDTO> SearchPlaylist(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SearchPlaylist'");
    }

    @Override
    public void AddLike(Integer id_playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddLike'");
    }

    @Override
    public ContentResponseDTO CreateContent(ContentCreationRequestDTO contentCreationRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CreateContent'");
    }

    @Override
    public ContentResponseDTO UpdateContent(ContentUpdateRequestDTO contentUpdateRequestDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateContent'");
    }

    @Override
    public List<ContentResponseDTO> HotContents(String content_type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'HotContents'");
    }

    @Override
    public List<ContentResponseDTO> NewContents(String content_type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'NewContents'");
    }

    @Override
    public List<ContentResponseDTO> SearchContent(String Content_type, String titre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SearchContent'");
    }

    @Override
    public void DeleteContent(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeleteContent'");
    }

    @Override
    public void AddtoPlaylists(List<AddContentToPlaylistDTO> addContentToPlaylistDTOs) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddtoPlaylists'");
    }

    @Override
    public void UpdateFluxContenu(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateFluxContenu'");
    }
    
}
