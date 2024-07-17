package tech.desafio_backend_bossabox.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_tools")
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tool_id")
    private Long toolId;
    private String title;
    private String link;
    private String description;
    @ElementCollection
    private List<String> tags;

    public Long getToolId() {
        return toolId;
    }

    public void setToolId(Long toolId) {
        this.toolId = toolId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
