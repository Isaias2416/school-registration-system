package com.school.app.view.cli;

import java.util.Map;

import com.school.app.model.ClassSession;
import com.school.app.service.ClassSessionService;

public class Dashboard {

  public static void display() {

    Map<Integer, ClassSession> classSections = ClassSessionService.load();
    if (classSections.size() <= 0) {
      System.out.println("There are no class sections yet.");
      MainMenu.display();
    }
    // ======== HEADING ========
    System.out.println("\n================ ACTIVE CLASS SECTIONS ================\n");

    // ======== COLUMN HEADERS ========
    System.out.printf(
        "%-5s | %-10s | %-15s | %-12s | %-8s | %-8s | %-25s%n",
        "ID", "Course", "Instructor", "Room", "Section", "Capacity", "Registered Students");

    // ======== HORIZONTAL SEPARATOR ========
    System.out.println(
        "-----------------------------------------------------------------------------------------------");

    // ID | Course Id | Instructor Id | Classroom Id | Section Number | Capacity |
    // Registered Students Ids

    for (ClassSession classSection : classSections.values()) {

      System.out.printf(
          "%-5d | %-10s | %-15s | %-12s | %-8d | %-8d | %-25s%n",
          classSection.getId(),
          classSection.getCourse(),
          classSection.getInstructor(),
          classSection.getClassroom(),
          classSection.getSectionNumber(),
          classSection.getMaxCapacity(),
          classSection.getEnrolledStudents().size());
    }

    // ======== FOOTER SEPARATOR ========
    System.out.println(
        "-----------------------------------------------------------------------------------------------\n");

    MainMenu.display();
  }
}
