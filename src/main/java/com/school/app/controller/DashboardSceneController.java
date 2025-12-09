package com.school.app.controller;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import com.school.app.model.ClassSession;
import com.school.app.service.ClassSessionService;

import java.util.Map;

public class DashboardSceneController {
  private Map<Integer, ClassSession> classSections;

  @FXML
  private Button BRefresh;

  @FXML
  private TableView<ClassSession> classSectionsTable;

  @FXML
  private TableColumn<ClassSession, Integer> idCol;

  @FXML
  private TableColumn<ClassSession, Integer> courseIdCol;

  @FXML
  private TableColumn<ClassSession, Integer> enrolledCapacityCol;

  @FXML
  private TableColumn<ClassSession, String> instructorCol;

  @FXML
  private TableColumn<ClassSession, String> roomIdCol;

  @FXML
  private TableColumn<ClassSession, Integer> sectionNumberCol;

  @FXML
  public void initialize() {
    classSections = ClassSessionService.load();

    courseIdCol.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
  }

  @FXML
  void refreshTable(ActionEvent event) {
    classSections = ClassSessionService.load();

  }
}
