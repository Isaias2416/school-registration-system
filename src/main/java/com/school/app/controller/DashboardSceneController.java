package com.school.app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import com.school.app.model.ClassSession;
import com.school.app.service.ClassSessionService;

import java.util.Map;

public class DashboardSceneController {
  private Map<Integer, ClassSession> classSections;

  @FXML
  private Label LLastUpdated;

  @FXML
  private Button BRefresh;

  @FXML
  private TableView<ClassSession> classSectionsTable;

  @FXML
  private TableColumn<ClassSession, Integer> idCol;

  @FXML
  private TableColumn<ClassSession, String> courseIdCol;

  @FXML
  private TableColumn<ClassSession, String> enrolledCapacityCol;

  @FXML
  private TableColumn<ClassSession, String> instructorCol;

  @FXML
  private TableColumn<ClassSession, String> roomIdCol;

  @FXML
  private TableColumn<ClassSession, String> sectionNumberCol;

  // Work in formatted getters for table
  @FXML
  public void initialize() {
    classSections = ClassSessionService.load();

    idCol.setCellValueFactory(
        new PropertyValueFactory<>("id"));

    courseIdCol.setCellValueFactory(
        new PropertyValueFactory<>("course"));

    sectionNumberCol.setCellValueFactory(
        new PropertyValueFactory<>("formatSectionNumber"));

    instructorCol.setCellValueFactory(
        new PropertyValueFactory<>("instructorName"));

    roomIdCol.setCellValueFactory(
        new PropertyValueFactory<>("classroom"));

    enrolledCapacityCol.setCellValueFactory(
        new PropertyValueFactory<>("enrolledCapacity"));

    classSectionsTable.getItems().addAll(classSections.values());

    LLastUpdated.setText(
        LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a")));
  }

  @FXML
  void refreshTable(ActionEvent event) {
    classSections = ClassSessionService.load();

    classSectionsTable.getItems().clear();
    classSectionsTable.getItems().addAll(classSections.values());

    LLastUpdated.setText(
        LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a")));
  }
}
