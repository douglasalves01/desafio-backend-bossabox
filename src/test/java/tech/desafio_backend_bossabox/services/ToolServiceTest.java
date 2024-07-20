package tech.desafio_backend_bossabox.services;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import tech.desafio_backend_bossabox.controller.ToolController;
import tech.desafio_backend_bossabox.entities.Tool;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ToolServiceTest {
    @InjectMocks
    private ToolController toolController;
    @Mock
    private ToolService toolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        Tool tool = new Tool();
        when(toolService.salvar(any(Tool.class))).thenReturn(tool);

        ResponseEntity<Tool> response = toolController.salvar(tool);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tool, response.getBody());
        verify(toolService, times(1)).salvar(tool);
    }
    @Test
    void testBuscarToolsSemTag() {
        List<Tool> tools = new ArrayList<>();
        Tool tool = new Tool();
        tool.setTitle("Tool Title");
        tools.add(tool);

        when(toolService.buscarTools()).thenReturn(tools);

        ResponseEntity<List<Tool>> response = toolController.buscarTools(null);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tools, response.getBody());
        verify(toolService, times(1)).buscarTools();
    }

    @Test
    void testBuscarToolsComTag() {
        List<Tool> tools = new ArrayList<>();
        Tool tool = new Tool();
        tool.setTitle("Tool Title");
        tools.add(tool);

        String tag = "tag";
        when(toolService.getToolsByTag(tag)).thenReturn(tools);

        ResponseEntity<List<Tool>> response = toolController.buscarTools(tag);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(tools, response.getBody());
        verify(toolService, times(1)).getToolsByTag(tag);
    }

    @Test
    void testRemoverTool() {
        Long toolId = 1L;

        doNothing().when(toolService).removerToolId(toolId);

        ResponseEntity<String> response = toolController.removerTool(toolId);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("ok", response.getBody());
        verify(toolService, times(1)).removerToolId(toolId);
    }
}