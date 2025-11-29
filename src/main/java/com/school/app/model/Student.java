package com.school.app.model;

import java.util.List;

public class Student {
  private String id;
  private String name;
  private String major;
  private List<ClassSession> enrolledClasses;

  public Student(String theId, String theName,
      String theMajor,
      List<ClassSession> theEnrolledClasses) {
    id = theId;
    name = theName;
    major = theMajor;
    enrolledClasses = theEnrolledClasses;
  }

  public int getCurrentCredits() {
    int currentCredits = 0;
    Course currentCourse;
    for (ClassSession classSession : enrolledClasses) {
      currentCourse = classSession.getCourse();
      currentCredits += currentCourse.getCredits();
    }
    return currentCredits;
  }

}
