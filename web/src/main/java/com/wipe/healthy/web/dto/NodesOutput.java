package com.wipe.healthy.web.dto;

import java.util.List;

/**
 * 节点输出视图
 * User:Created by wei.li
 * Date: on 2015/12/22.
 * Time:23:42
 */
public class NodesOutput {

    private Integer id;

    private String text;

    private List<NodesOutput> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<NodesOutput> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesOutput> nodes) {
        this.nodes = nodes;
    }
}
