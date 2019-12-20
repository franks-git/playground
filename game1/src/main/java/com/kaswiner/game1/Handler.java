/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaswiner.game1;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Franklin
 */
public class Handler {
    
    LinkedList<GameObject> objects = new LinkedList<>();
    
    public LinkedList<GameObject> getObjects() {
		return objects;
	}

	public void tick() {
        for (GameObject gameObject : objects) {
            gameObject.tick();
        }
    }
    
    public void render(Graphics g) {
        for (GameObject gameObject : objects) {
            gameObject.render(g);
        }
    }
    
    public void addGameObject(GameObject object) {
        this.objects.add(object);
    }
    
    public void removeGameObject(GameObject object) {
        this.objects.remove(object);
    }
    
}
