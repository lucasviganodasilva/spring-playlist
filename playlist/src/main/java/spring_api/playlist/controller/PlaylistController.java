package spring_api.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring_api.playlist.model.Playlist;
import spring_api.playlist.service.PlaylistService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Playlist playlist) {

        if(playlist.getName() == null) {
            return ResponseEntity.badRequest().body("O nome da playlist é obrigatório");
        }

        playlistService.createPlaylist(playlist);
        URI url = URI.create("/lists" + playlist.getName());
        return ResponseEntity.ok(url);

    }


}
