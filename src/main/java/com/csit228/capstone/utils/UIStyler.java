package com.csit228.capstone.utils;

import com.csit228.capstone.model.TicketView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class UIStyler {
  
  public static void applyNavyBlueHeaderGradient(Region region) {
    LinearGradient gradient = new LinearGradient(
      0, 0, 1, 0, true, CycleMethod.NO_CYCLE,   // Left to right gradient
      new Stop(0, Color.web("#1f3e8f")),
      new Stop(1, Color.web("#3a7ef3"))
    );
    
    region.setBackground(new Background(new BackgroundFill(gradient, CornerRadii.EMPTY, Insets.EMPTY)));
  }
}
