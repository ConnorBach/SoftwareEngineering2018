package edu.nd.se2018.homework.homework6;

import java.awt.Point;

import edu.nd.se2018.homework.homework4.PirateShip;
import edu.nd.se2018.homework.homework4.Ship;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class ChipsChallenge extends Application {
	Pane p;
	Scene scene;
	int scalingFactor = 30;
	Chip chip;
	ChipMap chipMap;
	Image chipImage;
	ImageView chipImageView;
	Image portalImage;
	ImageView portalImageView;
	int level = 1;
	Point level1Portal = new Point(10, 20);
	Point level2Portal = new Point(24, 24);
	Point itemPos;
	ImageView itemImg;
	GraphicsContext gc;
	
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
		chipMap = new ChipMap();
		chipMap.drawMap(p.getChildren(), scalingFactor);
		chipMap.placeWalls(p.getChildren(), scalingFactor, 10);
		itemImg = chipMap.placeItem(p.getChildren(), scalingFactor);
		itemPos = new Point();
		itemPos.setLocation(itemImg.getX()/scalingFactor, itemImg.getY()/scalingFactor);
		System.out.println(itemPos);
		
		// add end point for level
		portalImageView = new ImageView("images/chip/textures/portal.png");
		p.getChildren().add(portalImageView);
		if(level == 1) {
			level1Portal = chipMap.placeWalls(p.getChildren(), scalingFactor, 10);
			drawPortal(level1Portal);
			System.out.println(level1Portal);
		} else {
			drawPortal(level2Portal);
		}
		
		// add chip
		chip = new Chip(chipMap);
		chipImageView = new ImageView("images/chip/textures/chipDown.png");
		p.getChildren().add(chipImageView);
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
				case ESCAPE:
					Platform.exit();
					break;
				default:
					break;
				}
				Point cur = chip.getPos();
				// check for portals
				if(cur.equals(level1Portal) && level == 1) {
					// level 2
					System.out.println("on portal");
					level = 2;
					//chipMap.drawMap(p.getChildren(), scalingFactor);
					level2Portal = chipMap.placeWalls(p.getChildren(), scalingFactor, 10);
					drawPortal(level2Portal);
					if(chip.getHasItem()) {
						chipMap.updateColor(p.getChildren(), scalingFactor);
					}
					chip.setPos(new Point(5, 5));
					chipImageView.setX(5 * scalingFactor);
					chipImageView.setY(5 * scalingFactor);	
					return;
				}
				if(cur.equals(level2Portal) && level == 2) {
					// end game
					Platform.exit();
				}
				
				// check for item
				if(cur.equals(itemPos)) {
					System.out.println("on item");
					chip.setItem(true);
					p.getChildren().remove(itemImg);
					chipMap.updateColor(p.getChildren(), scalingFactor);
				}
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
	}
	
	public void drawPortal(Point portal) {
		portalImage = new Image("images/chip/textures/portal.png", 30, 30, true, true);
		portalImageView.setImage(portalImage);
		portalImageView.setX(portal.getX() * scalingFactor);
		portalImageView.setY(portal.getY() * scalingFactor);
	}
}