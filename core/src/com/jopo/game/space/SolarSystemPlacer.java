package com.jopo.game.space;

import com.jopo.utils.MathUtils;

import java.util.ArrayList;

public class SolarSystemPlacer {

    private short players;
    private ArrayList<MathUtils.Point> placements;

    public SolarSystemPlacer(short players) {
        this.players = players;
        placements = new ArrayList<>();
        switch(players) {
            case 2 -> {
                placements.add(new MathUtils.Point(-2200, 1700));
                placements.add(new MathUtils.Point(2150, -1650));
            }
            case 3 -> {
                placements.add(new MathUtils.Point(-2500, -2000));
                placements.add(new MathUtils.Point(2000, -1700));
                placements.add(new MathUtils.Point(0, 2200));
            }
            case 4 -> {
                placements.add(new MathUtils.Point(-1800, 2000));
                placements.add(new MathUtils.Point(2200, 1500));
                placements.add(new MathUtils.Point(1600, -1900));
                placements.add(new MathUtils.Point(-2700, -2000));
            }
            case 5 -> {
                placements.add(new MathUtils.Point(-2000, 1600));
                placements.add(new MathUtils.Point(1500, 1500));
                placements.add(new MathUtils.Point(3000, -1400));
                placements.add(new MathUtils.Point(600, -2700));
                placements.add(new MathUtils.Point(-2600, -1900));
            }
            case 6 -> {
                placements.add(new MathUtils.Point(-1700, 1800));
                placements.add(new MathUtils.Point(1800, 1700));
                placements.add(new MathUtils.Point(4000, -600));
                placements.add(new MathUtils.Point(1300, -2500));
                placements.add(new MathUtils.Point(-2000, -2000));
                placements.add(new MathUtils.Point(-4200, 300));
            }
        }
    }

    public ArrayList<MathUtils.Point> getPlacements() {
        return placements;
    }

    public MathUtils.Point getPlacement(int i) {
        return placements.get(i);
    }
}
