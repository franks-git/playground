/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Franklin
 */
public class BasicEnemy extends GameObject {
    
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        this.setVelX(5);
        this.setVelY(5);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        if (y <= 0 || y >= Game1.HEIGHT - 32) {
            this.setVelY(this.getVelY() * -1);
        }
        if (x <= 0 || x >= Game1.WIDTH - 16) {
            this.setVelX(this.getVelX() * -1);
        }
        
        //handler.addGameObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.02f, handler));
    }
        
        
    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
