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

import javax.swing.*;
import java.sql.SQLException;

public class SimpleApp extends JFrame {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    
    


    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
       //SignUp signup1 = new SignUp();
       //signup1.setVisible(true);
       
   
       //SimpleApp myApp = new SimpleApp();
       //myApp.setVisible(true);
        
      AdministratorModule admin = new AdministratorModule();
      admin.setVisible(true);
    }
}

