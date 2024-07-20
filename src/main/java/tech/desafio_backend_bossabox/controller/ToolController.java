package tech.desafio_backend_bossabox.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.desafio_backend_bossabox.entities.Tool;
import tech.desafio_backend_bossabox.services.ToolService;

import java.util.List;

@RestController
@RequestMapping("/tools")
@Tag(name = "Tools", description = "Gerencimento de ferramentas")
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
    public ResponseEntity<List<Tool>> buscarTools(@RequestParam(required = false) String tag){
        if (tag!=null) {
            List<Tool> toolsTag=toolService.getToolsByTag(tag);
            return ResponseEntity.ok(toolsTag);
        }else{
            List<Tool> itens=toolService.buscarTools();
            return ResponseEntity.ok(itens);
        }

    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> removerTool(@PathVariable("id")Long toolId){
        toolService.removerToolId(toolId);
        return ResponseEntity.ok("ok");
    }


}
