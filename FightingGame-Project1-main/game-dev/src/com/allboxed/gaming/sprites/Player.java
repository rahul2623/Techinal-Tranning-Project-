package com.allboxed.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {
        
          public Player() {
        	  w =408;
        	  h = 480;
        	  x =100;
        	  y =200;
        	 image = new ImageIcon(Player.class.getResource("goku2 image.gif"));
        	 
          }
      public void move() {
    	  x = x + speed;
      }
}
