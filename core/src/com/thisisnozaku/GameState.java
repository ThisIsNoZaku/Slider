package com.thisisnozaku;

import com.thisisnozaku.resources.ResourceDefinition;
import com.thisisnozaku.resources.ResourceState;

import java.util.HashMap;
import java.util.Map;

public class GameState {
    private Map<ResourceDefinition, ResourceState> resources = new HashMap<>();

    public void setResources(Map<ResourceDefinition, ResourceState> resources) {
        this.resources = resources;
    }

    public Map<ResourceDefinition, ResourceState> getResources() {
        return resources;
    }
}