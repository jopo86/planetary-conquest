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
                placements.add(new MathUtils.Point(-2000, 1500));
                placements.add(new MathUtils.Point(1950, -1450));
            }
            case 3 -> {
                placements.add(new MathUtils.Point(-2300, -1800));
                placements.add(new MathUtils.Point(1800, -1500));
                placements.add(new MathUtils.Point(0, 2000));
            }
            case 4 -> {
                placements.add(new MathUtils.Point(-1600, 1800));
                placements.add(new MathUtils.Point(2000, 1300));
                placements.add(new MathUtils.Point(1400, -1700));
                placements.add(new MathUtils.Point(-2500, -1800));
            }
            case 5 -> {
                placements.add(new MathUtils.Point(-1800, 1400));
                placements.add(new MathUtils.Point(1300, 1300));
                placements.add(new MathUtils.Point(2800, -1200));
                placements.add(new MathUtils.Point(400, -2500));
                placements.add(new MathUtils.Point(-2400, -1700));
            }
            case 6 -> {
                placements.add(new MathUtils.Point(-1500, 1600));
                placements.add(new MathUtils.Point(1600, 1500));
                placements.add(new MathUtils.Point(3800, -400));
                placements.add(new MathUtils.Point(1100, -2300));
                placements.add(new MathUtils.Point(-1800, -1800));
                placements.add(new MathUtils.Point(-4000, 100));
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
