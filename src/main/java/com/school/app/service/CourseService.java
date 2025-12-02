package com.school.app.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.school.app.model.Course;

public class CourseService {
  public static Map<String, Course> load() {
    Map<String, Course> courses = new HashMap<>();

    String homeDir = "/home/jhonatan/";
    String fileDir = homeDir +
        "Projects/Github/jhonatanparada499/" +
        "school-registration-system/data/";
    String fileName = "Course.csv";
    String filePath = fileDir + fileName;

    // try-resource closes file automatically
    try (Scanner scanner = new Scanner(new File(filePath))) {
      scanner.useDelimiter(",|\\n"); // match: comma(,) or new line(\n)

      while (scanner.hasNext()) {
        String idField = scanner.next();
        String nameField = scanner.next();
        int creditsField = scanner.nextInt();

        Course course = new Course(idField,
            nameField, creditsField);
        courses.put(idField, course);
      }

    } catch (Exception e) {
      System.out.println(e);
    }

    return courses;
  }
}
