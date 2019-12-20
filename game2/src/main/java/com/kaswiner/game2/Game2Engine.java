/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game2;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franklin
 */
public class Game2Engine implements Runnable {
    
    private Thread thread = null;
    private boolean running = true;
    
    private Game2Window game2Window = null;
    private final Map1 map1;
    private final List<Player> players;
    
    
    public Game2Engine() {
        this.game2Window = new Game2Window("JOGO");
        this.map1 = new Map1();
        this.players = new ArrayList<>();
        
        Player player1 = new Player(10, 50);
        this.players.add(player1);

        this.game2Window.addKeyListener(new MapKeyInput(player1));
    }
    
    public synchronized void start() {
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    public synchronized void stop() {
        try {
            this.thread.join();
            this.running = false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
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
        //Ticking Players
        for (Player player : this.players) {
            player.tick();
        }

        //Players
        //HUD
        //SPAWN (VERIFICA EVOLUCAO DE LEVEL)
    }
    
    private void render() {
        BufferStrategy bs = this.game2Window.getBufferStrategy();
        if (bs == null) {
            this.game2Window.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();

        //Rendering map
        this.map1.render(g);
        
        //Rendering Players
        for (Player player : this.players) {
            player.render(g);
        }

        //Rendering Enemies

        //Rendering HUD

        g.dispose();
        bs.show();

    }
    
    
}
