
public class PhysicsCalc {

	public static void main(String[] args) {
		double mu = .1;
		int m = 1;
		int f = 10;
		double g = -9.8;
		
		float biggest = 0;
		int index = 0;
		
		for(int i = 0; i < 90; i++){
			
			double fx = f*Math.cos(Math.toRadians(i));
			double fy = f*Math.sin(Math.toRadians(i));
			float a = (float)(fx + mu*fy + mu*m*g);
			
			System.out.println("");
			System.out.println("fx: "+fx);
			System.out.println("fy: "+fy);
			System.out.println("angle: "+ i+" force on x="+a);
			
			if(a > biggest){
				biggest = a;
				index = i;
			}
			
		}

		System.out.print("the biggest f: "+biggest+" at angle: "+index);
		
	}

}
