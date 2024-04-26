package com.allboxed.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.allboxed.gaming.sprites.Enemy;
import com.allboxed.gaming.sprites.Player;



public class Board extends JPanel {
	
	Timer timer;
     BufferedImage BackgroundImage;
     Player player;
     Enemy enemy;
   
	public Board(){
		setSize(1200,650);
		loadBackgroundImage();
		player = new Player();
		enemy = new Enemy();
	    gameLoop();
	    bindEvents();
	    setFocusable(true);
	   
		}
	
	private void gameOver(Graphics pen) {
	

		
		 {
			if (isCollide(enemy)) {
				pen.setFont(new Font("times", Font.BOLD, 50));
				pen.setColor(Color.blue);
				pen.drawString("you win", 1500 / 2, 930 / 2);
				timer.stop();
			}
		 }
			
		}
			private boolean isCollide(Enemy enemy) {
				int xDistance = Math.abs(player.x - enemy.x);
				int yDistance = Math.abs(player.y - enemy.y);
				int maxH = Math.max(player.h, enemy.h);
				int maxW = Math.max(player.w, enemy.w);
				return xDistance <= maxW - 720 && yDistance <= maxH - 120;
			}
	private void bindEvents() {
	 
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				player.speed = 0;

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.speed = 10;
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.speed = -5;
				}

			}
		});
	}
	

	

	private void gameLoop() {
		timer = new Timer(50,(e)-> repaint());
		timer.start();
	}
	

	private void loadBackgroundImage() {
		try {
			BackgroundImage= ImageIO.read(Board.class.getResource("background allboxed.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("background image not found...");
			System.exit(1);
			e.printStackTrace();
		}
	}
	@Override
	public void paintComponent(Graphics pen) {
	//all printing logics will be here
		super.paintComponent(pen);//clean up
		pen.drawImage(BackgroundImage,0,0,1500,750,null);
		player.draw(pen);
		player.move();
		enemy.draw(pen);
		gameOver(pen);
	}
}
