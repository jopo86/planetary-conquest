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
                placements.add(new MathUtils.Point(-1300, 800));
                placements.add(new MathUtils.Point(1300, -800));
            }
            case 3 -> {
                placements.add(new MathUtils.Point(-1500, -1200));
                placements.add(new MathUtils.Point(1500, -1200));
                placements.add(new MathUtils.Point(0, 1200));
            }
            case 4 -> {
                placements.add(new MathUtils.Point(500, 300));
                placements.add(new MathUtils.Point(-500, 300));
                placements.add(new MathUtils.Point(-500, -300));
                placements.add(new MathUtils.Point(500, -300));
            }
//            case 5 -> {
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//            }
//            case 6 -> {
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//                placements.add(new MathUtils.Point(-500, 300));
//            }
        }
    }

    public ArrayList<MathUtils.Point> getPlacements() {
        return placements;
    }

    public MathUtils.Point getPlacement(int i) {
        return placements.get(i);
    }
}
