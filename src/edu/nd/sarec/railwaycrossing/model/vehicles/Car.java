package edu.nd.sarec.railwaycrossing.model.vehicles;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import edu.nd.sarec.railwaycrossing.model.infrastructure.gate.CrossingGate;
import edu.nd.sarec.railwaycrossing.view.CarImageSelector;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * Represents Car object
 * @author jane
 *
 */
public class Car extends Observable implements IVehicle, Observer{
	private ImageView ivCar;
	private double currentX = 0;
	private double currentY = 0;
	private double originalY = 0;
	private boolean gateDown = false;
	private double leadCarY = -1;  // Current Y position of car directly infront of this one
	private double leadCarX = -1;
	private double speed = 0.5;
	private double speedX = 0;
	private boolean madeDecision = false;
		
	/**
	 * Constructor
	 * @param x initial x coordinate of car
	 * @param y initial y coordinate of car
	 */
	public Car(int x, int y){
		this.currentX = x;
		this.currentY = y;
		originalY = y;
		ivCar = new ImageView(CarImageSelector.getImage());
		ivCar.setX(getVehicleX());
		ivCar.setY(getVehicleY());
		madeDecision = false;
	}
		
	@Override
	public Node getImageView() {
		return ivCar;
	}
	
	public boolean gateIsClosed(){
		return gateDown;
	}
	
	public double getVehicleX(){
		return currentX;
	}
	public double getVehicleY(){
		return currentY;
	}
	
	public void move(){
		boolean canMove = true; 
		
		// First case.  Car is at the front of the stopping line.
		if (gateDown && getVehicleY() < 430 && getVehicleY()> 390)
			canMove = false;
		
		// Second case. Car is too close too other car.
		if (leadCarY != -1  && getDistanceToLeadCar() < 50)
			canMove = false;

		// car is at connection road on east road
		int decision = 1;
		if(getVehicleY() > 690 && getVehicleY() < 695 && getVehicleX() > 600) {
			if(!madeDecision) {
				Random r = new Random();
				decision = r.nextInt(2);
				madeDecision = true;
				System.out.println(decision);
			}
			//System.out.println(madeDecision);
			//System.out.println(decision);
			if(decision == 0) {
				//switch roads
				//System.out.println("switching roads");
				speed = 0;
				speedX = 1;
				//removeLeadCar();
			}
		}
		
		// car is moving west
		if(speedX > 0 && leadCarX != -1 && getDistanceToLeadCarX() < 50)
			canMove = false;
		
		// car is at connection on west road
		if(speedX > 0 && getVehicleX() < 395) {
			speedX = 0;
			speed = 1;
		}
		
		if (canMove){
			currentY+=speed;
			currentX-=speedX;
			ivCar.setY(currentY);
			ivCar.setX(currentX);
			if(decision == 0)
				removeLeadCar();
		}
		
		
		setChanged();
		notifyObservers();
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
	}
	
	public void setGateDownFlag(boolean gateDown){
		this.gateDown = gateDown;
	}
	
	public boolean offScreen(){
		if (currentY > 1020)
			return true;
		else
			return false;			
	}
		
	public void reset(){
		currentY = originalY;
	}
	
	public double getDistanceToLeadCar(){
		return Math.abs(leadCarY-getVehicleY());
	}
	
	public double getDistanceToLeadCarX(){
		return Math.abs(leadCarX-getVehicleX());
	}
	
	public void removeLeadCar(){
		leadCarY = -1;
	}

	@Override
	public void update(Observable o, Object arg1) {
		if (o instanceof Car){
			leadCarY = (((Car)o).getVehicleY());
			leadCarX = (((Car)o).getVehicleX());

			if (leadCarY > 1020 || leadCarX != currentX)
				leadCarY = -1;
			
			if (leadCarX < 400 || leadCarY != currentY)
				leadCarX = -1;
		}
			
		if (o instanceof CrossingGate){
			CrossingGate gate = (CrossingGate)o;
			if(gate.getTrafficCommand()=="STOP")			
				gateDown = true;
			else
				gateDown = false;
					
		}				
	}	
}
