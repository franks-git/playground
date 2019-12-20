/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.gamelet1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Franklin
 */
public class MapKeyInput extends KeyAdapter {
    
    private final boolean[] keyDownP1 = new boolean[4];
    private boolean[] keyDownP2 = new boolean[4];
    private List<Player> players;
    
    public MapKeyInput(Player player) {
        this.players = new ArrayList<>();
        
        this.players.add(player);
                
        keyDownP1[0] = false;
        keyDownP1[1] = false;
        keyDownP1[2] = false;
        keyDownP1[3] = false;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        System.out.println("HeyPressed=>" + key);

        for (Player player : this.players) {
            
            if (key == KeyEvent.VK_UP) {
                player.setVelY(-1);
                keyDownP1[0] = true;
            } else if (key == KeyEvent.VK_DOWN) {
                player.setVelY(1);
                keyDownP1[1] = true;
            } else if (key == KeyEvent.VK_RIGHT) {
                player.setVelX(1);
                keyDownP1[2] = true;
            } else if (key == KeyEvent.VK_LEFT) {
                player.setVelX(-1);
                keyDownP1[3] = true;
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (Player player : this.players) {

            if (key == KeyEvent.VK_UP) {
                keyDownP1[0] = false;
                player.setVelY(0);
            } else if (key == KeyEvent.VK_DOWN) {
                keyDownP1[1] = false;
                player.setVelY(0);
            } else if (key == KeyEvent.VK_RIGHT) {
                keyDownP1[2] = false;
                player.setVelX(0);
            } else if (key == KeyEvent.VK_LEFT) {
                keyDownP1[3] = false;
                player.setVelX(0);
            }
        }
    }

    /**
     * @return the players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
