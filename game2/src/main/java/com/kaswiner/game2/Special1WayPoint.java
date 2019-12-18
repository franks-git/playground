/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Franklin
 */
public class Special1WayPoint extends AbstractWayPoint {
    private float transparency = 0.3f;
    
    public Special1WayPoint(int posX, int posY) {
        this.setSizeX(15);
        this.setSizeY(20);
        this.setPosX(posX - (this.getSizeX() / 2) );
        this.setPosY(posY - (this.getSizeX() / 2));
        this.setColor(Color.BLUE);
    }

    @Override
    public void render(Graphics g) {
        long now = System.nanoTime();
        g.setColor(this.getColor());
        
        Graphics2D g2d = (Graphics2D) g;
        
        long c = now % 2000000000;

        if (c <= 1000000000) {
            if (this.transparency < 0.3f) this.transparency = 0.3f;
            if (this.transparency > 1.0f) this.transparency = 1.0f;

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.transparency));
            this.transparency += 0.001f;
            
        } else {
            if (this.transparency < 0.3f) this.transparency = 0.3f;
            if (this.transparency > 1.0f) this.transparency = 1.0f;
        
            
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, this.transparency));
            this.transparency -= 0.001f;

        }
        
        g.fillOval(this.getPosX(), this.getPosY(), this.getSizeX(), this.getSizeY());

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
    }
    
}
