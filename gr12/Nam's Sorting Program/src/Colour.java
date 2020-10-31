
public class Colour implements Comparable{
	
	//class variables
	float hue, saturation, brightness;//colour values
	
	//constructor
	public Colour(float h, float s, float b){
		//set the values
		hue = h;
		saturation = s;
		brightness = b;
	}//end constructor
	
	//get method
	public float getHue(){
		return hue;
	}//end getHue()

	//for comparing it to other colours
	public int compareTo(Object c) {
		
		//if object is not a Colour exit
		if(!(c instanceof Colour)){
			System.out.println("Not a colour!!!");
			System.exit(0);
		}
		
		//cast the object to Colour
		Colour col = (Colour)c;
		
		//if value is bigger
		if(hue > col.getHue()){
			return 1;
		}
		
		//if values are equal
		if(hue == col.getHue()){
			return 0;
		}
		
		//value is smaller
		return -1;
		
	}
}//end class
