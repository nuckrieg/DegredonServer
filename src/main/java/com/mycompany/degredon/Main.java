/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.degredon;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author FabioAbreu
 */
public class Main {

    public static void main(String args[]) {
        
        JFrame mainFrame = new JFrame();
        mainFrame.add(new ClientPanel());
        
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);

        // this.pdfSearchPanel();
        mainFrame.setTitle("Degredon Client");
        mainFrame.setVisible(true);

        

        
    }
    
    
    
    public void tryOut() {
        Stats stats = new Stats();
        stats.setAll(10);
        
        Player player = new Player();
        player.setStats(stats);
        System.out.println(player.getStats().AIR_DMG);
    }
}
