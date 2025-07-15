package spring_api.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
            return ResponseEntity.status(400).body("O nome da playlist é obrigatório");
        }

        playlistService.createPlaylist(playlist);
        URI url = URI.create("/lists" + playlist.getName());
        return ResponseEntity.ok(url);
    }

    @GetMapping
    public List<Playlist> listAllPlaylists() {
        return playlistService.listPlaylists();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> showListDescription(@PathVariable String name) {
        try {
            return ResponseEntity.ok(playlistService.findByName(name));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Playlist não encontrada");
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<?> deletePlaylist(@PathVariable String name) {
        try {
            playlistService.removeByName(name);
            return ResponseEntity.status(204).body("Playlist excluída com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("Playlist não encontrada");
        }
    }


}
