package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register_GUI extends JFrame implements ActionListener {
        //container
        Container container = getContentPane();
        //Labels
        JLabel registerTitle = new JLabel("REGISTER");
        JLabel email = new JLabel("Email");
        JLabel password = new JLabel("Password");
        JLabel confirmPassword = new JLabel("Confirm password");
        //Text fields
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JTextField emailTextField = new JTextField();
        JLabel firstName = new JLabel("First name");
        JLabel lastName = new JLabel("Last name");
        //Password field
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();
        //Buttons
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("LOGIN HERE");
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
            registerTitle.setBounds(180, 10, 200, 80);
           //labels
            firstName.setBounds(70, 95, 150, 40);
            lastName.setBounds(70, 160, 150, 40);
            email.setBounds(70,225,150,40);
            password.setBounds(70,290,150,40);
            confirmPassword.setBounds(70, 355, 150, 40);
            //text fields
            firstNameField.setBounds(190, 100,150, 30);
            lastNameField.setBounds(190, 165, 150, 30);
            emailTextField.setBounds(190,230,150,30);
            passwordField.setBounds(190,295,150,30);
            confirmPasswordField.setBounds(190,360,150,30);
            //buttons
            loginButton.setBounds(85,430,100,30);
            registerButton.setBounds(235,430,100,30);


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

