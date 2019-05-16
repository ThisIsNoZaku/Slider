package com.thisisnozaku.resources;

import java.beans.PropertyChangeSupport;
import java.util.Observable;

/**
 * The stateful properties of a resource.
 */
public class ResourceState extends Observable {
    private ResourceDefinition resource;
    private double quantity;
    private double maximum;
    private double minimum;

    ResourceState(ResourceDefinition resource, double maximum, double minimum, double initialQuantity) {
        this.resource = resource;
        this.quantity = initialQuantity;
        this.maximum = maximum;
        this.minimum = minimum;
    }

    /**
     *
     * @return
     */
    public ResourceDefinition getResource() {
        return resource;
    };

    /**
     * Get the current quantity.
     * @return the current amount
     */
    public double getAmount() {
        return quantity;
    }

    /**
     * Set the new amount. If the new amount would be greater than the minimum amount, it is instead set to the minimum.
     * If it would be greater than the maximum, it is instead set to the maxiumum.
     * @return
     */
    public void  setAmount(double newAmount) {
        this.quantity = newAmount;
    }

    /**
     * Get the minimum amount of resource.
     * @return
     */
    public double getMinimum() {
        return minimum;
    }

    /**
     * Set the minimum amount of the resource.
     * @param newMinimum
     */
    public void setMinimum(double newMinimum){
        this.minimum = newMinimum;
    }

    /**
     * Get the maximum amount of resource.
     */
    public double getMaximum(){
        return maximum;
    }

    /**
     * Set the maximum amount of the resource.
     * @param newMaximum
     */
    public void setMaximum(double newMaximum){
        this.maximum = newMaximum;
    }
}