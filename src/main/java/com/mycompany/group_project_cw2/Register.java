package com.mycompany.group_project_cw2;

import javax.swing.*;

public class Register {
    public static void main(String[] args) {
        Register_GUI GUI = new Register_GUI();
        GUI.setTitle("REGISTER");
        GUI.setVisible(true);
        GUI.setSize(400,600);
        GUI.setResizable(false);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
