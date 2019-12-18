/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Franklin
 */
public class SmartEnemy extends GameObject {
    
    private Handler handler;
    private GameObject player;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        for (GameObject tempHandler : this.handler.object) {
            if (tempHandler.id == ID.Player) {
                player = tempHandler;
            }
            
        }
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        
        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getVelY()) * (y-player.getY()));
        
        velX = (int)((-1.0/distance) * diffX);
        velY = (int)((-1.0/distance) * diffY);
        
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
        g.setColor(Color.green);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
