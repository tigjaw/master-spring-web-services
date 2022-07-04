package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
	@Autowired
	private VideoGame game;

	public GameRunner(VideoGame game) {
		this.game = game;
	}
	
	public void run() {
		game.up();
		game.down();
		game.left();
		game.right();
	}

	public VideoGame getGame() {
		return game;
	}

	public void setGame(VideoGame game) {
		this.game = game;
	}

}