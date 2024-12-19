/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matermind_project;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Administrator
 */
public class cheacking {
     private boolean[] found = {false, false, false, false};  // Track correct positions
    private boolean[] goalMatched = {false, false, false, false};  // Track which goal positions are matched


 
    // Green light 
    
 public boolean light_check(
    int a, int b, int c, int d,
    int goal_a, int goal_b, int goal_c, int goal_d,
    JLabel label1, JLabel label2, JLabel label3, JLabel label4
) {
    boolean allGreen = true; // Flag to check if all labels are green

    // Reset found and goalMatched arrays
    for (int i = 0; i < found.length; i++) {
        found[i] = false;
        goalMatched[i] = false;
    }

    
    
    // Check the green lights
    if (a == goal_a && !goalMatched[0]) {
        label1.setBackground(Color.GREEN);
        found[0] = true;
        goalMatched[0] = true;
        
    } 
    if (b == goal_b && !goalMatched[1]) {
        label2.setBackground(Color.GREEN);
        found[1] = true;
        goalMatched[1] = true;

    } 
    if (c == goal_c && !goalMatched[2]) {
        label3.setBackground(Color.GREEN);
        found[2] = true;
        goalMatched[2] = true;

    } 
     if (d == goal_d && !goalMatched[3]) {
        label4.setBackground(Color.GREEN);
        found[3] = true;
        goalMatched[3] = true;
    }
    
    
    
    // check the yellow lights
     if (((a == goal_b & !goalMatched[1]  )  ||( a == goal_c & !goalMatched[2]  )|| ( a == goal_d)& !goalMatched[3] ) && !goalMatched[0]) {
        label1.setBackground(Color.YELLOW);
        goalMatched[0] = true;
        allGreen = false; // If not green, set to false
    } 
     else  if (!goalMatched[0]) {
        label1.setBackground(Color.RED);
        allGreen = false;
    } 
     
      if (((b == goal_a & !goalMatched[0]) || (b == goal_c  & !goalMatched[2]) || ( b == goal_d & !goalMatched[3] ) ) && !goalMatched[1]) {
        label2.setBackground(Color.YELLOW);
        goalMatched[1] = true;
        allGreen = false;
    }
      else if ( !goalMatched[1]) {
        label2.setBackground(Color.RED);
        allGreen = false;
    }
      
      
     if (((c == goal_a & !goalMatched[0]  )|| (c == goal_b & !goalMatched[1] ) || (c == goal_d & !goalMatched[3] )) && !goalMatched[2]) {
        label3.setBackground(Color.YELLOW);
        goalMatched[2] = true;
        allGreen = false;
    } 
     else if (!goalMatched[2]) {
        label3.setBackground(Color.RED);
        allGreen = false;
    }
     
      if (((d == goal_a & !goalMatched[0] )|| (d == goal_b & !goalMatched[1]) || (d == goal_c & !goalMatched[2])) && !goalMatched[3]) {
        label4.setBackground(Color.YELLOW);
        goalMatched[3] = true;
        allGreen = false;
    } 
      else if (goalMatched[3] == false) {
        label4.setBackground(Color.RED);
        allGreen = false;
    }
     

     
     
     
    // Return whether all labels are green
    return allGreen;
}

    public boolean[] getFound() {
        return found;
    }
 
 
 
 
}
