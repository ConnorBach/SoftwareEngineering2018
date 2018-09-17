package edu.nd.se2018.homework.homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	ImageView shipImageView;
	Scene scene;
	Ship ship;
	Map<PirateShip, ImageView> m;
	List<PirateShip> pShips;
	List<ImageView> pShipImageViews;
	int scalingFactor = 30;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		Pane p = new AnchorPane();
		scene = new Scene(p, 750, 750);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean Game");
		oceanStage.show();
		startSailing();
		
		OceanMap oceanMap = new OceanMap();
		
		oceanMap.drawMap(p.getChildren(), scalingFactor);
		oceanMap.placeIslands(p.getChildren(), scalingFactor, 10);
		
		// add ship
		ship = new Ship(oceanMap);
		Image shipImage = new Image("images/ColumbusShip.png", 30, 30, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getPos().x * scalingFactor);
		shipImageView.setY(ship.getPos().y * scalingFactor);
		p.getChildren().add(shipImageView);
		
		
		// add pirate ships
		PirateShip p1 = new PirateShip(oceanMap, 10, 10);
		Image p1Image = new Image("images/pirateship.gif", 30, 30, true, true);
		ImageView p1ImageView = new ImageView(p1Image);
		p1ImageView.setX(p1.getPos().x * scalingFactor);
		p1ImageView.setY(p1.getPos().y * scalingFactor);
		p.getChildren().add(p1ImageView);
		
		PirateShip p2 = new PirateShip(oceanMap, 20, 20);
		Image p2Image = new Image("images/pirateship.gif", 30, 30, true, true);
		ImageView p2ImageView = new ImageView(p1Image);
		p2ImageView.setX(p2.getPos().x * scalingFactor);
		p2ImageView.setY(p2.getPos().y * scalingFactor);
		p.getChildren().add(p2ImageView);
		
		pShips = new ArrayList<>();
		pShipImageViews = new ArrayList<>();
		
		m = new HashMap<>();
		m.put(p1, p1ImageView);
		m.put(p2, p2ImageView);
		
		for(PirateShip cur : m.keySet())
			ship.addObserver(cur);
	}
	
	public void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				System.out.println(ship.getPos().x);
				System.out.println(ship.getPos().y);
				shipImageView.setX(ship.getPos().x*scalingFactor);
				shipImageView.setY(ship.getPos().y*scalingFactor);
				
				for(PirateShip cur : m.keySet()) {
					ImageView curImageView = m.get(cur);
					curImageView.setX(cur.getPos().x*scalingFactor);
					curImageView.setY(cur.getPos().y*scalingFactor);
				}	
			}
		});
	}
}
