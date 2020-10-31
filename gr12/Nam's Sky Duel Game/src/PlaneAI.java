import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class PlaneAI extends Plane{

	boolean dir;
	Plane targetPlane;
	boolean follow = true;
	int timer = 0;
	
	PlaneAI(int xLocation, int yLocation, double speed, double direction,Level level) {
		super(xLocation, yLocation, speed, direction, level);
		
		try {//loading images
			sprite = plane = ImageIO.read(new File("bin/warplane2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		turningRate = 130;
		//level.addMouseMotionListener(new Mouse());
	}

	public void update(){
		updatePlane();
		
		updateDirection();
	}
	
	public void updateDirection(){
		//getting all planes in the level
		ArrayList<Plane> p = level.getPlanes();
		
		//checking which plane is the closest to this plane
		for(Plane plane: p){
			if(plane.equals(this)){
				continue;
			}
			if(targetPlane == null)targetPlane = plane;
			
			if(!targetPlane.equals(this) && distanceTo(plane)<distanceTo(targetPlane)){
				targetPlane = plane;
			}
		}
		
		//finding the angle to the target plane
		double xd = targetPlane.getX()-x;
		double yd = targetPlane.getY()-y;
		double angle = Math.toDegrees(Math.atan(-yd/xd));
		
		if(xd >= 0){
			if(yd<=0){
				//angle remains the same
			}else{
				angle += 360;
			}
		}
		else{
			if(yd<=0){
				angle += 180;
			}else{
				angle += 180;
			}
		}
		
		//making sure the direction of this plane is between 0-360
		direction = (direction + 360)%360;
		
		//finding the smallest angle between the two angles
		double difference = Math.abs(direction - angle)%360;
		
		if(difference > 180){//getting the smallest angle between 2 directions
			difference = 360 - difference%360;
		}
		System.out.println("difference- "+(int)difference+"\n"
							+"angle- "+(int)angle+"\n"
							+"dir- "+(int)direction+"\n");
		
		//checking which way to turn
		if(follow){
			if(Math.abs(angle-(direction + difference)%360) < Math.abs(angle-(direction - difference+360)%360)){
				System.out.println("up");
				direction+=turningRate/updates;
			}else{
				System.out.println("down");//direction -= turningRate/updates;
				direction-=turningRate/updates;
			}
		}
		else{
			if(dir)direction+=.4;
			else direction-=.4;
		}
		
		if(distanceTo(targetPlane) < 100){
			follow = false;
			timer = (int)(updates*1.1);//2 seconds
		}
		
		if(timer > 0){
			timer--;
		}
		else if(timer < 1){
			dir = !dir;
			follow = true;
		}
	}
	
	
	public double distanceTo(Plane p){
		return (p.getX() - x)*(p.getX() - x)+(p.getY() - y)*(p.getY() - y);
	}
	
	class Mouse implements MouseMotionListener{

	

		public void mouseDragged(MouseEvent e) {
			direction++;
		}

		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			targetPlane.setX(e.getX());
			targetPlane.setY(e.getY());
		}
		
	}
}
