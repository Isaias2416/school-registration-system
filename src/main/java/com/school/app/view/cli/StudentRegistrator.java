package com.school.app.view.cli;

import java.util.Scanner;
import java.util.Map;

import com.school.app.service.ClassSessionService;
import com.school.app.service.RegistrationService;
import com.school.app.service.StudentService;
import com.school.app.model.ClassSession;
import com.school.app.model.Student;

public class StudentRegistrator {
  public static void display() {
    boolean completedForm = false;
    while (!completedForm) {
      System.out.print("Enter Student ID: ");

      Scanner keyboard = new Scanner(System.in);
      String studentIdChoice = keyboard.nextLine().trim();

      Map<String, Student> students = StudentService.load();
      if (students.get(studentIdChoice) == null) {
        System.out.println("Invalid Student Id, try again:");
        continue;
      }

      // displays list of available class sections
      Map<Integer, ClassSession> classSections = ClassSessionService.load();
      System.out.println(
          "ID : Course | Instructor | Classroom | Section Number");
      for (ClassSession classSection : classSections.values()) {
        System.out.println(
            classSection.getId() +
                " : " + classSection.getCourse() +
                " | " + classSection.getInstructor() +
                " | " + classSection.getClassroom() +
                " | " + classSection.getSectionNumber());
      }

      System.out.print("Enter Class Section ID: ");
      String classSectionIdChoice = keyboard.nextLine().trim();

      boolean validClassSection = false;
      while (!validClassSection) {

        ClassSession classSection = classSections.get(
            Integer.parseInt(classSectionIdChoice));

        if (classSection == null) {
          System.out.println("Invalid class Section choice, try again");
          continue;
        }
        validClassSection = true;

        // at this point student is not null
        Student student = students.get(studentIdChoice);
        RegistrationService newRegistration = new RegistrationService();

        try {
          newRegistration.registerStudent(
              student,
              classSection);
        } catch (Exception e) {
          System.out.println(e.getMessage());
          System.out.println("Try again");
          continue;
        }
        completedForm = true;

        System.out.println("Student has been succesfully registered");
        Administration.display();
      }
    }
  }
}
