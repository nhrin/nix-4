public class Main {
    public static void main(String[] args) {
        StringSaver saver = new StringSaver();
        ConsoleManager consoleManager = new ConsoleManager(saver);
        WriterToFile writer = new WriterToFile(saver);
        consoleManager.run();
        writer.run();
    }
}
