package com.school.app.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.school.app.model.Classroom;

public class ClassroomService {
  public static Map<String, Classroom> load() {
    Map<String, Classroom> classrooms = new HashMap<>();

    String homeDir = "/home/jhonatan/";
    String fileDir = homeDir +
        "Projects/Github/jhonatanparada499/" +
        "school-registration-system/data/";
    String fileName = "Classroom.csv";
    String filePath = fileDir + fileName;

    // try-resource closes file automatically
    try (Scanner scanner = new Scanner(new File(filePath))) {
      scanner.useDelimiter(",|\\n"); // match: comma(,) or new line(\n)

      while (scanner.hasNext()) {
        String idField = scanner.next();
        String nameField = scanner.next();
        int creditsField = scanner.nextInt();

        // Classroom course = new Classroom();
        // classrooms.put(idField, course);
      }

    } catch (Exception e) {
      System.out.println(e);
    }

    return classrooms;
  }
}
}
