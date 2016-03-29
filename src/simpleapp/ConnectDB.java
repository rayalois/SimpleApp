/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleapp;

/**
 *
 * @author user
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectDB {
    Connection conn;
    String url = "jdbc:mysql://localhost/myproject";
    PreparedStatement stm;
    public ConnectDB() throws SQLException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,"root","");
            System.out.println("DB connected");
            
        }catch(java.lang.ClassNotFoundException e){
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }
    }
    public void saveUserData(String fname, String lname, String age) throws SQLException{
        String user_sql = "INSERT INTO users(fName, lname, age, userName, passWord) VALUES(?,?,?,?,?)";
        String username = fname+""+age;
        String password = "1234";
        try (PreparedStatement saveuser_stm = conn.prepareStatement(user_sql)) {
            saveuser_stm.setString(1, fname);
            saveuser_stm.setString(2, lname);
            saveuser_stm.setString(3, age);
            saveuser_stm.setString(4, username);
            saveuser_stm.setString(5, password);
            boolean rs;
            rs = saveuser_stm.execute();
            System.out.print(rs);
            JOptionPane.showMessageDialog(null,"Saved successfully. New user name is: "+username+"\n login password is: "+password);
        }
        stm.close();
        conn.close();
    }
    public void insert(String drugName, String drugDescription, String drugSideEffects) throws SQLException{
      // 
      String sql = "INSERT INTO drugs(drugName,drugDescription,drugSideEffects) VALUES(?,?,?)";
      stm = conn.prepareStatement(sql);
      stm.setString(1, drugName);
      stm.setString(2, drugDescription);
      stm.setString(3, drugSideEffects);
      boolean rs = stm.execute();
      JOptionPane.showMessageDialog(null,"Saved "+drugName+" succesfully.");
      stm.close();
      conn.close();
    }
}
