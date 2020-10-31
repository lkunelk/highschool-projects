
 import java.io.*;


public class EscapeThePlanet {
    
    public static void main(String[] args)throws Exception {

    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    Double circumference = Double.parseDouble(br.readLine());
   	Double accel= Double.parseDouble(br.readLine());


MyPlanet myPlanet = new MyPlanet();
myPlanet.Kunek(circumference, accel, br);

}
    
}