package com.csit228.capstone.utils;

import com.csit228.capstone.model.Serializer;
import com.csit228.capstone.model.User;

import java.io.File;
public final class AppSession {

  public static final Serializer serializer = new Serializer();
  public static User currentUser = null;

  private AppSession() {
  }

  public static void loadSession() {
    serializer.setFilePath("user.ser");
    currentUser = (User) serializer.deserialize();
  }

  public static void saveSession(User user) {
    currentUser = user;
    serializer.setUser(user);
    serializer.serialize();
  }

  public static void clearSession() {
    currentUser = null;
    serializer.setUser(null);
    serializer.setTicket(null);
    serializer.setFilePath("user.ser");

    File sessionFile = new File("user.ser");

    try {
      if (sessionFile.exists()) {
        boolean deleted = sessionFile.delete();

        if (!deleted) {
          new java.io.FileOutputStream(sessionFile, false).close();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static String getInitialScreen() {
    if (currentUser == null || currentUser.getRole() == null) {
      return "LoginView.fxml";
    }

    return switch (currentUser.getRole()) {
      case MEMBER -> "DashboardMemberView.fxml";
      case EXECUTIVE -> "DashboardExecutiveView.fxml";
      case EDITOR -> "DashboardEditorView.fxml";
    };
  }
}
