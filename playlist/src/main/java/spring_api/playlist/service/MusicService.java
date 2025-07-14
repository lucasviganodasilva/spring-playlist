package spring_api.playlist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_api.playlist.model.Music;
import spring_api.playlist.repository.MusicRepository;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }
}
