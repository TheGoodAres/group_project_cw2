package com.mycompany.group_project_cw2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ConversationStarter extends JFrame implements ActionListener {
    Container container = getContentPane();
    String[] levels = {"A1", "A2", "B1", "B2"};

    JButton startConversationButton = new JButton("START CONVERSATION");
    //LABELS
    JLabel dropDownLevelLabel = new JLabel("LEVEL");
    JLabel dropDownContextLabel = new JLabel("CONTEXT");
    JLabel dropDownSubContextLabel = new JLabel("SUB-CONTEXT");
    //DROP DOWN MENUS
    JComboBox<String> dropDownLevel = new JComboBox<>(levels);
    JComboBox<String> dropDownContext = new JComboBox<>();
    JComboBox<String> dropDownSubContext = new JComboBox<>();

    //BUTTON

    ConversationStarter() {
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
        //drop down menus
            dropDownLevel.setBounds(200,60,100,30);
            dropDownContext.setBounds(200,160,100,30);
            dropDownSubContext.setBounds(200, 240, 100,30);
            startConversationButton.setBounds(120, 450, 200, 30);
            //labels
            dropDownLevelLabel.setBounds(120, 55, 100, 30);
            dropDownContextLabel.setBounds(110,160,100,30);
            dropDownSubContextLabel.setBounds(100, 240, 100, 30);
    }
    public void addComponents() {
        container.add(dropDownContext);
        container.add(dropDownLevel);
        container.add(dropDownSubContext);
        container.add(dropDownContextLabel);
        container.add(dropDownLevelLabel);
        container.add(dropDownSubContextLabel);
        container.add(startConversationButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dropDownLevel && dropDownLevel.getSelectedItem() != null) {
            String level = (String) dropDownLevel.getSelectedItem();

            Connection cons = connectDB.getConnection();
            try {
                PreparedStatement preparedStatement = cons.prepareStatement("SELECT DISTINCT CONTEXT FROM CONVERSATION WHERE LEVEL = (?)");
                preparedStatement.setString(1,level);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    dropDownContext.addItem(resultSet.getString("CONTEXT"));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == dropDownContext && dropDownContext.getSelectedItem() != null) {
            Connection cons = connectDB.getConnection();
            try {
                PreparedStatement preparedStatement2 = cons.prepareStatement("SELECT DISTINCT SUB_CONTEXT_T FROM CONVERSATION WHERE LEVEL = (?) AND CONTEXT = (?)");
                preparedStatement2.setString(1, String.valueOf(dropDownLevel.getSelectedItem()));
                preparedStatement2.setString(2, String.valueOf(dropDownContext.getSelectedItem()));
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                while (resultSet2.next()) {
                    dropDownSubContext.addItem(resultSet2.getString("SUB_CONTEXT_T"));
                    System.out.println(resultSet2.getString("SUB_CONTEXT_T"));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == startConversationButton) {
            if(dropDownContext.getSelectedItem() == null || dropDownLevel.getSelectedItem() == null || dropDownSubContext.getSelectedItem() == null) {
            }
            else {
                Object[] option = {"A", "B"};
                int result = JOptionPane.showConfirmDialog(null, "Do you want to be person A?");
                switch (result) {
                    case JOptionPane.YES_OPTION://0
                        break;
                    case JOptionPane.NO_OPTION://1
                        break;
                }
                Connection connection = connectDB.getConnection();
                String textRetrieved = "";
                try {
                    PreparedStatement preparedStatement3 = connection.prepareStatement("SELECT CONVERSATION_TEXT FROM CONVERSATION WHERE LEVEL = (?) AND CONTEXT = (?) AND SUB_CONTEXT_T = (?)");
                    preparedStatement3.setString(1, String.valueOf(dropDownLevel.getSelectedItem()));
                    preparedStatement3.setString(2, String.valueOf(dropDownContext.getSelectedItem()));
                    preparedStatement3.setString(3, String.valueOf(dropDownSubContext.getSelectedItem()));
                    ResultSet resultSet3 = preparedStatement3.executeQuery();
                    while (resultSet3.next()) {
                        textRetrieved = resultSet3.getString("CONVERSATION_TEXT");
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                String[] text_after = textRetrieved.split("A:|B:");
                int z = -1;
                if(result == 0) {
                    z = 1;
                } else if(result == 1) {
                    z = 0;
                }
                String textToPass = "<HTML>";
                for (int i = 1 ; i < text_after.length; i++) {
                    if(i % 2 == z) {
                        textToPass += text_after[i] + "<br>";
                    }
                }
                textToPass += "</HTML>";
                System.out.println(textToPass);
                setVisible(false);
                ConversationGUI GUI = new ConversationGUI(textToPass);
                GUI.setTitle("CONVERSATION");
                GUI.setVisible(true);
                GUI.setSize(400,600);
                GUI.setResizable(false);
                GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        }
    }
    public void addActionEvent(){
        startConversationButton.addActionListener(this);
        dropDownContext.addActionListener(this);
        dropDownLevel.addActionListener(this);
        dropDownSubContext.addActionListener(this);
    }


    public static void main(String[] args) {
        ConversationStarter GUI = new ConversationStarter();
        GUI.setTitle("CONVERSATION START");
        GUI.setVisible(true);
        GUI.setSize(400,600);
        GUI.setResizable(false);
        GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
