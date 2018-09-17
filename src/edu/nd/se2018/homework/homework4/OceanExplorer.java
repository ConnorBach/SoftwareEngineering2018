package edu.nd.se2018.homework.homework4;

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
	int scalingFactor = 50;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		// TODO Auto-generated method stub
		Pane p = new AnchorPane();
		scene = new Scene(p, 500, 500);
		oceanStage.setScene(scene);
		oceanStage.setTitle("Ocean Game");
		oceanStage.show();
		startSailing();
		
		OceanMap oceanMap = new OceanMap();
		
		oceanMap.drawMap(p.getChildren(), scalingFactor);
		
		// add ship
		ship = new Ship();
		Image shipImage = new Image("images/ColumbusShip.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(ship.getPos().x * scalingFactor);
		shipImageView.setX(ship.getPos().y * scalingFactor);
		p.getChildren().add(shipImageView);
		
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
				shipImageView.setX(ship.getPos().x*scalingFactor);
				shipImageView.setY(ship.getPos().y*scalingFactor);
			}
		});
	}
}
