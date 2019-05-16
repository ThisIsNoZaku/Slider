package com.thisisnozaku.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResourceDefinition {
    private long id;
    private String displayName;

    @JsonCreator
    public ResourceDefinition(@JsonProperty("id") long id, @JsonProperty("label")String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }
}
