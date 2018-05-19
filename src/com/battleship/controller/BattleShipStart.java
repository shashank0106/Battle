package com.battleship.controller;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.battleship.Handler.ShipHandler;
import com.battleship.domain.GameBoard;
import com.battleship.domain.Player;
import com.battleship.domain.Position;
import com.battleship.domain.Ship;
import com.battleship.domain.ShipSize;
import com.battleship.utils.BattleShipConstants;
import com.battleship.validator.GameBoardValidator;
import com.battleship.validator.IValidator;
import com.battleship.validator.ShipTypeValidator;

/*
 * This class is Reads from File and start Battle 
 */
public class BattleShipStart {

	public static void main(String args[]) {
		Scanner scanner = null;
		Ship shipA = null, shipB = null;
		String type = null, locShipA = null, locShipB = null;
		String[] inputs = null;
		ShipSize shipSize;
		IValidator iValidator = null;
		BattleShipStart startBattle;
		Player playerA = new Player();
		Player playerB = new Player();
		Position player1ShipPosition, player2ShipPosition;
		playerA.setName("Player-1");
		playerB.setName("Player-2");
		List<Ship> shipListPlayerA = new ArrayList<>();
		List<Ship> shipListPlayerB = new ArrayList<>();
		try {
			scanner = new Scanner(new File("test.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		String line = scanner.nextLine();
		String[] width_height = line.split("\\s");
		GameBoard gameBoard = GameBoard.getInstance(new Position(width_height[0], width_height[1]));
		iValidator = new GameBoardValidator();
		if (!iValidator.validate(gameBoard)) {
			scanner.close();
			System.err.println("Invalid GameBoard Configuration");
			return;
		}
		int noOfShips = Integer.valueOf(scanner.nextLine());
		iValidator = new ShipTypeValidator();
		for (int i = 0; i < noOfShips; i++) {
			shipA = new Ship();
			shipB = new Ship();
			String line3 = scanner.nextLine();
			String[] tokens_line3 = line3.split("\\s");
			type = tokens_line3[0];
			if (iValidator.validate(type)) {
				shipA.setType(type);
				shipB.setType(type);
			} else {
				scanner.close();
				System.err.println("Invalid ShipType");
				return;
			}

			shipSize = new ShipSize();
			shipSize.setWidth(Integer.parseInt(tokens_line3[1]));
			shipSize.setHeight(Integer.parseInt(tokens_line3[2]));
			shipA.setSize(shipSize);
			shipB.setSize(shipSize);
			locShipA = tokens_line3[3];
			locShipB = tokens_line3[4];
			if (locShipA == null || locShipA.isEmpty() || locShipB == null || locShipB.isEmpty()) {
				scanner.close();
				System.err.println("location should not be empty");
				return;
			}
			try {
				player1ShipPosition = new Position(String.valueOf(locShipA.charAt(0)), locShipA.substring(1));
				ShipHandler.setAreaCovered(player1ShipPosition, shipSize, shipA, gameBoard);
				player2ShipPosition = new Position(String.valueOf(locShipB.charAt(0)), locShipB.substring(1));
				ShipHandler.setAreaCovered(player2ShipPosition, shipSize, shipB, gameBoard);
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			shipListPlayerA.add(shipA);
			shipListPlayerB.add(shipB);
		}
		// scanner.nextLine();
		playerA.setShips(shipListPlayerA);
		playerB.setShips(shipListPlayerB);
		String line4 = scanner.nextLine();
		String[] tokens_line4 = line4.split("\\s");
		playerA.setTargetList(new ArrayList<String>(Arrays.asList(tokens_line4)));
		String line5 = scanner.nextLine();
		String[] tokens_line5 = line5.split("\\s");
		playerB.setTargetList(new ArrayList<String>(Arrays.asList(tokens_line5)));
		scanner.close();

		// start playing...
		Battle.startMatch(playerA, playerB);

	}

}
