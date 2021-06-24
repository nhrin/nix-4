import lombok.SneakyThrows;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class WriterToFile implements Runnable {

    private StringSaver stringSaver;
    private String temp;


    public WriterToFile(StringSaver stringSaver) {
        this.stringSaver = stringSaver;
    }

    @SneakyThrows
    @Override
    public void run() {
        try (RandomAccessFile writer = new RandomAccessFile("output.txt", "rw")) {

            while (!temp.equals("quit")) {
                String output = stringSaver.getInput();

                if (!output.equals(temp)) {
                    writer.seek(0);
                    writer.write(output.getBytes(StandardCharsets.UTF_8));
                    temp = output;
                    Thread.sleep(1000);
                }
            }
        } catch (NullPointerException e) {
            System.exit(0);
        }
    }
}
