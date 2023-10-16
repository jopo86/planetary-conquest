package com.jopo.game.player;

import com.jopo.game.space.Planet;

import java.util.ArrayList;

public class PlayerGameState {

    private final Player player;
    private ArrayList<Planet> planets;

    private int wood;
    private int stone;
    private int metal;

    public PlayerGameState(Player player) {
        this.player = player;
        wood = 0;
        stone = 0;
        metal = 0;
    }

    public PlayerGameState(Player player, int wood, int stone, int metal) {
        this.player = player;
        planets = new ArrayList<>();
        this.wood = wood;
        this.stone = stone;
        this.metal = metal;
    }

    public PlayerGameState(Player player, ArrayList<Planet> planets, int wood, int stone, int metal) {
        this.player = player;
        this.planets = planets;
        this.wood = wood;
        this.stone = stone;
        this.metal = metal;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Planet> getPlanets() {
        return planets;
    }

    public Planet getPlanet(int i) {
        return planets.get(i);
    }

    public int getWood() {
        return wood;
    }

    public int getStone() {
        return stone;
    }

    public int getMetal() {
        return metal;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public void setStone(int stone) {
        this.stone = stone;
    }

    public void setMetal(int metal) {
        this.metal = metal;
    }

    public void setPlanets(ArrayList<Planet> planets) {
        this.planets = planets;
    }

    public void addWood(int amount) {
        wood += amount;
    }

    public void addStone(int amount) {
        stone += amount;
    }

    public void addMetal(int amount) {
        metal += amount;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}
