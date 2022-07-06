package com.mycompany.group_project_cw2;

import java.sql.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        Connection con = connectDB.getConnection();
        String context = "Ordering food and drink";
        String subContext = "Takeaway";
        String level = "A1";
        PreparedStatement pStatement;
        ResultSet resultSet;
        {
            try {
                pStatement = con.prepareStatement(
                        "SELECT CONVERSATION_TEXT FROM CONVERSATION WHERE LEVEL = (?) AND CONTEXT = (?) AND SUB_CONTEXT_T = (?) ");
                pStatement.setString(1, level);
                pStatement.setString(2, context);
                pStatement.setString(3, subContext);
                resultSet = pStatement.executeQuery();
                resultSet.next();
                String text = resultSet.getString("CONVERSATION_TEXT");
                System.out.println(text);
                String[] text_after = text.split("A:|B:");
                for (int i = 1 ; i < text_after.length; i++) {
                    if(i % 2 == 1) {
                        System.out.println("A: " + text_after[i]);
                    } else {
                        System.out.println("B: " + text_after[i]);
                    }
                }
                System.out.println(Arrays.toString(text_after));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
