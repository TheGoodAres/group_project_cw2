package com.mycompany.group_project_cw2;

import org.sqlite.SQLiteException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
    private Component frame;

    Register_GUI() {
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
            if(e.getSource() == registerButton) {
                boolean register = false;
                final Pattern PATTERN = Pattern.compile("^[A-Z\\d._%+-]+@[A-Z\\d.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
                String firstName;
                String lastName;
                String email;
                char[] password;
                char[] confirmPassword;
                firstName = firstNameField.getText();
                lastName = lastNameField.getText();
                email = emailTextField.getText();
                password = passwordField.getPassword();
                confirmPassword = confirmPasswordField.getPassword();
                if (!Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword())) {
                    JOptionPane.showMessageDialog(frame,
                            "Make sure passwords match!",
                            "Password Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                else if (!PATTERN.matcher(email).matches()) {
                    JOptionPane.showMessageDialog(frame,
                            "Make sure you enter a proper email!",
                            "Email error!",
                            JOptionPane.ERROR_MESSAGE);
                } else{
                    Connection con = connectDB.getConnection();

                    register = true;
                }
                if(register) {
                    Connection con = connectDB.getConnection();
                    byte[] byteSalt = null;
                    try {
                        byteSalt = HashPassword.getSalt();
                    } catch (NoSuchAlgorithmException ex) {
                        throw new RuntimeException(ex);
                    }
                    byte[] digestHashPassword = HashPassword.getSaltedHashSHA512(String.valueOf(password), byteSalt);
                    String stringDigestedPassword = HashPassword.toHex(digestHashPassword);
                    String strSalt = HashPassword.toHex(byteSalt);
                    System.out.println(stringDigestedPassword);
                    System.out.println(strSalt);
                    try {
                        PreparedStatement pStatement = con.prepareStatement(
                                "INSERT INTO USER (firstName, lastName, email, password, salt)  VALUES(?, ?, ?, ?, ?)");
                        pStatement.setString(1, firstName);
                        pStatement.setString(2, lastName);
                        pStatement.setString(3, email);
                        pStatement.setString(4, stringDigestedPassword);
                        pStatement.setString(5, strSalt);
                        pStatement.executeUpdate();
                    } catch (SQLException ex) {
                        if(ex.getMessage().contains("USER.email")) {
                            JOptionPane.showMessageDialog(null, "Email already exists");
                        }
                        else throw new RuntimeException(ex);
                    }
                }
            } else {
                setVisible(false);
                Login_GUI GUI = new Login_GUI();
                GUI.setTitle("LOGIN");
                GUI.setVisible(true);
                GUI.setSize(400,600);
                GUI.setResizable(false);
                GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
        public void addActionEvent(){
            loginButton.addActionListener(this);
            registerButton.addActionListener(this);
        }
    }

