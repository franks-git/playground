/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.util.Random;

/**
 *
 * @author Franklin
 */
public class Spawn {
    
    private Handler handler;
    private Hud hud;
    
    private int scoreeKeep = 0;
    Random r = new Random();
    
    public Spawn(Handler handler, Hud hud) {
        this.handler = handler;
        this.hud = hud;
        
    }
    
    public void tick() {
        scoreeKeep++;
        
        if (scoreeKeep >= 100) {
            scoreeKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            
            if (hud.getLevel() == 2) {
                handler.addGameObject(new BasicEnemy(r.nextInt(Game1.WIDTH), r.nextInt(Game1.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addGameObject(new BasicEnemy(r.nextInt(Game1.WIDTH), r.nextInt(Game1.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4) {
                handler.addGameObject(new FastEnemy(r.nextInt(Game1.WIDTH), r.nextInt(Game1.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 5) {
                handler.addGameObject(new SmartEnemy(r.nextInt(Game1.WIDTH), r.nextInt(Game1.HEIGHT), ID.SmartEnemy, handler));
            }
        }
        
    }
    
}
