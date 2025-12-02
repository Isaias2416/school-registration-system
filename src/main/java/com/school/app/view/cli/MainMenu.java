package com.school.app.view.cli;

import java.util.Scanner;

public class MainMenu {
  // Create Dashboard and Administration
  // Methods:
  // 1. displayMenu
  // 2. displayDashboard
  // 3. displayAdministration
  public void displayMenu() {
    Scanner keyboard = new Scanner(System.in);
    int userOption;

    System.out.println("--- School System Menu ---");
    System.out.println("1. Dashboard");
    System.out.println("2. Administration");

    userOption = keyboard.nextInt();

    switch (userOption) {
      case 1:
        Dashboard.display();
      case 2:
        Administration.display();
        break;

      default:
        // Handle Input
        break;
    }

    keyboard.close();
  }

}
