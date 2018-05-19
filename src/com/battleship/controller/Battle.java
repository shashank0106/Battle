package com.battleship.controller;

import java.util.List;

import com.battleship.domain.Player;

public class Battle {

	//start Match
	public static void startMatch(Player playerA, Player playerB) {
		Launcher launcher = new Launcher();
		List<String> missilesOfPlayer1 = playerA.getTargetList();
		List<String> missilesOfPlayer2 = playerB.getTargetList();

		while (!missilesOfPlayer1.isEmpty() || !missilesOfPlayer2.isEmpty()) {
			initiateAttack(playerA, playerB, missilesOfPlayer1, launcher);
			initiateAttack(playerB, playerA, missilesOfPlayer2, launcher);
			checkWinner(playerA, playerB);
		}
	}
	
	
	//launch Missiles
	private static void initiateAttack(Player source, Player dest, List<String> missilesOfSourcePlayer,
			Launcher launcher) {
		String missileOnPlayerShip = null;

		if (!missilesOfSourcePlayer.isEmpty()) {
			missileOnPlayerShip = missilesOfSourcePlayer.remove(0);
		} 
		while (launcher.launchMissiles(source, dest, missileOnPlayerShip)) {
			if (checkWinner(source, dest))
				System.exit(1);
			if (!missilesOfSourcePlayer.isEmpty())
				missileOnPlayerShip = missilesOfSourcePlayer.remove(0);
		}
	}

	// Check who is the winner
	private static boolean checkWinner(Player playerA, Player playerB) {
		boolean gameOver = false;
		if (playerA.getShips().isEmpty()) {
			System.out.println(playerB.getName() + " Won the Battle");
			gameOver = true;
		} else if (playerB.getShips().isEmpty()) {
			System.out.println(playerA.getName() + " Won the Battle");
			gameOver = true;
		} else if (playerA.getTargetList().isEmpty() && playerB.getTargetList().isEmpty()) {
			System.out.println("peace");
			gameOver = true;
		}
		return gameOver;
	}

}
