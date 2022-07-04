package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI extends JFrame implements ActionListener {
    //container
    Container container = getContentPane();
    //labels
    JLabel loginTitle = new JLabel("LOGIN");
    JLabel email = new JLabel("Email");
    JLabel password = new JLabel("Password");
    //text field
    JTextField emailTextField = new JTextField();
    //password field
    JPasswordField passwordField = new JPasswordField();
    //buttons
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("REGISTER HERE");
    Login_GUI() {
        setLayout();
        setComponentsLocation();
        addComponents();
        addActionEvent();
    }
    public void setLayout()
    {
        container.setLayout(null);
    }
    public void setComponentsLocation() {
        //title
        loginTitle.setBounds(180, 20, 200, 100);
        //labels
        email.setBounds(80,130,150,40);
        password.setBounds(80,230,150,30);
        //text fields
        emailTextField.setBounds(190,130,150,30);
        passwordField.setBounds(190,230,150,30);
        //buttons
        loginButton.setBounds(85,330,100,30);
        registerButton.setBounds(235,330,100,30);
    }
    public void addComponents() {
        container.add(loginTitle);
        container.add(email);
        container.add(emailTextField);
        container.add(password);
        container.add(passwordField);
        container.add(loginButton);
        container.add(registerButton);
    }
    public void addActionEvent() {
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String email;
            char[] password;
            email = emailTextField.getText();
            password = passwordField.getPassword();
            System.out.println(password);
        } else {
            Register_GUI GUI = new Register_GUI();
            GUI.setTitle("REGISTER");
            GUI.setVisible(true);
            GUI.setSize(400,600);
            GUI.setResizable(false);
            GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
    }
}
