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
import java.awt.*;
import java.awt.event.*;

public class DrugFacts{
    private static JFrame DrugFactsDisplay;
    private static JTextField searchtxt;
    private static JLabel search;
    
    private static class DrugFactsDisplay extends JPanel{
       public void paintComponent(Graphics g){
           super.paintComponents(g);
     
       }
    }

    private static class ButtonnHandler implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
        }
    }
    
    
public DrugFacts(){    
    
}
}