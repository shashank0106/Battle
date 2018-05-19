package com.battleship.domain;

public class Position {

	private String X;
	private String Y;

	public String getX() {
		return X;
	}

	public void setX(String x) {
		X = x;
	}

	public String getY() {
		return Y;
	}

	public void setY(String y) {
		Y = y;
	}

	public String getPosition() {
		return Y + X;
	}

	public Position(String y, String x) {
		super();
		X = x;
		Y = y;
	}
}
