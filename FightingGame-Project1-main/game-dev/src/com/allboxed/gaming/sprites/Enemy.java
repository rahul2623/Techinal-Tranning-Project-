package com.allboxed.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {
          
            public Enemy() {
            	y = 280 ;
            	x =600;
            	w = 755;
            	h = 400;
            	 image = new ImageIcon(Enemy.class.getResource("monster2.gif"));
            }
          
}
