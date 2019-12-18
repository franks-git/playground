/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Franklin
 */
public class RegularWayPoint extends AbstractWayPoint {
    
    public RegularWayPoint(int posX, int posY) {
        this.setSizeX(10);
        this.setSizeY(this.getSizeX());
        this.setPosX(posX - (this.getSizeX() / 2) );
        this.setPosY(posY - (this.getSizeX() / 2));
        this.setColor(Color.WHITE);
    }

    @Override
    public void render(Graphics g) {
        long now = System.nanoTime();
        Color color = this.getColor();
        
        long c = now % 2000000000;
        
        if (c <= 1000000000) {
            g.setColor(this.getColor());
            
        } else {
            g.setColor(Color.RED);

        }
        
        g.fillOval(this.getPosX(), this.getPosY(), this.getSizeX(), this.getSizeX());
    }
}
