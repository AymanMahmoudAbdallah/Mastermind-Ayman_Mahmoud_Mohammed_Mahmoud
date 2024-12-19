/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.matermind_project;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Matermind_Project {

    public static void main(String[] args) {
        
          // Game goal setup
        cheacking check = new cheacking(); 
        goal gg = new goal();
        
        int goal [] = new int [4] ;

        // generate the goal numbers
        gg.palyer_1();
        
        for (int i = 0 ; i < goal.length ; i++)
        {
        goal[i] = gg.getGoal()[i];
        }
        
        // GUI Setup
        JFrame frame = new JFrame("Guess Game"); // make the frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setup the close program 
        frame.setSize(600, 400); // setup the game resulotion 
        frame.setLayout(new BorderLayout()); // setup the border layout to the game 

        // Top label
        JLabel topLabel = new JLabel("Input your Guess", JLabel.CENTER);  // make the top label (input your guess)
        topLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(topLabel, BorderLayout.NORTH); 


        // Main panel (buttons)
        JPanel mainPanel = new JPanel(); // make the left labl (the buttons)
        mainPanel.setLayout(new GridLayout(4, 1)); // setup the number of row and coulms 


        // Right labels
        JPanel rightPanel = new JPanel(); //  the the right label (the light checker)
        rightPanel.setLayout(new GridLayout(4, 1));    // setup the number of row and coulms 


        // Labels to show the results
        JLabel[] labels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            labels[i] = new JLabel("Light check " + (i + 1), JLabel.CENTER);
            labels[i].setFont(new Font("Arial", Font.PLAIN, 12));
            labels[i].setOpaque(true); // Enable background color
            labels[i].setBackground(Color.LIGHT_GRAY); // Default color
            rightPanel.add(labels[i]);  // put the label in the right label 
        }

        // Buttons to select guesses
        JButton[] buttons = new JButton[4];    
        int[] colorIndex = {0, 0, 0, 0};  
        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, new Color(128, 0, 128)}; 

        for (int i = 0; i < 4; i++) {
             int buttonIndex = i;
            buttons[i] = new JButton("Light " + (i + 1));
            buttons[i].setPreferredSize(new Dimension(150, 50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttons[buttonIndex].setBackground(colors[colorIndex[buttonIndex]]);
                    colorIndex[buttonIndex] = (colorIndex[buttonIndex] + 1) % colors.length;
                }
            });
            mainPanel.add(buttons[i]);  // add buttons to left panel
        }

        // Bottom panel for attempts and submit button
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JLabel attemptsLabel = new JLabel("Remaining attempts: 10", JLabel.CENTER); // make the Remaining label 
        attemptsLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        bottomPanel.add(attemptsLabel, BorderLayout.NORTH); // add the label to the panel 

        JButton submitButton = new JButton("Check Now"); // make the submit button 
        submitButton.setPreferredSize(new Dimension(100, 30));
        bottomPanel.add(submitButton, BorderLayout.CENTER);

        // Add panels to the frame
        frame.add(mainPanel, BorderLayout.WEST); 
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // ActionListener for the Submit button
        submitButton.addActionListener(new ActionListener() {
            int num_of = 1;

            @Override
            public void actionPerformed(ActionEvent e) {
                int remainingAttempts = 10 - num_of;
                
                check.light_check(
                        colorIndex[0], colorIndex[1], colorIndex[2], colorIndex[3],
                        goal[0], goal[1], goal[2], goal[3],
                        labels[0], labels[1], labels[2], labels[3]
                );


                
                
                // Check if the user has won
                boolean [] won = new boolean [4];
                
                for (int i = 0 ; i< check.getFound().length ; i++)
                {
                    won[i] = check.getFound()[i] ;
                }

                
                String solve [] = new String [4];
                
                    //  print the colors  when losing
                    for (int i = 0 ; i < goal.length ; i++)
                    {
                    if (gg.getGoal()[i] == 0)
                    {
                    solve[i] = "Purple";
                    }
                    else if (gg.getGoal()[i] == 1)
                    {
                         solve[i] = "Red";
                    }
                    else if (gg.getGoal()[i] == 2)
                    {
                         solve[i] = "Green";
                    }
                    else if (gg.getGoal()[i] == 3)
                    {
                         solve[i] = "Blue";
                    }
                    else if (gg.getGoal()[i] == 4)
                    {
                         solve[i] = "Yellow";
                    
                    }else if (gg.getGoal()[i] == 5)
                    {
                         solve[i] = "Orange";
                    }

                    }
                
                
                
                // Update attempts label
                attemptsLabel.setText("Remaining attempts: " + remainingAttempts);
                num_of++;

                // If the user has won 
                if (won[0] == true && won[1] == true && won[2] == true && won[3] == true  ) {
                    JOptionPane.showMessageDialog(frame, "You won!", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0); // Close the game
                }

                //  if the user has lose 
                if (remainingAttempts == 0) {
                    
                 
                    JOptionPane.showMessageDialog(frame, "You lose   The solve was  { " + solve[0] + "," + solve[1] + "," + solve[2] + "," + solve[3] + "}"   , "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }

                frame.repaint(); // Refresh GUI
            }
        });

        frame.setVisible(true); // Show the frame
        
    }
}
