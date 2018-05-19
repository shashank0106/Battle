package com.battleship.controller;

import java.util.HashMap;
import java.util.List;

import com.battleship.domain.Player;
import com.battleship.domain.Position;
import com.battleship.domain.Ship;
import com.battleship.utils.BattleShipConstants;

public class Launcher {

	private HashMap<String, Integer> hashMap = new HashMap<>();

	//launch Missiles
	public boolean launchMissiles(Player source, Player target, String missile) {
		boolean targetHitSuccessfully = false;
		List<Ship> ships = target.getShips();
		List<Position> positions;
		Ship hitShip = null;
		
		if (missile == null) {
			System.out.println(source.getName() + " has no more missiles left to launch");
			return targetHitSuccessfully;
		}
		
		for (Ship ship : ships) {
			positions = ship.getPositions();
			for (Position pos : positions) {
				String x_y = pos.getPosition();
				targetHitSuccessfully = x_y.equals(missile) ? true : false;
				if (targetHitSuccessfully) {
					hitShip = ship;
					break;
				}
			}
			if (targetHitSuccessfully)
				break;
		}

		
		if (targetHitSuccessfully) {
			System.out.println(source.getName() + " fires a missile with target " + missile + " which got hit");
			removeShipPosition(target, missile);
		} else {
			System.out.println(source.getName() + " fires a missile with target " + missile + " which got miss");
		}
		return targetHitSuccessfully;
	}

	// Removal of the hitPosition
		public void removeShipPosition(Player target, String missile){
			List<Ship> ships = target.getShips();
			List<Position> positions = null;
			boolean found = false;
			Ship ship = null;
			Position position = null;
			int shipIndexForPositionRemoval = -1;
			for (Ship ship1 : ships) {
				positions = ship1.getPositions();
				shipIndexForPositionRemoval++;
				for (Position pos : positions) {
					String x_y = pos.getPosition();
					if (x_y.equals(missile)) {
						found = true;
						ship = ship1;
						position = pos;
						break;
					}
				}
				//Before deletion position check which type of Ship it is
				if (found) {
					if (BattleShipConstants.SHIP_TYPE_Q.equals(ship.getType())) {
						Integer count = hashMap.get(missile);
						if (count != null) {
							int currentCounter = count - 1;
							if (currentCounter == 0) {
								hashMap.remove(missile);
								positions.remove(position);
							}
							hashMap.put(missile, count);
						} else {
							hashMap.put(missile, 1);
						}
					} else {
						positions.remove(position);
					}
					break;
				}
			}
			
			//checking if all positions of a ship are hit and to blast out the ship
			if (positions.isEmpty())
				target.getShips().remove(ship);

		}
	
}
