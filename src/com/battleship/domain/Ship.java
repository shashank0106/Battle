package com.battleship.domain;

import java.util.ArrayList;
import java.util.List;

public class Ship {

	private String type;
	private List<Position> positions;
	private ShipSize size;

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public ShipSize getSize() {
		return size;
	}

	public void setSize(ShipSize size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
