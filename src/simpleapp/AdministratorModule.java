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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministratorModule extends JFrame {

    /**
     * @param args the command line arguments
     */

    
    private static JFrame drugm;
    private static JFrame userm;
    private static JFrame statsm;
    private static JFrame adminWindow;
    private static JTextField input_dName;
    private static JTextArea input_dEffects;
    private static JTextArea input_dDesc;
    private static JFrame newDrugWindow;
    
     private static class DrugInfoDisplay extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString( "Hello!", 20, 30 );
        }
    }
     
     private static class ButtonHandler implements ActionListener {
         @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            switch (cmd)
            {
                case "Drug Management":
                    drugm.setVisible(true);
                    adminWindow.setVisible(false);
                    statsm.setVisible(false);
                    break;
            
                case "User Management":
                    userm.setVisible(true);
                    adminWindow.setVisible(false);
                    statsm.setVisible(false);
                    break;
                
                case "Statistics":
                    statsm.setVisible(true);
                    adminWindow.setVisible(false);
                    break;
                    
                case "Add a new drug":
                {
                    /*String ndrug = JOptionPane.showInputDialog("What is the "
                            + "name of the new drug?");
                    String drugDescription = JOptionPane.showInputDialog("Add "
                            + "a brief description of the drug");
                    String msg = String.format("%s has been added.", ndrug);
                    JOptionPane.showMessageDialog(null,msg);*/
                    drugm.setVisible(false);
                    newDrugWindow.setVisible(true);
                    break;
                }
                
                case "SAVE DRUG":
                {
                    try {
                        ConnectDB initdb = new ConnectDB();
                        String drugName = input_dName.getText();
                        String drugDescription = input_dDesc.getText();
                        String drugSideEffects = input_dEffects.getText();
                        initdb.insert(drugName, drugDescription, drugSideEffects);
                    } catch (SQLException ex) {
                        Logger.getLogger(AdministratorModule.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }break;
                
                case "Deactivate Account":
                {    
                    String uFName = JOptionPane.showInputDialog("What is the"
                            + " user's first name?");
                    String uLName = JOptionPane.showInputDialog("What "
                            + "is the user's last name?");
                    String msg = String.format("%s %s's account has been"
                            + " deactivated.", uFName,uLName);
                    JOptionPane.showMessageDialog(null,msg);
                } break;   
                default:
                    adminWindow.setVisible(true);
            }
        } 
    }

public AdministratorModule(){
    
    ButtonHandler listener = new ButtonHandler();
    JButton drugmgr = new JButton("Drug Management");
    JButton usermgr = new JButton("User Management");
    JButton stats = new JButton("Statistics");
    drugmgr.addActionListener(listener);
    usermgr.addActionListener(listener);
    stats.addActionListener(listener);
    JButton add = new JButton("Add a new drug");
    JButton save = new JButton("SAVE");
    JButton saved = new JButton("SAVE DRUG");
    add.addActionListener(listener);
    save.addActionListener(listener);
    saved.addActionListener(listener);
    JButton resetPass = new JButton("Reset Password");
    resetPass.addActionListener(listener);
    JButton DeActivate = new JButton("Deactivate Account");
    DeActivate.addActionListener(listener);
    JButton respond = new JButton("Give feedback");
    respond.addActionListener(listener);
    JButton del = new JButton("Remove drug details");
    del.addActionListener(listener);
    JButton edit = new JButton("Edit drug information");
    edit.addActionListener(listener);
    JButton repLocation = new JButton("Click here to View searchess by "
            + "user based on location");
    repLocation.addActionListener(listener);
    JButton repFrequency = new JButton("Click here to View "
            + "the most serched drugs");
    repFrequency.addActionListener(listener);
    JButton hom = new JButton("Home");
    hom.addActionListener(listener);
    JLabel dName = new JLabel("Name of drug: ");
    JLabel dType = new JLabel("Type of drug: ");
    JLabel dDesc = new JLabel("Description of drug: ");
    JLabel dEffects = new JLabel("Side effects of drug: ");
    input_dName = new JTextField("",20);
    input_dDesc = new JTextArea(5,40);
    input_dEffects = new JTextArea(5,40);
    
    JPanel pan1 = new JPanel();
    pan1.add(dName);
    pan1.add(input_dName);
    
    JPanel pan2 = new JPanel();
    pan2.add(dDesc);
    pan2.add(input_dDesc);
    
    JPanel pan3 = new JPanel();
    pan3.add(dEffects);
    pan3.add(input_dEffects);
    
    
    JPanel ndw = new JPanel();
    ndw.setLayout(new GridLayout(4,2,1,1));
    ndw.add(pan1);
    ndw.add(pan2);
    ndw.add(pan3);
    ndw.add(saved);
    
    newDrugWindow = new JFrame("Add a new drug");
    newDrugWindow.setContentPane(ndw);
    newDrugWindow.setSize(600,400);
    newDrugWindow.setLocationRelativeTo(null);
    newDrugWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    newDrugWindow.setVisible(false);
    
    
    JPanel contents = new JPanel();
    contents.setLayout(new GridLayout(1,3,1,1));
    contents.add(drugmgr);
    contents.add(usermgr);
    contents.add(stats);
    
    JPanel contents2 = new JPanel();
    contents2.setLayout(new GridLayout(1,4,1,1));
    contents2.add(DeActivate);
    contents2.add(resetPass);
    contents2.add(respond);
    
    JPanel contents1 = new JPanel();
    contents1.add(add);
    contents1.add(del);
    contents1.add(edit);
      
    JPanel contents3 = new JPanel();
    contents3.setLayout(new GridLayout(3,1,1,3));
    contents3.add(repLocation);
    contents3.add(repFrequency);
    contents3.add(hom);
    
    adminWindow = new JFrame("Administrator");
    adminWindow.setContentPane(contents);
    adminWindow.setSize(600,400);
    adminWindow.setLocationRelativeTo(null);
    adminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    adminWindow.setVisible(true);
    
    drugm = new JFrame("Drug Management");
    drugm.setContentPane(contents1);
    drugm.setSize(600,400);
    drugm.setLocationRelativeTo(null);
    drugm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    drugm.setVisible(false);
    
    userm = new JFrame("User Management");
    userm.setContentPane(contents2);
    userm.setSize(600,400);
    userm.setLocationRelativeTo(null);
    userm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    userm.setVisible(false);
    
    statsm = new JFrame("Statistics");
    statsm.setContentPane(contents3);
    statsm.setSize(600,400);
    statsm.setLocationRelativeTo(null);
    statsm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    statsm.setVisible(false);
}  

  //  public static void main(String[] args) {
   //     AdministratorModule admin = new AdministratorModule();
   //     admin.setVisible(true);
   // }
}


