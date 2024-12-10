package net.pythonbear.tead.util;

import net.minecraft.util.math.Vec3d;

public class LightningTask {
    private final Vec3d position;
    private int delayTicks;

    public LightningTask(Vec3d position, int delayTicks) {
        this.position = position;
        this.delayTicks = delayTicks;
    }

    public Vec3d getPosition() {
        return position;
    }

    public int getDelayTicks() {
        return delayTicks;
    }

    public void decrementDelay() {
        this.delayTicks--;
    }

    public boolean isReady() {
        return delayTicks <= 0;
    }
}
