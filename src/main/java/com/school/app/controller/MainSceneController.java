package com.school.app.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.fxml.FXMLLoader;

public class MainSceneController {
  @FXML
  private Tab tabAdministration;

  @FXML
  private Tab tabDashboard;

  @FXML
  private Tab tabStudent;

  public void initialize() {
    try {
      Parent administrationView = FXMLLoader
          .load(getClass().getResource("/com/school/app/view/administrationScene.fxml"));
      Parent dashboardView = FXMLLoader.load(getClass().getResource("/com/school/app/view/dashboardScene.fxml"));
      Parent studentView = FXMLLoader.load(getClass().getResource("/com/school/app/view/studentScene.fxml"));

      tabAdministration.setContent(administrationView);
      tabDashboard.setContent(dashboardView);
      tabStudent.setContent(studentView);

    } catch (Exception e) {
      System.out.println("Error from mainScene controller.");
      System.out.println(e);
    }
  }
}
