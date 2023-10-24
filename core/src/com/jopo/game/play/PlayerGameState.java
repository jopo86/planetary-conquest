package com.jopo.game.play;

import com.jopo.game.space.Planet;

import java.util.ArrayList;

public class PlayerGameState {

    private ArrayList<Planet> planets;
    private int wood;
    private int stone;
    private int metal;
    private int coins;
    private int armies;

    public PlayerGameState() {
        wood = 0;
        stone = 0;
        metal = 0;
        coins = 0;
        armies = 0;
    }

    public PlayerGameState(int wood, int stone, int metal, int coins, int armies) {
        planets = new ArrayList<>();
        this.wood = wood;
        this.stone = stone;
        this.metal = metal;
        this.coins = coins;
        this.armies = armies;
    }

    public PlayerGameState(ArrayList<Planet> planets, int wood, int stone, int metal, int coins, int armies) {
        this.planets = planets;
        this.wood = wood;
        this.stone = stone;
        this.metal = metal;
        this.coins = coins;
        this.armies = armies;
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

    public int getCoins() {
        return coins;
    }

    public int getArmies() {
        return armies;
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

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setArmies(int armies) {
        this.armies = armies;
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

    public void addCoins(int amount) {
        coins += amount;
    }

    public void addArmies(int amount) {
        armies += amount;
    }

    public void subtractWood(int amount) {
        wood -= amount;
    }

    public void subtractStone(int amount) {
        stone -= amount;
    }

    public void subtractMetal(int amount) {
        metal -= amount;
    }

    public void subtractCoins(int amount) {
        coins -= amount;
    }

    public void subtractArmies(int amount) {
        armies -= amount;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }
}
