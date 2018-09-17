package edu.nd.se2018.homework.homework4;

import java.awt.Point;
import java.util.Observable;

public class Ship extends Observable {
	private Point pos;
	private Integer[][] map;
	
	public Ship(OceanMap map) {
		pos = new Point();
		this.map = map.map;
		pos.x = 5;
		pos.y = 5;
	}
	
	public Point getPos() {
		return pos;
	}

	public void goEast() {
		// TODO Auto-generated method stub
		if(pos.x < 24 && map[pos.x+1][pos.y] == 0) pos.x += 1;
		update();
	}
	
	public void goWest() {
		// TODO Auto-generated method stub
		if(pos.x > 0 && map[pos.x-1][pos.y] == 0) pos.x -= 1;
		update();
	}
	public void goNorth() {
		// TODO Auto-generated method stub
		if(pos.y > 0 && map[pos.x][pos.y-1] == 0) pos.y -= 1;
		update();
	}
	public void goSouth() {
		// TODO Auto-generated method stub
		if(pos.y < 24 && map[pos.x][pos.y+1] == 0) pos.y += 1;
		update();
	}
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}
