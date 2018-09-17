package edu.nd.se2018.homework.homework4;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

public class PirateShip implements Observer {
	private Point pos;
	private Integer[][] map;
	private Point shipPos;
	
	public PirateShip(OceanMap map, int x, int y) {
		pos = new Point();
		this.map = map.map;
		pos.x = x;
		pos.y = y;
	}
	
	public Point getPos() {
		return pos;
	}
	
	private void chase() {
		System.out.println("chase");
		if(pos.x - shipPos.x < 0 && pos.x+1 < 25 && map[pos.x+1][pos.y] == 0) {
			pos.x++;
		} else {
			if(pos.x-1 > 0 && map[pos.x-1][pos.y] == 0)
				pos.x--;
		}
		
		if(pos.y - shipPos.y < 0 && pos.y+1 < 25 && map[pos.x][pos.y+1] == 0) {
			pos.y++;
		} else {
			if(pos.y-1 > 0 && map[pos.x][pos.y-1] == 0)
				pos.y--;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update");
		if(o instanceof Ship) {
			shipPos = ((Ship)o).getPos();
			chase();
		}	
	}
}
