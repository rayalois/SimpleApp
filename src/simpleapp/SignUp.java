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
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SignUp extends JFrame {
    
    private static class SignUpDisplay extends JComponent{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);            
            g.drawString( "Welcome!", 20, 30 );
        }
    }
    private static JTextField input_fName;
    private static JTextField input_lName;
    private static JTextField input_year;
    //private static input_gender;
private static class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        JOptionPane.showMessageDialog(null,cmd);
        try {
            ConnectDB initdb = new ConnectDB();
            //initdb.insert();
            String fname = input_fName.getText();
            String lname = input_lName.getText();
            String age = input_year.getText();
            //String gender = input_gender.getText();
            initdb.saveUserData(fname, lname, age);
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
public SignUp(){
    
    SignUpDisplay displayPanel = new SignUpDisplay();
    JButton usefb = new JButton("Connect using Facebook");
    JButton usegmail = new JButton("Connect using Gmail");
    JButton pic = new JButton("Change Profile Picture");
    JRadioButton he = new JRadioButton("Male");
    JRadioButton she = new JRadioButton("Female");
    JButton help = new JButton("Help");
    JButton save = new JButton("SAVE");
    JButton resetPass = new JButton("Reset Password");
    ButtonHandler listener = new ButtonHandler();
    usefb.addActionListener(listener);
    usegmail.addActionListener(listener);
    help.addActionListener(listener);
    save.addActionListener(listener);
    pic.addActionListener(listener);
    JLabel fName = new JLabel("First Name:");
    input_fName = new JTextField("",10);
    JLabel lName = new JLabel("Last Name:");
    input_lName = new JTextField("",10);
    JLabel year = new JLabel("Age:");
    input_year = new JTextField("",10);
    
    JPanel others = new JPanel();
    others.add(usefb);
    others.add(usegmail);
    
    JPanel flow1 = new JPanel();
    flow1.add(fName);
    flow1.add(input_fName);
    
    JPanel flow2 = new JPanel();
    flow2.add(lName);
    flow2.add(input_lName);
    
    JPanel flow3 = new JPanel();
    flow3.add(year);
    flow3.add(input_year);
    
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(he);
    genderGroup.add(she);
    
    JPanel gender = new JPanel();
    gender.add(he);
    gender.add(she);
    
    JPanel content = new JPanel();
    content.setLayout(new GridLayout(7,1,1,1));
    content.add(others);
    content.add(flow1);
    content.add(flow2);
    content.add(flow3);
    content.add(gender);
    content.add(save);
    content.add(help);
    
    JFrame myWindow = new JFrame("Sign Up Page");
    myWindow.setContentPane(content);
    myWindow.setSize(600,400);
    myWindow.setLocationRelativeTo(null);
    myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myWindow.setVisible(true);
}
    
//public static void main(String[] args) {
//   SignUp signup1 = new SignUp();
//    signup1.setVisible(true);
//}
}

