CREATE TABLE IF NOT EXISTS tool_tags (
    tool_tool_id INT NOT NULL,
    tags VARCHAR(255) NOT NULL,
    PRIMARY KEY (tool_tool_id, tags),
    FOREIGN KEY (tool_tool_id) REFERENCES tb_tools(tool_id) ON DELETE CASCADE
);