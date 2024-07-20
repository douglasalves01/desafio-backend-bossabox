package tech.desafio_backend_bossabox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.desafio_backend_bossabox.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
