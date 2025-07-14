package spring_api.playlist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_api.playlist.model.Music;
import spring_api.playlist.service.MusicService;

@RestController
public class MusicController {

    @Autowired
    private MusicService musicService;

    @PostMapping
    public ResponseEntity<?> addMusic(@RequestBody Music music) {

        if (music.getTitle() == null) {
            return ResponseEntity.badRequest().body("Título necessário");
        }

        return ResponseEntity.ok(musicService.saveMusic(music));
    }
}
