package tech.desafio_backend_bossabox.services;

import org.springframework.stereotype.Service;
import tech.desafio_backend_bossabox.entities.Tool;
import tech.desafio_backend_bossabox.repository.ToolRepository;

import java.util.List;

@Service
public class ToolService {
    private ToolRepository toolRepository;

    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }
    public Tool salvar(Tool tool){
        return toolRepository.save(tool);
    }
    public List<Tool> buscarTools(){
        return toolRepository.findAll();
    }

}