package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Login {
    public static void main(String[] args) {
        Login_GUI GUI = new Login_GUI();
        GUI.setTitle("LOGIN");
        GUI.setVisible(true);
        GUI.setSize(400,600);
        GUI.setResizable(false);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
