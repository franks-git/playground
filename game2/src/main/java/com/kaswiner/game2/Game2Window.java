/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game2;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Franklin
 */
public class Game2Window extends Canvas {
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    
    public Game2Window(String title) {
        
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
        
        this.requestFocus();
    }
    
    public void render() {
        

    }
    
}
