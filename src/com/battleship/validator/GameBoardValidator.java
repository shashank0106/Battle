package com.battleship.validator;

import java.lang.invoke.ConstantCallSite;

import com.battleship.domain.GameBoard;
import com.battleship.utils.BattleShipConstants;

public class GameBoardValidator implements IValidator {
	@Override
	public boolean validate(Object objectToBeValidated) {
		// TODO Auto-generated method stu
		GameBoard gameBoard = null;
		boolean validBoard = false;
		if (objectToBeValidated instanceof GameBoard) {
			gameBoard = (GameBoard) objectToBeValidated;
			if (((Integer.parseInt(gameBoard.getCoordinate().getY()) >= BattleShipConstants.BOARD_MIN_WIDTH)
					&& Integer.parseInt(gameBoard.getCoordinate().getY()) <= BattleShipConstants.BOARD_MAX_WIDTH)
					&& ((gameBoard.getCoordinate().getX().charAt(0) >= BattleShipConstants.BOARD_MIN_HEIGHT)
							&& gameBoard.getCoordinate().getX().charAt(0) <=BattleShipConstants.BOARD_MAX_HEIGHT)) {
				validBoard = true;
			} else {
				validBoard = false;
			}

		}
		return validBoard;
	}

}
