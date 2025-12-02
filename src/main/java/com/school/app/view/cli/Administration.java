package com.school.app.view.cli;

import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

import com.school.app.model.Instructor;
import com.school.app.service.InstructorService;
import com.school.app.model.ClassSession;

public class Administration {
  public static void display() {
    int userOption;
    Scanner keyboard = new Scanner(System.in);
    System.out.println("--- Administration Menu ---");
    System.out.println("1. Create Class Section");
    System.out.println("2. Register Student");
    System.out.println("3. Go Back");

    userOption = keyboard.nextInt();
    switch (userOption) {
      case 1:
        //
      case 2:
        //
      case 3:
        //
        break;

      default:
        break;
    }
    keyboard.close();

  }

  public class ClassSectionCreator {
    public static void display() {
      System.out.print("Enter Course ID: ");

      Scanner keyboard = new Scanner(System.in);
      String courseIdChoice = keyboard.next();

      // Need CourseService.java
      // Then use it to the a Course object to use
      // RegistrationService.findElegibleInstructor()

      System.out.print("Enter Instructor ID: ");
      String instructorIdChoice = keyboard.next();

      // Checks if the teaching assingment credits of the instructor
      // is less or equal than 9, otherwise it succeedes and add the course
      // to the instructor teachingAssignment
      // ----------------------
      // Instructor instructorChoice = qualifiedInstructors.get(instructorIdChoice);
      // if (instructorChoice.getCurrentLoad() <= 9) {
      // // To create classesssion, I need course, classroom, sectionnumber,
      // // and maxCapacity
      //
      // // ClassSession classSession =
      // // new ClassSession(theCourse, theInstructor, theClassroom, theMaxCapacity)
      // System.out.println(
      // "Success! " + instructorChoice +
      // " has been assigned" + courseIdChoice);
      // }
      // ---------------------------

      keyboard.close();

    }
  }
}
