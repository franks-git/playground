/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game2;


import static com.kaswiner.game2.Game2Window.HEIGHT;
import static com.kaswiner.game2.Game2Window.WIDTH;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Franklin
 */
public class Map1 {
    private List<AbstractWayPoint> wayPoints;
    private BufferedImage imageBackgroundMap;
    
    public Map1() {
        this.wayPoints = new ArrayList<>();
        
        try {
            this.imageBackgroundMap = ImageIO.read(new File("img/grass_template2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //INITIALIZING
        this.wayPoints.add(new RegularWayPoint(40 + 40, 40));
        this.wayPoints.add(new RegularWayPoint(80 + 40, 40));
        this.wayPoints.add(new RegularWayPoint(120 + 40, 40));
        this.wayPoints.add(new RegularWayPoint(160 + 40, 40));
        this.wayPoints.add(new RegularWayPoint(200 + 40, 40));
        this.wayPoints.add(new RegularWayPoint(240 + 40, 40));
        this.wayPoints.add(new Special1WayPoint(280 + 40, 40));

        this.wayPoints.add(new RegularWayPoint(280 + 40, 80));
        this.wayPoints.add(new RegularWayPoint(240 + 40, 80));
        this.wayPoints.add(new RegularWayPoint(200 + 40, 80));
        this.wayPoints.add(new RegularWayPoint(160 + 40, 80));
        this.wayPoints.add(new RegularWayPoint(120 + 40, 80));
        this.wayPoints.add(new RegularWayPoint(80 + 40, 80));
        this.wayPoints.add(new Special1WayPoint(40 + 40, 80));

        this.wayPoints.add(new RegularWayPoint(40 + 40, 120));
        this.wayPoints.add(new RegularWayPoint(80 + 40, 120));
        this.wayPoints.add(new RegularWayPoint(120 + 40, 120));
        this.wayPoints.add(new RegularWayPoint(160 + 40, 120));
        this.wayPoints.add(new RegularWayPoint(200 + 40, 120));
        this.wayPoints.add(new RegularWayPoint(240 + 40, 120));
        this.wayPoints.add(new Special1WayPoint(280 + 40, 120));

        this.wayPoints.add(new RegularWayPoint(280 + 40, 160));
        this.wayPoints.add(new RegularWayPoint(240 + 40, 160));
        this.wayPoints.add(new RegularWayPoint(200 + 40, 160));
        this.wayPoints.add(new RegularWayPoint(160 + 40, 160));
        this.wayPoints.add(new RegularWayPoint(120 + 40, 160));
        this.wayPoints.add(new RegularWayPoint(80 + 40, 160));
        this.wayPoints.add(new Special1WayPoint(40 + 40, 160));
        
    }


    public void renderRoads(Graphics g) {
        int origemX = 0;
        int origemY = 0;
        int destinoX = 0;
        int destinoY = 0;
        
        for (int i = 0; i < this.wayPoints.size(); i++) {
            if (i == 0) {
                
            } else {
                origemX = this.wayPoints.get(i - 1).getPosX();
                origemY = this.wayPoints.get(i - 1).getPosY();
                destinoX = this.wayPoints.get(i).getPosX();
                destinoY = this.wayPoints.get(i).getPosY();
                
                g.drawLine(origemX, origemY, destinoX, destinoY);
            }
            

        }
    }
    
    public void render(Graphics g) {
        //DESENHANDO FUNDO
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(this.imageBackgroundMap, 0, 0, null);
        
        this.renderRoads(g);
        /*
        //ESTRADA 1
        g.setColor(Color.ORANGE);
        g.fillRect(40 + 40, 40, 250, 10);
        g.setColor(Color.ORANGE);
        g.fillRect(280 + 40, 40, 10, 40);
        
        //ESTRADA 2
        g.setColor(Color.ORANGE);
        g.fillRect(40 + 40, 80, 250, 10);
        g.setColor(Color.ORANGE);
        g.fillRect(40 + 40, 80, 10, 40);

        //ESTRADA 3
        g.setColor(Color.ORANGE);
        g.fillRect(40 + 40, 120, 250, 10);
        g.setColor(Color.ORANGE);
        g.fillRect(280 + 40, 120, 10, 40);

        //ESTRADA 4
        g.setColor(Color.ORANGE);
        g.fillRect(40 + 40, 160, 250, 10);
        */
        //Rendering Waypoints
        for (AbstractWayPoint wayPoint : this.wayPoints) {
            wayPoint.render(g);
        }

    }
    
    
}
