import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S3 {
	
	ArrayList<Integer> n = new ArrayList<Integer>();
	
	public static void main(String[] args)throws Exception {
		new S3();
	}
	
	S3()throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		
		int ans = 0;
		
		for(int i = 0; i < num; i++){
			int nu = Integer.parseInt(s[i]);
			if(!n.contains(nu)){
				n.add(nu);
				ans++;
			}
		}
		
		System.out.println(ans);
	}

}