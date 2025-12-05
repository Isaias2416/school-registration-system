package com.school.app.service;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.school.app.model.Student;
import com.school.app.model.ClassSession;

public class StudentService {
  public static Map<String, Student> load() {
    Map<String, Student> students = new HashMap<>();

    Path path = Paths.get("data", "Students.csv");
    String filePath = String.valueOf(path);

    try (Scanner scanner = new Scanner(new File(filePath))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();

        if (line.trim().isEmpty()) {
          continue;
        }

        String[] columns = line.split(",");

        String idField = columns[0];
        String nameField = columns[1];
        String majorField = columns[2];
        String enrolledClassesField = columns[3];

        List<ClassSession> enrolledClasses = new ArrayList<>();

        // checks if the student is not enrolled in at least one class
        if (!enrolledClassesField.trim().isEmpty()) {
          String[] enrolledClassesArray = enrolledClassesField.split("\\|");

          for (String classSectionid : enrolledClassesArray) {
            int id = Integer.parseInt(classSectionid);
            ClassSession enrolledClass = ClassSessionService.load().get(id);
            enrolledClasses.add(enrolledClass);
          }
        }
        // Student.csv should have a fourth field similar to
        // Instructor.csv that lists the classes they are enroolled in
        Student student = new Student(
            idField,
            nameField,
            majorField,
            enrolledClasses);

        students.put(idField, student);
      }
    } catch (Exception e) {
      System.out.println("Exception from studentService");
      System.out.println(e);
    }

    return students;
  }
}
