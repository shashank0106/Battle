package com.battleship.validator;

import java.util.ArrayList;

import com.battleship.domain.GameBoard;
import com.battleship.utils.BattleShipConstants;

public class ShipTypeValidator implements IValidator {

	@Override
	public boolean validate(Object objectToBeValidated) {
		// TODO Auto-generated method stub
		String type = null;
		boolean validShipType = false;
		if (objectToBeValidated instanceof String) {
			type = (String) objectToBeValidated;
			if (BattleShipConstants.SHIP_TYPE_P.equalsIgnoreCase(type) || BattleShipConstants.SHIP_TYPE_Q.equalsIgnoreCase(type))
				validShipType = true;
		}
		return validShipType;
	}

}
