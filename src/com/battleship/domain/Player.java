package com.battleship.domain;

import java.util.List;

public class Player {

	@Override
	public String toString() {
		return "Player [name=" + name + ", ships=" + ships + ", targetList=" + targetList + "]";
	}

	private String name;
	private List<Ship> ships;
	private List<String> targetList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public List<String> getTargetList() {
		return targetList;
	}

	public void setTargetList(List<String> targetList) {
		this.targetList = targetList;
	}
	
}
