package com.thisisnozaku.resources;

public class ResourceStateBuilder {
    private ResourceDefinition resource;
    private double maximum;
    private double minimum;
    private double initialQuantity;

    public ResourceStateBuilder setResource(ResourceDefinition resource) {
        this.resource = resource;
        return this;
    }

    public ResourceStateBuilder setMaximum(double maximum) {
        this.maximum = maximum;
        return this;
    }

    public ResourceStateBuilder setMinimum(double minimum) {
        this.minimum = minimum;
        return this;
    }

    public ResourceStateBuilder setInitialQuantity(double initialQuantity) {
        this.initialQuantity = initialQuantity;
        return this;
    }

    public ResourceState createResourceState() {
        return new ResourceState(resource, maximum, minimum, initialQuantity);
    }
}