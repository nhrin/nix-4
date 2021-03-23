import java.util.Scanner;

public class ServiceReverseString {
    static void choiserOptionForReverse() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, choose an option for reverse");
        System.out.println("Enter 1 for simple reverse text without arguments");
        System.out.println("Enter 2 for reverse on the specified substring in the string");
        System.out.println("Enter 3 for reverse by numeric indices");

        String choice = scanner.nextLine();

        switch (choice) {
            case ("1"):
                System.out.println("Enter your text only");
                System.out.println(StringReverse.reverse(scanner.nextLine()));
                break;
            case ("2"):
                System.out.println("Enter your text");
                String textForSubstring = scanner.nextLine();
                System.out.println("Enter substring that you want to reverse");
                String substring = scanner.nextLine();
                System.out.println(StringReverse.reverse(textForSubstring, substring));
                break;
            case ("3"):
                System.out.println("Enter your text");
                String textForIndexes = scanner.nextLine();
                System.out.println("Enter start index");
                try {
                    int startIndex = scanner.nextInt();
                    System.out.println("Enter end index");
                    int endIndex = scanner.nextInt();
                    System.out.println(StringReverse.reverse(textForIndexes, startIndex, endIndex));
                } catch (Exception e) {
                    System.out.println("You entered impossible number");
                    e.printStackTrace();

                }
                break;
        }
    }
}

