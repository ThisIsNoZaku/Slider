package com.thisisnozaku.resources;

public class ResourceDefinition {
    private long id;
    private String displayName;

    public ResourceDefinition(long id, String displayName) {
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
