package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements VideoGame {
	private String game = "pacman";
	
	@Override
	public void up() {
		System.out.println(game + " up");
	}
	
	@Override
	public void down() {
		System.out.println(game + " down");
	}
	
	@Override
	public void left() {
		System.out.println(game + " left");
	}
	
	@Override
	public void right() {
		System.out.println(game + " right");
	}

}