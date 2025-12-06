package com.school.app.view.cli;

import java.util.Scanner;

public class MainMenu {

  public static void display() {
    while (true) {

      Scanner keyboard = new Scanner(System.in);
      int userOption;

      System.out.println("--- School System Menu ---");
      System.out.println("1. Dashboard");
      System.out.println("2. Administration");
      System.out.println("3. Exit");

      System.out.print("Your choice: ");
      userOption = keyboard.nextInt();

      switch (userOption) {
        case 1:
          Dashboard.display();
          break;
        case 2:
          Administration.display();
          break;
        case 3:
          System.out.println("Bye");
          keyboard.close();
          System.exit(0);

        default:
          // Handle Input
          System.out.println("Invalid choice");
          continue;
      }
    }
  }
}
