/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.kaswiner.game1.object.BasicEnemy;
import com.kaswiner.game1.object.Player;

/**
 *
 * @author Franklin
 */
public class Game1 extends Canvas implements Runnable {
    
    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    
    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Hud hud;
    private Spawn spawner;
    
    public Game1() {
        this.handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "JOGO", this);
        
        this.hud = new Hud();
        this.spawner = new Spawn(handler, hud);
        
        handler.addGameObject(new Player(WIDTH/2, HEIGHT/2, ID.Player, handler));
        handler.addGameObject(new BasicEnemy(WIDTH/2, HEIGHT/2, ID.BasicEnemy, handler));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            
            while (delta >= 1) {
                this.tick();
                delta--;
            }
            
            if (running) {
                this.render();
            }
            
            frames++;
            
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS:" + frames);
                frames = 0;
               
            }
        }
        stop();
    }
    
    private void tick() {
        handler.tick();
        hud.tick();
        spawner.tick();
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        
        handler.render(g);
        hud.render(g);
        
        g.dispose();
        bs.show();
    }
    
    public static float clamp(float var, float min, float max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game1();
    }

}
