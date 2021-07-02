import lombok.Getter;
import lombok.SneakyThrows;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.Phaser;


@Getter
public class Hippodrome {
    private List<Horse> horses = new ArrayList<>();
    private Map<Instant, String> result = new HashMap<>();
    private final Phaser phaser = new Phaser(1);


    @SneakyThrows
    public void startRace (List<Horse> horseList) {

        for (Horse horse : horseList) {
            new Thread(horse).start();
            horses.add(horse);
        }

        phaser.arriveAndDeregister();
        Thread.sleep(5000);
        Collections.sort(horses);
    }
}
