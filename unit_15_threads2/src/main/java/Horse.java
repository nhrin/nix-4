import lombok.Getter;
import lombok.SneakyThrows;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.Phaser;


@Getter
public class Horse implements Runnable, Comparable<Horse> {

    private final int MIN_DISTANCE = 100;
    private final int MAX_DISTANCE = 200;
    private final int MIN_SLEEP = 400;
    private final int MAX_SLEEP = 500;
    private int currentPosition = 1;
    private final String name;
    private Boolean isFinished = false;
    Phaser phaser;
    Instant instant;
    Hippodrome hippodrome;



    public Horse (String name, Hippodrome hippodrome) {
        this.name = name;
        this.hippodrome = hippodrome;
        this.phaser = hippodrome.getPhaser();
        phaser.register();
    }


    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        while (currentPosition <= 1000) {
         move();
         sleep();
        }
        isFinished = true;
        instant = Instant.now();
        phaser.arriveAndDeregister();
    }


    @SneakyThrows
    private void move() {
        Random random = new Random();
        int distance = random.nextInt(MAX_DISTANCE - MIN_DISTANCE + 1) + MIN_DISTANCE;
        currentPosition += distance;
        System.out.println("Horse " + name + " ran " + distance + " meters");
    }

    private void sleep() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(MAX_SLEEP - MIN_SLEEP + 1) + MIN_SLEEP);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int compareTo(Horse o) {
        return instant.compareTo(o.getInstant());
    }

    @Override
    public String toString() {
        return name + instant.atZone(ZoneId.of("Europe/Kiev"));
    }
}
