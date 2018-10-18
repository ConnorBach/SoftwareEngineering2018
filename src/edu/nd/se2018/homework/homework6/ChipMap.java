package edu.nd.se2018.homework.homework6;

import java.awt.Point;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class ChipMap {
	Integer[][] map = new Integer[25][25];
	final int dimensions = 25;
	Point end;
	
	private static ChipMap chipMap = new ChipMap();
	
	private ChipMap() {};
	
	public static ChipMap getInstance() {
		return chipMap;
	}
	
	public void drawMap(ObservableList<javafx.scene.Node> observableList, int scale) {
		for(int i = 0; i < dimensions; i++) {
			for(int j = 0; j < dimensions; j++) {
				Rectangle r = new Rectangle(i*scale, j*scale, scale, scale);
				r.setStroke(Color.BLACK);
				r.setFill(Color.GREY);
				observableList.add(r);
				map[i][j] = 0;
			}
		}
	}
	
	public Point placeWalls(ObservableList<javafx.scene.Node> root, int scale, int numberIslands) {
		for(int i = 0; i < numberIslands; i++) {
			Random r = new Random();
			int X = r.nextInt(23) + 1;
			int Y = r.nextInt(23) + 1;
			
			while(map[X][Y] != 0 && X != 5 && Y != 5) {
				X = r.nextInt(23) + 1;
				Y = r.nextInt(23) + 1;
			}
			
			Rectangle rec = new Rectangle(X*scale, Y*scale, scale, scale);
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.ORANGE);
			root.add(rec);
			map[X][Y] = 1;
		}
		
		// return portal position
		Random r = new Random();
		int pX = r.nextInt(23) + 1;
		int pY = r.nextInt(23) + 1;
		while(map[pX][pY] != 0) {
			pX = r.nextInt(23) + 1;
			pY = r.nextInt(23) + 1;
		}
		return new Point(pX, pY);
	}
	
	public ImageView placeItem(ObservableList<javafx.scene.Node> root, int scalingFactor) {
		// calc item pos
		Random r = new Random();
		int pX = r.nextInt(23) + 1;
		int pY = r.nextInt(23) + 1;
		while(map[pX][pY] != 0) {
			pX = r.nextInt(23) + 1;
			pY = r.nextInt(23) + 1;
		}
		
		// draw item
		ImageView blueKey = new ImageView("images/chip/textures/blueKey.png");
		blueKey.setX(pX*scalingFactor);
		blueKey.setY(pY*scalingFactor);
		root.add(blueKey);
		
		return blueKey;
	}
	
	public void updateColor(ObservableList<javafx.scene.Node> observableList, int scale) {
		observableList.forEach(item -> {
			if(item instanceof Rectangle && ((Shape) item).getFill() == Color.ORANGE) {
				((Shape) item).setFill(Color.PALETURQUOISE);
			}
		});
	}
}
