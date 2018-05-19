package com.battleship.domain;

public class GameBoard {
	private Position coordinate;
	private static GameBoard gameBoard;

	private GameBoard(Position coordinate) {
		this.coordinate = coordinate;
	}

	public Position getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Position coordinate) {
		this.coordinate = coordinate;
	}

	public static GameBoard getInstance(Position coordinate) {
		if (gameBoard == null)
			return new GameBoard(coordinate);

		return gameBoard;
	}

}
