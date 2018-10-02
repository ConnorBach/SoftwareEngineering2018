package edu.nd.se2018.homework.homework6;

import java.awt.Point;

import edu.nd.se2018.homework.homework4.PirateShip;
import edu.nd.se2018.homework.homework4.Ship;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChipsChallenge extends Application {
	Pane p;
	Scene scene;
	int scalingFactor = 30;
	Chip chip;
	Image chipImage;
	ImageView chipImageView;
	
	public static void main(String args[]) { 
		Application.launch(args);
	}

	@Override
	public void start(Stage chipStage) throws Exception {
		// setup game
		p = new AnchorPane();
		scene = new Scene(p, 750, 750);
		chipStage.setScene(scene);
		chipStage.setTitle("Chip's Challenge");
		chipStage.show();
		startGame();
		
		// setup map
		ChipMap chipMap = new ChipMap();
		chipMap.drawMap(p.getChildren(), scalingFactor);
		
		// add chip
		chip = new Chip(chipMap);
		chipImageView = new ImageView("images/chip/textures/chipDown.png");
		updateChip("images/chip/textures/chipDown.png");
	}
	
	public void startGame() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch(e.getCode()) {
				case RIGHT:
					chip.goEast();
					updateChip("images/chip/textures/chipRight.png");
					break;
				case LEFT:
					chip.goWest();
					updateChip("images/chip/textures/chipLeft.png");
					break;
				case UP:
					chip.goNorth();
					updateChip("images/chip/textures/chipUp.png");
					break;
				case DOWN:
					chip.goSouth();
					updateChip("images/chip/textures/chipDown.png");
					break;
				default:
					break;
				}
				System.out.println(chip.getPos().x);
				System.out.println(chip.getPos().y);
				chipImageView.setX(chip.getPos().x*scalingFactor);
				chipImageView.setY(chip.getPos().y*scalingFactor);	
			}
		});
	}
	
	public void updateChip(String imgPath) {
		chipImage = new Image(imgPath, 30, 30, true, true);
		chipImageView.setImage(chipImage);
		chipImageView.setX(chip.getPos().x * scalingFactor);
		chipImageView.setY(chip.getPos().y * scalingFactor);
		p.getChildren().add(chipImageView);
	}
}