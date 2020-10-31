import java.io.*;

public class S1 {
	
	public static void main(String[] args)throws Exception {
		new S1();
	}
	
	S1()throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		if(in[0].length() + in[1].length() != 10){
			System.out.println("invalid");
			return;
		}
		
		int area = Integer.parseInt(in[0]);
		
		if(area == 416){
			System.out.println("valuable");
			return;
		}
		
		if(area == 647 || area == 437){
			System.out.println("valueless");
			return;
		}
		
		System.out.println("invalid");
	}

}
