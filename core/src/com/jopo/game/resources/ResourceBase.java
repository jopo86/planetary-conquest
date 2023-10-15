package com.jopo.game.resources;

public abstract class ResourceBase {

    protected int amount;
    protected float interval;
    protected Player occupant;

    public ResourceBase(int amount, int interval, Player occupant) {
        this.amount = amount;
        this.interval = interval;
        this.occupant = occupant;
    }

}
