import lombok.Getter;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Getter
public class ConsoleManager implements Runnable {
    public String input = null;
    private StringSaver saver;

    public ConsoleManager (StringSaver saver) {
        this.saver = saver;
    }

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @SneakyThrows
    public void run(){
        input = reader.readLine();
        saver.setInput(input);
        while (!input.equals("quit")){
            saver.setInput(input);
            input = reader.readLine();
        }
    }



}
