package edu.nd.se2018.homework.homework4;

import java.awt.Point;

public class Ship {
	private Point pos;
	
	public Ship() {
		pos = new Point();
		pos.x = 10;
		pos.y = 10;
	}
	
	public Point getPos() {
		return pos;
	}

	public void goEast() {
		// TODO Auto-generated method stub
		pos.x += 1;
	}
	
	public void goWest() {
		// TODO Auto-generated method stub
		pos.x -= 1;
		
	}
	public void goNorth() {
		// TODO Auto-generated method stub
		pos.y -= 1;
	}
	public void goSouth() {
		// TODO Auto-generated method stub
		pos.y += 1;
	}
}
