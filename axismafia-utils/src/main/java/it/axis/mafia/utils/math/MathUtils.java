package it.axis.mafia.utils.math;

import java.util.Random;

public class MathUtils {
    private static final Random random = new Random();

    public static int randomRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
