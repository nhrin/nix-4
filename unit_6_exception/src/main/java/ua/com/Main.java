package ua.com;

import ua.com.service.DateService;

public class Main {

    public static void main(String[] args) {

      try {
          DateService dateService = new DateService();
          dateService.run();
      } catch (Exception e) {
          System.out.println("You made a mistake");
          main(new String[]{""});
      }
    }
}
