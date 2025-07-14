package spring_api.playlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_api.playlist.model.Playlist;
import spring_api.playlist.repository.PlaylistRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> createPlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
        return listPlaylists();
    }

    public List<Playlist> listPlaylists() {
        return playlistRepository.findAll();
    }

    public Playlist findByName(String name) {
        return playlistRepository.findAll().stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("List not found"));
    }

    public List<Playlist> removeByName(String name) {
        Playlist playlist = findByName(name);
        playlistRepository.delete(playlist);
        return listPlaylists();
    }

}
