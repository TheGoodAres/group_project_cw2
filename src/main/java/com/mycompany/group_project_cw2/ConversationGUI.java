package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversationGUI extends JFrame implements ActionListener {
        Container container = getContentPane();
        JButton backButton = new JButton("BACK");
        JLabel textLabel = new JLabel();
        String text;
        ConversationGUI(String text) {
            System.out.println(text);
            setLayout();
            setComponentsLocation();
            addComponents();
            addActionEvent();
            textLabel.setFont(new Font("Serif", Font.PLAIN, 14));
            textLabel.setText(text);
        }
        public void setLayout()
        {
            container.setLayout(null);
        }
        public void setComponentsLocation() {
            textLabel.setBounds(40,20,300,500);
            backButton.setBounds(235,530,100,30);
        }
        public void addComponents() {
            container.add(backButton);
            container.add(textLabel);

        }
        public void addActionEvent(){
            backButton.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == backButton) {
                setVisible(false);
                ConversationStarter GUI = new ConversationStarter();
                GUI.setTitle("LOGIN");
                GUI.setVisible(true);
                GUI.setSize(400,600);
                GUI.setResizable(false);
                GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
    }
