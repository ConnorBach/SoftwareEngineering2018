package edu.nd.se2018.homework.homework4;

import javax.xml.soap.Node;

import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class OceanMap {
	Integer[][] map = new Integer[25][25];
	final int dimensions = 25;
	
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
