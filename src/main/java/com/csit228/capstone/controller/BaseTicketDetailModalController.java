package com.csit228.capstone.controller;
import com.csit228.capstone.utils.UIStyler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class BaseTicketDetailModalController {
  
  @FXML
  public Button buttonClose;
  @FXML
  public HBox ticketHeader;

  
  @FXML
  public void initialize() {
    UIStyler.applyNavyBlueHeaderGradient(ticketHeader);
  }

}
