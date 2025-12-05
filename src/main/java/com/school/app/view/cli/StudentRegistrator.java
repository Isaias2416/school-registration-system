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
    System.out.print("Enter Student ID: ");

    Scanner keyboard = new Scanner(System.in);
    String studentIdChoice = keyboard.nextLine().trim();

    Map<String, Student> students = StudentService.load();
    Student student = students.get(studentIdChoice);

    // displays list of available class sections
    Map<Integer, ClassSession> classSections = ClassSessionService.load();
    System.out.println(
        "ID : Course | Instructor | Classroom | Section Number");
    for (ClassSession classSection : classSections.values()) {
      System.out.println(
          classSection.getId() +
              " : " + classSection.getCourse().getName() +
              " | " + classSection.getInstructor().getName() +
              " | " + classSection.getClassroom().getRoomNumber() +
              " | " + classSection.getSectionNumber());
    }

    System.out.print("Enter Class Section ID: ");
    String classSectionChoice = keyboard.nextLine().trim();

    ClassSession classSection = classSections.get(
        Integer.parseInt(classSectionChoice));

    RegistrationService.registerStudent(
        student,
        classSection);

    keyboard.close();
  }
}
