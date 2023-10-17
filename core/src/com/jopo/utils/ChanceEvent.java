package com.jopo.utils;

public class ChanceEvent {

    private Runnable event;
    private float chance;

    public ChanceEvent(Runnable event, float chance) {
        this.event = event;
        this.chance = chance;
    }

    public Runnable getEvent() {
        return event;
    }

    public float getChance() {
        return chance;
    }

    public void setEvent(Runnable event) {
        this.event = event;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public static void randEvent(ChanceEvent... events) {
        int num = MathUtils.randInt(0, 101);
        float loopingEventChance = 0;
        for (ChanceEvent event : events) {
            loopingEventChance += event.chance;
            if (num <= loopingEventChance) {
                event.event.run();
                return;
            }
        }
    }
}
