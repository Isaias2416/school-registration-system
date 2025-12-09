package com.school.app.view.cli;

import java.util.Map;

import com.school.app.model.ClassSession;
import com.school.app.service.ClassSessionService;

public class Dashboard {

    public static void display() {

        // ======== HEADING ========
        System.out.println("\n================ ACTIVE CLASS SECTIONS ================\n");

        // ======== COLUMN HEADERS ========
        System.out.printf(
                "%-5s | %-10s | %-15s | %-12s | %-8s | %-8s | %-25s%n",
                "ID", "Course", "Instructor", "Room", "Section", "Capacity", "Registered Students IDs"
        );

        // ======== HORIZONTAL SEPARATOR ========
        System.out.println(
                "-----------------------------------------------------------------------------------------------"
        );

        // ID | Course Id | Instructor Id | Classroom Id | Section Number | Capacity | Registered Students Ids
        Map<Integer, ClassSession> classSections = ClassSessionService.load();

        for (ClassSession classSection : classSections.values()) {

            String studentIds = "";

            if (classSection.getEnrolledStudents().isEmpty()) {
                studentIds = "None";
            } else {
                for (int i = 0; i < classSection.getEnrolledStudents().size(); i++) {
                    studentIds += classSection.getEnrolledStudents().get(i).getId();
                    if (i < classSection.getEnrolledStudents().size() - 1) {
                        studentIds += ", ";
                    }
                }
            }

            // ✅ SAME LOOP STYLE — JUST FORMATTED OUTPUT
            System.out.printf(
                    "%-5d | %-10s | %-15s | %-12s | %-8d | %-8d | %-25s%n",
                    classSection.getSectionNumber(),
                    classSection.getCourse().getCourseId(),
                    classSection.getInstructor().getId(),
                    classSection.getClassroom().getRoomNumber(),
                    classSection.getSectionNumber(),
                    classSection.getMaxCapacity(),
                    studentIds
            );
        }

        // ======== FOOTER SEPARATOR ========
        System.out.println(
                "-----------------------------------------------------------------------------------------------\n"
        );

        // ✅ System.exit(0) REMOVED so program returns to menu naturally
    }
}
