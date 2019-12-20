/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game1;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Franklin
 */
public class Hud {
    
    public static float HEALTH = 100;
    private float greenValue = 255;
    
    private int score = 0;
    private int level = 1;
    
    public void tick() {
        HEALTH = Game1.clamp(HEALTH, 0, 100);
        greenValue = Game1.clamp(greenValue, 0, 255);
        greenValue = HEALTH*2;
        
        score++;
    }
    
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(75, (int)greenValue, 0));
        g.fillRect(15, 15, (int)HEALTH * 2, 32);
        g.setColor(Color.WHITE);
        g.drawRect(15, 15, 200, 32);
        
        g.drawString("Score: " + score, 15, 64);
        g.drawString("Level: " + getLevel(), 15, 80);
    }
    
    public void score (int score) {
        this.score = score;
    }
    
    public int getScore() {
        return this.score;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }
    
}
