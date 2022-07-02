package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_GUI extends JFrame implements ActionListener {
        Container container = getContentPane();
        JLabel registerTitle = new JLabel("REGISTER");
        JLabel email = new JLabel("Email");
        JLabel password = new JLabel("Password");

        JLabel confirmPassword = new JLabel("Confirm password");
        JTextField emailTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JPasswordField confirmPasswordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("LOGIN HERE");

        JLabel firstName = new JLabel("First name");
        JLabel lastName = new JLabel("Last name");

        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        Register_GUI() {
            setLayout();
            setComponentsLocation();
            addComponents();
        }
        public void setLayout()
        {
            container.setLayout(null);
        }
        public void setComponentsLocation() {
            //title
            registerTitle.setBounds(180, 20, 200, 100);
           //labels
            email.setBounds(70,180,150,40);
            password.setBounds(70,220,150,40);
            confirmPassword.setBounds(70, 260, 150, 40);
            firstName.setBounds(70, 95, 150, 40);
            lastName.setBounds(70, 135, 150, 40);
            //text fields
            emailTextField.setBounds(190,180,150,30);
            passwordField.setBounds(190,220,150,30);
            confirmPasswordField.setBounds(190,260,150,30);
            firstNameField.setBounds(190, 100,150, 30);
            lastNameField.setBounds(190, 140, 150, 30);
            //buttons
            loginButton.setBounds(85,330,100,30);
            registerButton.setBounds(235,330,100,30);


        }
        public void addComponents() {
            container.add(registerTitle);
            container.add(email);
            container.add(emailTextField);
            container.add(password);
            container.add(passwordField);
            container.add(loginButton);
            container.add(registerButton);
            container.add(confirmPasswordField);
            container.add(confirmPassword);
            container.add(firstName);
            container.add(lastName);
            container.add(firstNameField);
            container.add(lastNameField);
        }
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

