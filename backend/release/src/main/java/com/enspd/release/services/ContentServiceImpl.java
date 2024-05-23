package com.enspd.release.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enspd.release.DTO.AddContentToPlaylistDTO;
import com.enspd.release.DTO.CommentaireCreationRequestDTO;
import com.enspd.release.DTO.CommentaireResponseDTO;
import com.enspd.release.DTO.ContentCreationRequestDTO;
import com.enspd.release.DTO.ContentResponseDTO;
import com.enspd.release.DTO.ContentResponseForPlaylistDTO;
import com.enspd.release.DTO.ContentUpdateRequestDTO;
import com.enspd.release.DTO.PlaylistCreationRequestDTO;
import com.enspd.release.DTO.PlaylistResponseDTO;
import com.enspd.release.DTO.PlaylistUpdateRequestDTO;
import com.enspd.release.Repositories.AccountRepository;
import com.enspd.release.Repositories.CommentairesRepository;
import com.enspd.release.Repositories.ContenuPlaylistRepository;
import com.enspd.release.Repositories.ContenusRepository;
import com.enspd.release.Repositories.PlaylistRepository;
import com.enspd.release.models.AccountEntity;
import com.enspd.release.models.CommentairesEntity;
import com.enspd.release.models.ContenuPlaylistEntity;
import com.enspd.release.models.ContenusEntity;
import com.enspd.release.models.PlaylistEntity;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private ContenuPlaylistRepository contenuPlaylistRepository;

    @Autowired
    private ContenusRepository contenusRepository;

    @Autowired
    private CommentairesRepository commentairesRepository;

    private AccountRepository accountRepository;

    @Override
    public CommentaireResponseDTO CreateComment(CommentaireCreationRequestDTO commentaireCreationRequestDTO) {

        ContenusEntity contenusEntity = contenusRepository.findById(commentaireCreationRequestDTO.getId_contenu())
                .orElseThrow();

        AccountEntity accountEntity = accountRepository.findById(commentaireCreationRequestDTO.getId_user())
                .orElseThrow();

        Date date = new Date(System.currentTimeMillis());

        CommentairesEntity commentairesEntity = new CommentairesEntity();

        commentairesEntity.setAccountEntity(accountEntity);
        commentairesEntity.setContenusEntity(contenusEntity);
        commentairesEntity.setDate(date);
        commentairesEntity.setTexte(commentaireCreationRequestDTO.getTexte());

        CommentairesEntity savedComment = commentairesRepository.save(commentairesEntity);

        CommentaireResponseDTO commentaireResponseDTO = new CommentaireResponseDTO();
        commentaireResponseDTO.setDate_commentaire(savedComment.getDate());
        commentaireResponseDTO.setTexte(savedComment.getTexte());
        commentaireResponseDTO.setUsername(accountEntity.getUsername());

        return commentaireResponseDTO;

    }

    @Override
    public void DeleteCommentaire(Integer id) {
       
        CommentairesEntity commentairesEntity= commentairesRepository.findById(id).orElseThrow();
        commentairesRepository.delete(commentairesEntity);
    }

    @Override
    public void CreatePlaylist(PlaylistCreationRequestDTO playlistCreationRequestDTO) {
        PlaylistEntity playlistEntity = new PlaylistEntity();

        playlistEntity.setNom(playlistCreationRequestDTO.getNom());
        playlistEntity.setLikes(0);
        playlistEntity.setDescription(playlistCreationRequestDTO.getDescription());
        playlistEntity.setPath_cover(playlistCreationRequestDTO.getCover_path());
        Date date = new Date(System.currentTimeMillis());
        playlistEntity.setDate_creation(date);

        playlistRepository.save(playlistEntity);

    }

    @Override
    public void DeletePlaylist(Integer id) {
        PlaylistEntity playlistEntity = playlistRepository.findById(id).orElseThrow();

        List<ContenuPlaylistEntity> lPlaylistEntities = contenuPlaylistRepository
                .ListOfContents(playlistEntity.getId());

        contenuPlaylistRepository.deleteAll(lPlaylistEntities);

        playlistRepository.delete(playlistEntity);

    }

    @Override
    public PlaylistResponseDTO updatePlaylistParam(PlaylistUpdateRequestDTO playlistUpdateRequestDTO) {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlistUpdateRequestDTO.getId()).orElseThrow();
        if (playlistUpdateRequestDTO.getCover_path() != null) {

            playlistEntity.setPath_cover(playlistUpdateRequestDTO.getCover_path());
        }
        if (playlistUpdateRequestDTO.getDescription() != null) {

            playlistEntity.setDescription(playlistUpdateRequestDTO.getDescription());
        }
        if (playlistUpdateRequestDTO.getNom() != null) {

            playlistEntity.setNom(playlistUpdateRequestDTO.getNom());

        }

        PlaylistEntity updatedPlaylist = playlistRepository.save(playlistEntity);

        PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();
        playlistResponseDTO.setCover_path(updatedPlaylist.getPath_cover());
        playlistResponseDTO.setDate_creation(updatedPlaylist.getDate_creation());
        playlistResponseDTO.setDescrption(updatedPlaylist.getDescription());
        playlistResponseDTO.setId(updatedPlaylist.getId());

        return playlistResponseDTO;
    }

    @Override
    public List<PlaylistResponseDTO> TrendingHot() {
        List<PlaylistEntity> playlistEntities = playlistRepository.findHotPlaylist();
        List<PlaylistResponseDTO> playlistResponseDTOs = new ArrayList<>();

        for (PlaylistEntity playlistEntity : playlistEntities) {

            PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();

            playlistResponseDTO.setCover_path(playlistEntity.getPath_cover());
            playlistResponseDTO.setDate_creation(playlistEntity.getDate_creation());
            playlistResponseDTO.setDescrption(playlistEntity.getDescription());
            playlistResponseDTO.setId(playlistEntity.getId());
            playlistResponseDTO.setLikes(playlistEntity.getLikes());

            playlistResponseDTOs.add(playlistResponseDTO);
        }

        return playlistResponseDTOs;

    }

    @Override
    public List<PlaylistResponseDTO> TrendingNew() {
        List<PlaylistEntity> playlistEntities = playlistRepository.findNewPlaylist();
        List<PlaylistResponseDTO> playlistResponseDTOs = new ArrayList<>();

        for (PlaylistEntity playlistEntity : playlistEntities) {

            PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();

            playlistResponseDTO.setCover_path(playlistEntity.getPath_cover());
            playlistResponseDTO.setDate_creation(playlistEntity.getDate_creation());
            playlistResponseDTO.setDescrption(playlistEntity.getDescription());
            playlistResponseDTO.setId(playlistEntity.getId());
            playlistResponseDTO.setLikes(playlistEntity.getLikes());

            playlistResponseDTOs.add(playlistResponseDTO);
        }

        return playlistResponseDTOs;
    }

    @Override
    public PlaylistResponseDTO GetplaylistByid(Integer Id) {
        PlaylistEntity playlistEntity = playlistRepository.findById(Id).orElseThrow();
        List<ContenuPlaylistEntity> contenuPlaylistEntities = contenuPlaylistRepository.ListOfContents(Id);
        List<ContentResponseForPlaylistDTO> contentResponseForPlaylistDTOs = new ArrayList<>();
        for (ContenuPlaylistEntity contenuPlaylistEntity : contenuPlaylistEntities) {

            ContentResponseForPlaylistDTO contentResponseForPlaylistDTO = new ContentResponseForPlaylistDTO();

            contentResponseForPlaylistDTO.setContent_type(contenuPlaylistEntity.getContenus().getType_contenu());
            contentResponseForPlaylistDTO.setDuree(contenuPlaylistEntity.getContenus().getDuree());
            contentResponseForPlaylistDTO.setNb_de_flux(contenuPlaylistEntity.getContenus().getNbre_de_flux());
            contentResponseForPlaylistDTO.setTitre(contenuPlaylistEntity.getContenus().getTitre());
            contentResponseForPlaylistDTO.setPath(contenuPlaylistEntity.getContenus().getPath());
            contentResponseForPlaylistDTOs.add(contentResponseForPlaylistDTO);
        }

        PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();

        playlistResponseDTO.setCover_path(playlistEntity.getPath_cover());
        playlistResponseDTO.setDate_creation(playlistEntity.getDate_creation());
        playlistResponseDTO.setDescrption(playlistEntity.getDescription());
        playlistResponseDTO.setId(Id);
        playlistResponseDTO.setLikes(playlistEntity.getLikes());
        playlistResponseDTO.setContenus(contentResponseForPlaylistDTOs);

        return playlistResponseDTO;

    }

    @Override
    public List<PlaylistResponseDTO> SearchPlaylist(String name) {
        List<PlaylistEntity> playlistEntities = playlistRepository.findLikeName(name);

        List<PlaylistResponseDTO> playlistResponseDTOs = new ArrayList<>();
        for (PlaylistEntity playlistEntity : playlistEntities) {

            PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();
            playlistResponseDTO.setCover_path(playlistEntity.getPath_cover());
            playlistResponseDTO.setDate_creation(playlistEntity.getDate_creation());
            playlistResponseDTO.setDescrption(playlistEntity.getDescription());
            playlistResponseDTO.setId(playlistEntity.getId());
            playlistResponseDTO.setLikes(playlistEntity.getLikes());
            playlistResponseDTOs.add(playlistResponseDTO);

        }
        return playlistResponseDTOs;
    }

    @Override
    public void AddLike(Integer id_playlist) {
        PlaylistEntity playlistEntity = playlistRepository.findById(id_playlist).orElse(null);

        if (playlistEntity != null) {
            playlistEntity.setLikes(playlistEntity.getLikes() + 1);
            playlistRepository.save(playlistEntity);
        }
    }

    @Override
    public ContentResponseDTO CreateContent(ContentCreationRequestDTO contentCreationRequestDTO) {
        ContenusEntity usedContenusEntity = contenusRepository.findUsedPath(contentCreationRequestDTO.getPath());
        if (usedContenusEntity == null) {
            ContenusEntity newContenusEntity = new ContenusEntity();
            newContenusEntity.setAuteur(contentCreationRequestDTO.getAuteur());
            newContenusEntity.setDescription(contentCreationRequestDTO.getDescription());
            newContenusEntity.setDuree(contentCreationRequestDTO.getDuree());
            newContenusEntity.setGenre(contentCreationRequestDTO.getGenre());
            newContenusEntity.setLangue(contentCreationRequestDTO.getLangue());
            newContenusEntity.setType_contenu(contentCreationRequestDTO.getType_contenu().toUpperCase());
            newContenusEntity.setNbre_de_flux(0);
            if (contentCreationRequestDTO.getCover_path() == null) {
                if (contentCreationRequestDTO.getType_contenu().toUpperCase() == "VIDEO") {
                    newContenusEntity.setCover_path("/static/images/video_cover");
                } else {
                    newContenusEntity.setCover_path("/static/images/audio_cover");
                }
            } else {
                newContenusEntity.setCover_path(contentCreationRequestDTO.getCover_path());
            }
            newContenusEntity.setPublication_date(new Date(System.currentTimeMillis()));
            newContenusEntity.setTitre(contentCreationRequestDTO.getTitre());
            newContenusEntity.setPath(contentCreationRequestDTO.getPath());

            ContenusEntity savedContenusEntity = contenusRepository.save(newContenusEntity);

            ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

            contentResponseDTO.setAuteur(savedContenusEntity.getAuteur());
            contentResponseDTO.setContent_type(savedContenusEntity.getType_contenu());
            contentResponseDTO.setCover_path(savedContenusEntity.getCover_path());
            contentResponseDTO.setDescription(savedContenusEntity.getDescription());
            contentResponseDTO.setDuree(savedContenusEntity.getDuree());
            contentResponseDTO.setNb_de_flux(savedContenusEntity.getNbre_de_flux());
            contentResponseDTO.setPath(savedContenusEntity.getPath());
            contentResponseDTO.setPublication_date(savedContenusEntity.getPublication_date());
            contentResponseDTO.setTitre(savedContenusEntity.getTitre());
            return contentResponseDTO;

        } else {
            throw new RuntimeException("le path rechercche est deja utiliser par un autre fichier");
        }
    }

    @Override
    public ContentResponseDTO UpdateContent(ContentUpdateRequestDTO contentUpdateRequestDTO) {
        ContenusEntity contenusEntity = contenusRepository.findById(contentUpdateRequestDTO.getId()).orElseThrow();

        if (contentUpdateRequestDTO.getAuteur() != null) {
            contenusEntity.setAuteur(contentUpdateRequestDTO.getAuteur());

        }
        if (contentUpdateRequestDTO.getDescription() != null) {

            contenusEntity.setDescription(contentUpdateRequestDTO.getDescription());
        }
        if (contentUpdateRequestDTO.getGenre() != null) {

            contenusEntity.setGenre(contentUpdateRequestDTO.getGenre());
        }
        if (contentUpdateRequestDTO.getLangue() != null) {
            contenusEntity.setLangue(contentUpdateRequestDTO.getLangue());

        }
        if (contentUpdateRequestDTO.getTitre() != null) {
            contenusEntity.setTitre(contentUpdateRequestDTO.getTitre());

        }

        contenusEntity= contenusRepository.save(contenusEntity);
        ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

        contentResponseDTO.setAuteur(contenusEntity.getAuteur());
        contentResponseDTO.setContent_type(contenusEntity.getType_contenu());
        contentResponseDTO.setCover_path(contenusEntity.getCover_path());
        contentResponseDTO.setDescription(contenusEntity.getDescription());
        contentResponseDTO.setDuree(contenusEntity.getDuree());
        contentResponseDTO.setNb_de_flux(contenusEntity.getNbre_de_flux());
        contentResponseDTO.setTitre(contenusEntity.getTitre());
        contentResponseDTO.setPath(contenusEntity.getPath());
        contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
        contentResponseDTO.setId(contenusEntity.getId());


        return contentResponseDTO;
    }

    @Override
    public List<ContentResponseDTO> HotContents(String content_type) {
        List<ContenusEntity> contenusEntities = contenusRepository.TrendingHot(content_type.toUpperCase());
        List<ContentResponseDTO> contentResponseDTOs = new ArrayList<>();
        for (ContenusEntity contenusEntity : contenusEntities) {
            ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

            contentResponseDTO.setAuteur(contenusEntity.getAuteur());
            contentResponseDTO.setContent_type(content_type);
            contentResponseDTO.setCover_path(contenusEntity.getCover_path());
            contentResponseDTO.setDescription(contenusEntity.getDescription());
            contentResponseDTO.setDuree(contenusEntity.getDuree());
            contentResponseDTO.setNb_de_flux(contenusEntity.getNbre_de_flux());
            contentResponseDTO.setTitre(contenusEntity.getTitre());
            contentResponseDTO.setPath(contenusEntity.getPath());
            contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
            contentResponseDTO.setId(contenusEntity.getId());

            contentResponseDTOs.add(contentResponseDTO);

        }
        return contentResponseDTOs;
    }

    @Override
    public List<ContentResponseDTO> NewContents(String content_type) {
        List<ContenusEntity> contenusEntities = contenusRepository.TrendingNew(content_type.toUpperCase());
        List<ContentResponseDTO> contentResponseDTOs = new ArrayList<>();
        for (ContenusEntity contenusEntity : contenusEntities) {
            ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

            contentResponseDTO.setAuteur(contenusEntity.getAuteur());
            contentResponseDTO.setContent_type(content_type);
            contentResponseDTO.setCover_path(contenusEntity.getCover_path());
            contentResponseDTO.setDescription(contenusEntity.getDescription());
            contentResponseDTO.setDuree(contenusEntity.getDuree());
            contentResponseDTO.setNb_de_flux(contenusEntity.getNbre_de_flux());
            contentResponseDTO.setTitre(contenusEntity.getTitre());
            contentResponseDTO.setPath(contenusEntity.getPath());
            contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
            contentResponseDTO.setId(contenusEntity.getId());

            contentResponseDTOs.add(contentResponseDTO);

        }
        return contentResponseDTOs;
    }

    @Override
    public List<ContentResponseDTO> SearchContent(String Content_type, String titre) {
        List<ContenusEntity> contenusEntities = contenusRepository.findNameLike(titre);
        List<ContentResponseDTO> contentResponseDTOs = new ArrayList<>();
        for (ContenusEntity contenusEntity : contenusEntities) {
            ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

            if (contenusEntity.getType_contenu().toUpperCase() == Content_type.toUpperCase()) {
                contentResponseDTO.setAuteur(contenusEntity.getAuteur());
                contentResponseDTO.setContent_type(Content_type);
                contentResponseDTO.setCover_path(contenusEntity.getCover_path());
                contentResponseDTO.setDescription(contenusEntity.getDescription());
                contentResponseDTO.setDuree(contenusEntity.getDuree());
                contentResponseDTO.setNb_de_flux(contenusEntity.getNbre_de_flux());
                contentResponseDTO.setTitre(contenusEntity.getTitre());
                contentResponseDTO.setPath(contenusEntity.getPath());
                contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
                contentResponseDTO.setId(contenusEntity.getId());

                contentResponseDTOs.add(contentResponseDTO);
            }

        }
        return contentResponseDTOs;
    }

    @Override
    public void DeleteContent(Integer id) {

        ContenusEntity contenusEntity = contenusRepository.findById(id).orElse(null);
        if (contenusEntity != null) {
            contenusRepository.delete(contenusEntity);
        } else {
            throw new RuntimeException("le fichier specfie nexiste pas");
        }
    }

    @Override
    public void AddtoPlaylists(List<AddContentToPlaylistDTO> addContentToPlaylistDTOs) {
        for (AddContentToPlaylistDTO addContentToPlaylistDTO : addContentToPlaylistDTOs) {

            /*
             * pour chaque ajout on se rassure que le fichier specifie existe il en est de
             * meme pour la playlist
             * ensuite on se rassure que le contenu a ajouter nest pas deja inclus dans la
             * playlist
             */
            ContenusEntity contenusEntity = contenusRepository.findById(addContentToPlaylistDTO.getId_contenu())
                    .orElseThrow();

            PlaylistEntity playlistEntity = playlistRepository.findById(addContentToPlaylistDTO.getId_playlist())
                    .orElseThrow();

            List<ContenuPlaylistEntity> cPlaylistEntities = contenuPlaylistRepository
                    .ListOfContents(playlistEntity.getId());

            int i = 0;
            for (ContenuPlaylistEntity contenuPlaylistEntity : cPlaylistEntities) {

                if (contenusEntity.getId() == contenuPlaylistEntity.getContenus().getId()) {
                    i++;
                }

            }
            if (i == 0) {
                ContenuPlaylistEntity contenuPlaylistEntity = new ContenuPlaylistEntity();
                contenuPlaylistEntity.setContenus(contenusEntity);
                contenuPlaylistEntity.setPlaylists(playlistEntity);
                contenuPlaylistEntity.setOrdre(addContentToPlaylistDTO.getPosition());
                contenuPlaylistRepository.save(contenuPlaylistEntity);
            }
        }
    }

    @Override
    public void UpdateFluxContenu(Integer id) {
        ContenusEntity contenusEntity = contenusRepository.findById(id).orElseThrow();
        contenusEntity.setNbre_de_flux(contenusEntity.getNbre_de_flux() + 1);
        contenusRepository.save(contenusEntity);
    }

    @Override
    public ContentResponseDTO getContentById(Integer id) {
        ContenusEntity contenusEntity = contenusRepository.findById(id).orElseThrow();

        List<CommentairesEntity> commentairesEntities = commentairesRepository.ListOfComments(id);
        List<CommentaireResponseDTO> commentaireResponseDTOs = new ArrayList<>();
        for (CommentairesEntity commentairesEntity : commentairesEntities) {

            CommentaireResponseDTO commentaireResponseDTO = new CommentaireResponseDTO();
            commentaireResponseDTO.setDate_commentaire(commentairesEntity.getDate());
            commentaireResponseDTO.setTexte(commentairesEntity.getTexte());
            commentaireResponseDTO.setUsername(commentairesEntity.getAccountEntity().getUsername());
            commentaireResponseDTOs.add(commentaireResponseDTO);

        }
        ContentResponseDTO contentResponseDTO = new ContentResponseDTO();
        contentResponseDTO.setAuteur(contenusEntity.getAuteur());
        contentResponseDTO.setContent_type(contenusEntity.getType_contenu());
        contentResponseDTO.setCover_path(contenusEntity.getCover_path());
        contentResponseDTO.setDescription(contenusEntity.getDescription());
        contentResponseDTO.setDuree(contenusEntity.getDuree());
        contentResponseDTO.setNb_de_flux(contenusEntity.getId());
        contentResponseDTO.setPath(contenusEntity.getPath());
        contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
        contentResponseDTO.setCommentaires(commentaireResponseDTOs);
        contentResponseDTO.setId(contenusEntity.getId());

        return contentResponseDTO;

    }

    @Override
    public List<ContentResponseDTO> getAllContentByType(String content_type) {
        List<ContenusEntity> contenusEntities = contenusRepository.findAll();
        List<ContentResponseDTO> contentResponseDTOs = new ArrayList<>();
        for (ContenusEntity contenusEntity : contenusEntities) {

            ContentResponseDTO contentResponseDTO = new ContentResponseDTO();

            contentResponseDTO.setAuteur(contenusEntity.getAuteur());
            contentResponseDTO.setContent_type(contenusEntity.getType_contenu());
            contentResponseDTO.setCover_path(contenusEntity.getCover_path());
            contentResponseDTO.setDescription(contenusEntity.getDescription());
            contentResponseDTO.setDuree(contenusEntity.getDuree());
            contentResponseDTO.setNb_de_flux(contenusEntity.getId());
            contentResponseDTO.setPath(contenusEntity.getPath());
            contentResponseDTO.setPublication_date(contenusEntity.getPublication_date());
            contentResponseDTO.setId(contenusEntity.getId());

            contentResponseDTOs.add(contentResponseDTO);

        }

        return contentResponseDTOs;
    }

}
