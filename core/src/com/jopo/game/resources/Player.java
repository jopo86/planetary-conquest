package com.jopo.game.resources;

public class Player {

    private String name;
    private int id;

    private int wood;
    private int stone;
    private int metal;

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
        wood = 0;
        stone = 0;
        metal = 0;
    }

}
