/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matermind_project;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class goal {
    
    // objects 
    Random random = new Random();
   
    
    
   private  int goal[] = new int [4];
    
    
    
    public void palyer_1 ()
    {
  

        int[] goal = {random.nextInt(6) , random.nextInt(6) , random.nextInt(6) , random.nextInt(6)};
        
        this.goal = goal ;
        
        for(int i = 0 ; i < this.goal.length ; i++)
        {
            System.out.print(this.goal[i] + " ");
        }
                    System.out.println();

    }

    public int[] getGoal() {
        return goal;
    }
    
    
    
    
}
