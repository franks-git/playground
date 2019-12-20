/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game1.object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.kaswiner.game1.Game1;
import com.kaswiner.game1.GameObject;
import com.kaswiner.game1.Handler;
import com.kaswiner.game1.Hud;
import com.kaswiner.game1.ID;

/**
 *
 * @author Franklin
 */
public class Player extends GameObject {
    
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
    }
    
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        x = Game1.clamp(x, 0, Game1.WIDTH - 38);
        y = Game1.clamp(y, 0, Game1.HEIGHT - 60);
        
        this.collision();
    }
    
    private void collision() {
        
        for (GameObject gameObject : handler.getObjects()) {
            if (gameObject.getId() == ID.BasicEnemy || gameObject.getId() == ID.FastEnemy || gameObject.getId() == ID.SmartEnemy) {
                if (this.getBounds().intersects(gameObject.getBounds())){
                    Hud.HEALTH -= 2;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.red);
        g2d.draw(this.getBounds());

        if (id == ID.Player) {
            g.setColor(Color.white);
            g.fillRect((int)x, (int)y, 32, 32);
        } else if (id == ID.Player2) {
            g.setColor(Color.blue);
        }
        
    }
}
