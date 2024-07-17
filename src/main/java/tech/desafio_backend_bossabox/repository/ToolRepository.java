package tech.desafio_backend_bossabox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.desafio_backend_bossabox.entities.Tool;
@Repository
public interface ToolRepository  extends JpaRepository<Tool,Long> {
}
