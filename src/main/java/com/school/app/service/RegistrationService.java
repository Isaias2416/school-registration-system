package com.school.app.service;

import com.school.app.model.*;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Methods:
 * 1. findElegibleInstructor(...)
 * 2. createClassSession(...)
 * 3. registerStudent(...)
 */

public class RegistrationService {

  // SchoolException used by createClassSession
  class SchoolException extends Exception {
    public SchoolException(String theMessage) {
      super(theMessage);
    }
  }

  public List<Instructor> findEligibleInstructors(Course theCourse) {
    List<Instructor> eligibleInstructors = new ArrayList<>();

    // load parsed Instructors.csv data
    Map<String, Instructor> instructors = InstructorService.load();

    for (Instructor instructor : instructors.values()) {
      if (instructor.canTeach(theCourse)) {
        eligibleInstructors.add(instructor);
      }
    }

    return eligibleInstructors;
  }

  // inconsistency: it would make more sense to create a class session
  public ClassSession createClassSection(
      Course theCourse,
      Instructor theInstructor,
      Classroom theClassroom,
      int theCapacity) throws SchoolException {

    if (!theInstructor.canTeach(theCourse)) {
      throw new SchoolException("Instructor load exceeded");
    }

    if (theInstructor.getCurrentLoad() +
        theCourse.getCredits() > 9) {
      throw new SchoolException("Instructor load exceeded");
    }

    // Create session or section?
    // Incosistency: is theCapacity the max capicity or initial?
    ClassSession classSection = new ClassSession(theCourse,
        theInstructor, theClassroom, theCapacity);

    // Add section to the instructor
    theInstructor.addTeachingAssignment(classSection);

    // Does storing (this) to the system mean to write it to Classroom.csv?
    // It would make sense to have a ClassSession.csv file
    // ...

    // The method is called createClassSection but it returns a ClassSession
    // object? In my opinion, the word section should no be used.
    return new ClassSession(
        theCourse, theInstructor,
        theClassroom, theCapacity);
  }

}
