package by.etc.firsttask.generator;

import java.util.Random;

public class GeneratorId {
    private static final Integer MAX_ID = 99999;
    private static final Integer MIN_ID = 100;
    private static Random random = new Random();

    public static int generate() {
        return MIN_ID + random.nextInt(MAX_ID - MIN_ID + 1);
    }

}
