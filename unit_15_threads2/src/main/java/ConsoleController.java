import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleController {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Hippodrome hippodrome = new Hippodrome();
    List<Horse> horses = new ArrayList<>();

    @SneakyThrows
    public void runDialogue () {
        System.out.println("Choose a horse (enter horse`s number): ");
        for (int i = 0; i < 5; i++) {
            horses.add(new Horse("horse " + (i+1), hippodrome));
        }
        for (Horse horse : horses) {
            System.out.println(horse.getName());
        }
        int horsesNumber = Integer.parseInt(reader.readLine()) - 1;
        Horse yourHorse = horses.get(horsesNumber);
        System.out.println("You choose horse - " + yourHorse.getName());
        hippodrome.startRace(horses);
        System.out.println("Place of your horse is " + " " + hippodrome.getHorses().indexOf(yourHorse));
    }
}
