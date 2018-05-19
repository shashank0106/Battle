package com.battleship.Handler;

import java.util.ArrayList;
import java.util.List;

import com.battleship.domain.GameBoard;
import com.battleship.domain.Position;
import com.battleship.domain.Ship;
import com.battleship.domain.ShipSize;

public class ShipHandler {

	public static void setAreaCovered(Position pos, ShipSize size, Ship ship, GameBoard gameBoard) {
		List<Position> positions = new ArrayList<>();
		positions.add(pos);
		int width = size.getWidth();
		int height = size.getHeight();
		int X = Integer.valueOf(pos.getX());
		int Y = (int) pos.getY().charAt(0);
		for (int i = 1; i < width; i++) {
			X = X + 1;
			if (X > Integer.parseInt(gameBoard.getCoordinate().getY()))
				throw new RuntimeException("Could not be located on gameboard");
			positions.add(new Position(pos.getY(), String.valueOf(X)));
		}
		for (int j = 1; j < height; j++) {
			Y = Y + 1;
			if (Y > gameBoard.getCoordinate().getX().charAt(0))
				throw new RuntimeException("Could not be located on gameboard");
			char c = (char) Y;
			positions.add(new Position(String.valueOf(c), String.valueOf(X)));
		}
		ship.setPositions(positions);
	}

}
