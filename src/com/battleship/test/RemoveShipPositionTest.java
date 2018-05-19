package com.battleship.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.battleship.Handler.ShipHandler;
import com.battleship.controller.Launcher;
import com.battleship.domain.GameBoard;
import com.battleship.domain.Player;
import com.battleship.domain.Position;
import com.battleship.domain.Ship;
import com.battleship.domain.ShipSize;
import com.battleship.exceptions.BattleshipException;
import com.battleship.utils.BattleShipConstants;

/*
 * Test for RemoveShipPosition
 * @explanation: Since PlayerA has only ship which has width and height 1 and of type 'P', so it required only one hit to destroy that ship
 * After removeShipPosition, it remove that position from ship
 */
public class RemoveShipPositionTest {
	Launcher launcher;
	Player playerA;
	List<Ship> shipListPlayerA;
	Ship shipOfPlayerA;
	ShipSize shipSize;
	Position posOfShipA;
	GameBoard gameBoard;

	@Test
	public void testthatRemovalOfShipMethod() {
		launcher = new Launcher();
		gameBoard = GameBoard.getInstance(new Position("E", "5"));
		playerA = new Player();
		shipListPlayerA = new ArrayList<>();
		shipOfPlayerA = new Ship();
		shipSize = new ShipSize();
		shipSize.setHeight(1);
		shipSize.setWidth(1);
		shipOfPlayerA.setType(BattleShipConstants.SHIP_TYPE_P);
		shipOfPlayerA.setSize(shipSize);
		posOfShipA = new Position("A", "1");
		ShipHandler.setAreaCovered(posOfShipA, shipSize, shipOfPlayerA, gameBoard);
		shipListPlayerA.add(shipOfPlayerA);
		playerA.setShips(shipListPlayerA);

		launcher.removeShipPosition(playerA, "A1");

		Assert.assertEquals(true, shipOfPlayerA.getPositions().isEmpty());

	}

}
