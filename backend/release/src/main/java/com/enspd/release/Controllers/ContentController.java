package com.enspd.release.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.enspd.release.DTO.AddContentToPlaylistDTO;
import com.enspd.release.DTO.CommentaireCreationRequestDTO;
import com.enspd.release.DTO.CommentaireResponseDTO;
import com.enspd.release.DTO.ContentCreationRequestDTO;
import com.enspd.release.DTO.ContentResponseDTO;
import com.enspd.release.DTO.PlaylistCreationRequestDTO;
import com.enspd.release.DTO.PlaylistResponseDTO;
import com.enspd.release.services.ContentService;

@RestController
@RequestMapping("api/v1")
public class ContentController {

    @Autowired
    public ContentService contentService;

    /*
     * gets endpoint for the api
     * 
     */
  @GetMapping("playlist/hot")
    public List<PlaylistResponseDTO> PlaylistHot() {
        return contentService.TrendingHot();
    }

    @GetMapping("playlist/new")
    public List<PlaylistResponseDTO> PlaylistNew() {
        return contentService.TrendingNew();
    }

    @GetMapping("playlist/id/{id}")
    public PlaylistResponseDTO PlaylistById(@PathVariable("id") Integer id) {
        return contentService.GetplaylistByid(id);
    }

    @GetMapping("playlist/search/{search}")
    public List<PlaylistResponseDTO> SearchingList(@PathVariable("search") String search) {
        return contentService.SearchPlaylist(search);
    }

    @GetMapping("contents/hot/{type}")
    public List<ContentResponseDTO> HotContents(@PathVariable("type") String content_type) {
        return contentService.HotContents(content_type);

    }

    @GetMapping("contents/new/{type}")
    public List<ContentResponseDTO> NewContents(@PathVariable("type") String content_type) {
        return contentService.NewContents(content_type);
    }

    @GetMapping("contents/search/{search}/{type}")
    public List<ContentResponseDTO> SearchContents(@PathVariable("search") String name,@PathVariable("type") String content_type){
        return contentService.SearchContent(content_type, name);
    }

    @GetMapping("contents/all/{type}")
    public List<ContentResponseDTO> getAllContentByType(@PathVariable("type") String content_type){
       return  contentService.getAllContentByType(content_type);
    }

    @GetMapping("contents/id/{id}")
    public ContentResponseDTO getContentById(@PathVariable("id") Integer id){
        return contentService.getContentById(id);
    }

    /*
     * POSTs endpoint for the API
     */
     @ResponseStatus(HttpStatus.CREATED)
     @PostMapping("/playlist/create")
    public void CreatePlaylist(@RequestBody PlaylistCreationRequestDTO playlistCreationRequestDTO){

        contentService.CreatePlaylist(playlistCreationRequestDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/contents/create")
    public ContentResponseDTO CreateContent(@RequestBody ContentCreationRequestDTO contentCreationRequestDTO){
        return contentService.CreateContent(contentCreationRequestDTO);
    }

    @PostMapping("/comments/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CommentaireResponseDTO CreateComment(@RequestBody CommentaireCreationRequestDTO commentaireCreationRequestDTO){
        return contentService.CreateComment(commentaireCreationRequestDTO);
    }

    @PostMapping("/comments/playslits_add")
    @ResponseStatus(HttpStatus.OK)
    public void  AddtoPlaylists(List<AddContentToPlaylistDTO> addContentToPlaylistDTOs){
        contentService.AddtoPlaylists(addContentToPlaylistDTOs);
    }


}
