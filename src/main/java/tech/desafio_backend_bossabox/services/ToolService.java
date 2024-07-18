package tech.desafio_backend_bossabox.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.desafio_backend_bossabox.entities.Tool;
import tech.desafio_backend_bossabox.repository.ToolRepository;

import java.util.List;

@Service
public class ToolService {
    @Autowired
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

    public List<Tool> getToolsByTag(String tag) {
        return toolRepository.findByTagsContaining(tag);
    }
    public void removerToolId(Long id){
        toolRepository.deleteById(id);
    }


}
