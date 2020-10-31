import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S2 {
	
	public static void main(String[] args)throws Exception {
		new S2();
	}
	
	S2()throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		double p = Double.parseDouble(br.readLine());
		double q = Double.parseDouble(br.readLine());
		double w = Double.parseDouble(br.readLine())/100;
		
		for(int i = 1; i <= 100; i++){
			if(Math.round((i*w+p*(1.0-w))) >= q){
				System.out.println(i);
				return;
			}
		}
		
		System.out.println("DROP THE COURSE");
	}

}