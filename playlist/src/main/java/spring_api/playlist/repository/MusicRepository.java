package spring_api.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_api.playlist.model.Music;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
