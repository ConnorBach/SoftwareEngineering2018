package edu.nd.se2018.homework.homework4;

import java.util.Random;

import javax.xml.soap.Node;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	Integer[][] map = new Integer[25][25];
	final int dimensions = 25;
	
	public void placeIslands(ObservableList<javafx.scene.Node> root, int scale, int numberIslands) {
		for(int i = 0; i < numberIslands; i++) {
			Random r = new Random();
			int X = r.nextInt(23) + 1;
			int Y = r.nextInt(23) + 1;
			
			while(map[X][Y] != 0) {
				X = r.nextInt(23) + 1;
				Y = r.nextInt(23) + 1;
			}
			
			Rectangle rec = new Rectangle(X*scale, Y*scale, scale, scale);
			rec.setStroke(Color.BLACK);
			rec.setFill(Color.GREEN);
			root.add(rec);
			map[X][Y] = 1;
		}
	}
	
	public void drawMap(ObservableList<javafx.scene.Node> observableList, int scale) {
		for(int i = 0; i < dimensions; i++) {
			for(int j = 0; j < dimensions; j++) {
				Rectangle r = new Rectangle(i*scale, j*scale, scale, scale);
				r.setStroke(Color.BLACK);
				r.setFill(Color.PALETURQUOISE);
				observableList.add(r);
				map[i][j] = 0;
			}
		}
	}
	
}
