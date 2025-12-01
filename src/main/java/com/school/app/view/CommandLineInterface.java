package com.school.app.view;

import java.util.Scanner;

public class CommandLineInterface {
  // Create Dashboard and Administration
  // Methods:
  // 1. displayMenu
  // 2. displayDashboard
  public void displayMenu() {
    Scanner keyboard = new Scanner(System.in);
    int userOption;

    System.out.println("--- School System Menu ---");
    System.out.println("1. Dashboard");
    System.out.println("2. Administration");

    userOption = keyboard.nextInt();

    switch (userOption) {
      case 1:
        displayDashboard();
      case 2:

        break;

      default:
        break;
    }

    keyboard.close();
  }

  public void displayDashboard() {

  }
}
