package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI extends JFrame implements ActionListener {
    Container container = getContentPane();
    JLabel loginTitle = new JLabel("LOGIN");
    JLabel email = new JLabel("Email");
    JLabel password = new JLabel("Password");
    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton registerButton = new JButton("REGISTER HERE");
    Login_GUI() {
        setLayout();
        setComponentsLocation();
        addComponents();
    }
    public void setLayout()
    {
        container.setLayout(null);
    }
    public void setComponentsLocation() {
        loginTitle.setBounds(180, 20, 200, 100);
        email.setBounds(80,130,150,40);
        password.setBounds(80,230,150,30);
        emailTextField.setBounds(190,130,150,30);
        passwordField.setBounds(190,230,150,30);
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
