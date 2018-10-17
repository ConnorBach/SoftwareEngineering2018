package edu.nd.se2018.homework.homework6;

import java.awt.Point;
import java.util.Observable;

public class Chip extends Observable {
	private Point pos;
	private Integer[][] map;
	private boolean hasItem;
	
	public Chip(ChipMap map) {
		this.pos = new Point();
		this.map = map.map;
		pos.x = 5;
		pos.y = 5;
		hasItem = false;
	}
	
	public Point getPos() {
		return pos;
	}
	
	public void setPos(Point p) {
		pos.x = p.x;
		pos.y = p.y;
	}
	
	public boolean getHasItem() {
		return hasItem;
	}
	
	public void setItem(boolean i) {
		hasItem = i;
	}

	public void goEast() {
		// TODO Auto-generated method stub
		if(pos.x < 24 && map[pos.x+1][pos.y] == 0) pos.x += 1;
		else if(pos.x < 24 && hasItem) pos.x += 1;
		update();
	}
	
	public void goWest() {
		// TODO Auto-generated method stub
		if(pos.x > 0 && map[pos.x-1][pos.y] == 0) pos.x -= 1;
		else if(pos.x > 0 && hasItem) pos.x -= 1;
		update();
	}
	public void goNorth() {
		// TODO Auto-generated method stub
		if(pos.y > 0 && map[pos.x][pos.y-1] == 0) pos.y -= 1;
		else if(pos.y > 0 && hasItem) pos.y -= 1;
		update();
	}
	public void goSouth() {
		// TODO Auto-generated method stub
		if(pos.y < 24 && map[pos.x][pos.y+1] == 0) pos.y += 1;
		else if(pos.y < 24 && hasItem) pos.y += 1;
		update();
	}
	
	public void update() {
		setChanged();
		notifyObservers();
	}
}
