package spring_api.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_api.playlist.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
