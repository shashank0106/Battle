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

public class LaunchMissileTest {
	Launcher launcher;
	Player playerA, playerB;
	List<Ship> shipListPlayerA, shipListPlayerB;
	Ship shipOfPlayerA, shipOfPlayerB;
	ShipSize shipSize;
	Position posOfShipA, posOfShipB;
	GameBoard gameBoard;

	@Test
	public void testThatLaunchMissiles() {
		launcher = new Launcher();
		// intialization of playerA starts
		gameBoard = GameBoard.getInstance(new Position("E", "5"));

		playerA = new Player();
		playerA.setName("PlayerA");
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
		// intialization of playerA completed

		// intialization of playerB starts
		playerB = new Player();
		shipListPlayerB = new ArrayList<>();
		shipOfPlayerB = new Ship();
		shipSize = new ShipSize();
		shipSize.setHeight(1);
		shipSize.setWidth(1);
		shipOfPlayerB.setType(BattleShipConstants.SHIP_TYPE_P);
		shipOfPlayerB.setSize(shipSize);
		posOfShipB = new Position("B", "1");
		ShipHandler.setAreaCovered(posOfShipB, shipSize, shipOfPlayerB, gameBoard);
		shipListPlayerB.add(shipOfPlayerB);
		playerB.setShips(shipListPlayerB);
		//// intialization of playerB ends

		launcher.launchMissiles(playerA, playerB, "B1");
		// it will hit the position and remove that position from the
		// shipOfPlayerB

		Assert.assertEquals(true, shipOfPlayerB.getPositions().isEmpty());

	}

}
