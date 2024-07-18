package tech.desafio_backend_bossabox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.desafio_backend_bossabox.entities.Tool;
import tech.desafio_backend_bossabox.services.ToolService;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {
    @Autowired
    private ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }
    @PostMapping
    public ResponseEntity<Tool> salvar(@RequestBody Tool tool){
        Tool item= toolService.salvar(tool);
        return ResponseEntity.ok(tool);
    }
    @GetMapping
    public ResponseEntity<List<Tool>> buscarTools(){
        List<Tool> itens=toolService.buscarTools();
        return ResponseEntity.ok(itens);
    }
    @GetMapping("/tag")
    public List<Tool> getToolsByTag(@RequestParam String tag) {
        return toolService.getToolsByTag(tag);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removerTool(@PathVariable("id")Long toolId){
        toolService.removerToolId(toolId);
        return ResponseEntity.ok("ok");
    }


}
