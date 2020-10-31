import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


public class Rotation {

	double x, y;
	
	public static void main(String[] args) {
		new Rotation();
	}
	
	Rotation(){
		DecimalFormat f = new DecimalFormat("#0.000000");
    	f.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.ENGLISH));
    	
    	x = 72072.373558 ;
    	y = -55521.798455 ;
    	r(-175);
    	
    	System.out.println(f.format(x)+" "+f.format(y));
	}
	
	public void r(int angle){
		double ox = x;
    	double oy = y;
    	double a = Math.toRadians(angle);
    	
    	
    	x = Math.cos(a)*ox - Math.sin(a)*oy;
    	y = Math.sin(a)*ox + Math.cos(a)*oy;
	}
}
