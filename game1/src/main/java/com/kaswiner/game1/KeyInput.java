/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Franklin
 */
public class KeyInput extends KeyAdapter {
    
    Handler handler;
    private boolean[] keyDownP1 = new boolean[4];
    private boolean[] keyDownP2 = new boolean[4];
    
    public KeyInput(Handler handler) {
        this.handler = handler;
        
        keyDownP1[0] = false;
        keyDownP1[1] = false;
        keyDownP1[2] = false;
        keyDownP1[3] = false;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (GameObject gameObject : this.handler.object) {
            
            if (gameObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_UP) {
                    gameObject.setVelY(-5);
                    keyDownP1[0] = true;
                } else if (key == KeyEvent.VK_DOWN) {
                    gameObject.setVelY(5);
                    keyDownP1[1] = true;
                } else if (key == KeyEvent.VK_RIGHT) {
                    gameObject.setVelX(5);
                    keyDownP1[2] = true;
                } else if (key == KeyEvent.VK_LEFT) {
                    gameObject.setVelX(-5);
                    keyDownP1[3] = true;
                }
            }

            if (gameObject.getId() == ID.Player2) {
                
                if (key == KeyEvent.VK_W) {
                    gameObject.setVelY(-5);
                    keyDownP2[0] = true;
                } else if (key == KeyEvent.VK_S) {
                    gameObject.setVelY(5);
                    keyDownP2[1] = true;
                } else if (key == KeyEvent.VK_D) {
                    gameObject.setVelX(5);
                    keyDownP2[2] = true;
                } else if (key == KeyEvent.VK_A) {
                    gameObject.setVelX(-5);
                    keyDownP2[3] = true;
                }
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        
        for (GameObject gameObject : this.handler.object) {
            
            if (gameObject.getId() == ID.Player) {
                
                if (key == KeyEvent.VK_UP) {
                    keyDownP1[0] = false;
                    //gameObject.setVelY(0);
                } else if (key == KeyEvent.VK_DOWN) {
                    keyDownP1[1] = false;
                    //gameObject.setVelY(0);
                } else if (key == KeyEvent.VK_RIGHT) {
                    keyDownP1[2] = false;
                    //gameObject.setVelX(0);
                } else if (key == KeyEvent.VK_LEFT) {
                    keyDownP1[3] = false;
                    //gameObject.setVelX(0);
                }

                if (!keyDownP1[0] && !keyDownP1[1]) {
                    gameObject.setVelY(0);
                }
                if (!keyDownP1[2] && !keyDownP1[3]) {
                    gameObject.setVelX(0);
                }
            }

            if (gameObject.getId() == ID.Player2) {
                
                if (key == KeyEvent.VK_W) {
                    keyDownP1[0] = false;
                    //gameObject.setVelY(0);
                } else if (key == KeyEvent.VK_S) {
                    keyDownP1[1] = false;
                    //gameObject.setVelY(0);
                } else if (key == KeyEvent.VK_D) {
                    keyDownP1[2] = false;
                    //gameObject.setVelX(0);
                } else if (key == KeyEvent.VK_A) {
                    keyDownP1[3] = false;
                    //gameObject.setVelX(0);
                }

                if (!keyDownP2[0] && !keyDownP2[1]) {
                    gameObject.setVelY(0);
                }
                if (!keyDownP1[2] && !keyDownP2[3]) {
                    gameObject.setVelX(0);
                }
            }
        }
    }
}
