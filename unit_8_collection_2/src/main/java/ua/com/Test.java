package ua.com;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ISet<Number> numberISet = new MathSet<>();

    Test (){
        System.out.println("Demo of custom set \"MathSet \"");
    }


    @SneakyThrows
    static void run() {
        System.out.println("You may use main functions (enter number):");
        System.out.println("1. - for add number into set");
        System.out.println("2. - for sort and show set (Asc)");
        System.out.println("3. - for sort and show set (Desc)");
        System.out.println("4. - for getting and show max value in your set");
        System.out.println("5. - for getting and show min value in your set");
        System.out.println("6. - for clear your set");
        System.out.println("0. - for exit demo");
        String choice;

        while ((choice = reader.readLine()) != null) {
            switch (choice) {
                case "1" : {
                    System.out.println("Enter your number");
                    numberISet.add(Integer.parseInt(reader.readLine()));
                    run();
                }
                case "2" : {
                    numberISet.sortAsc();
                    numberISet.show();
                    run();
                }
                case "3" : {
                    numberISet.sortDesc();
                    numberISet.show();
                    run();
                }
                case "4" : {
                    System.out.println(numberISet.getMax());
                    run();
                }
                case "5" : {
                    System.out.println(numberISet.getMin());
                    run();
                }
                case "6" : {
                    numberISet.clear();
                    System.out.println("Cleared");
                    run();
                }
                case "0" : {
                    System.exit(0);
                }


            }


        }
    }

}
