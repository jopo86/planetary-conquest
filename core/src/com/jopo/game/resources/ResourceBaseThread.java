package com.jopo.game.resources;

import java.util.ArrayList;

public class ResourceBaseThread extends Thread {

    private ArrayList<ResourceBase> resourceBases;

    public ResourceBaseThread(ArrayList<ResourceBase> resourceBases) {
        this.resourceBases = resourceBases;
    }

    @Override
    public void run() {

    }
}
