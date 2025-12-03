package com.school.app.view.cli;

import java.util.Scanner;

public class MainMenu {

  public static void display() {
    Scanner keyboard = new Scanner(System.in);
    int userOption;

    System.out.println("--- School System Menu ---");
    System.out.println("1. Dashboard");
    System.out.println("2. Administration");

    System.out.print("Your choice: ");
    userOption = keyboard.nextInt();

    switch (userOption) {
      case 1:
        Dashboard.display();
      case 2:
        Administration.display();
        break;

      default:
        // Handle Input
        System.out.println("Invalid choice");
        System.exit(0);
        break;
    }

    keyboard.close();
  }

}
