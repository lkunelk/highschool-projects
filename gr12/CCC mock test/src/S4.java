import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S4 {
	
	char[][] box;
	int symmetry, w, odd;
	
	public static void main(String[] args)throws Exception {
		new S4();
	}
	
	S4()throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		w = Integer.parseInt(br.readLine());
		if(w%2 == 1){
			odd = 1;
		}
		box = new char[w][w];
		
		//readin box
		for(int y = 0; y < w; y++){
			
			String in = br.readLine();
			
			for(int x = 0; x < w; x++){
				box[x][y] = in.charAt(x);
			}
		}
		
		checkH();
		checkV();
		checkRL();
		checkLR();
		
		System.out.println(symmetry);
	}

	public void checkLR(){

		int l = w-1;
		
		for(int y = 0; y < w; y++){
			for(int x = y; x < w; x++){
				
				char l1 = box[x][y];
				char l2 = box[y][x];
				
				//System.out.println("l1 "+x+", "+(w/2-1-y));
				//System.out.println("l2 "+x+", "+(w/2+y));
				//System.out.println(l1+" = "+l2);
				
				if(l1 != l2 || (l1=='('||l1==')') || (l2=='('||l2==')')){
					//System.out.println("RL bad");
					return;
				}
			}
		}
		
		//System.out.println("RL good");
		symmetry++;
	}
	
	public void checkRL(){
		
		int l = w-1;
		
		for(int y = 0; y < l; y++){
			for(int x = l-y; x >= 0; x--){
				
				char l1 = box[x][y];
				char l2 = box[l-y][l-x];
				
				//System.out.println("l1 "+x+", "+(w/2-1-y));
				//System.out.println("l2 "+x+", "+(w/2+y));
				//System.out.println(l1+" = "+l2);
				
				if(l1 != l2 || (l1=='('||l1==')') || (l2=='('||l2==')')){
					//System.out.println("RL bad");
					return;
				}
			}
		}
		
		//System.out.println("RL good");
		symmetry++;
	}
	
	public void checkV(){
		//for each line
		for(int x = 0; x < w/2; x++){
			for(int y = 0; y < w; y++){
				
				char l1 = box[w/2-1-x][y];
				char l2 = box[w/2+x+odd][y];
				
				//System.out.println("l1 "+x+", "+(w/2-1-y));
				//System.out.println("l2 "+x+", "+(w/2+y));
				//System.out.println(l1+" = "+l2);
				
				if(l1 != l2 && 
						!( (l1 == '\\' && l2 == '/')||(l1 == '/' && l2 == '\\') ) 
							&& 
						!( (l1 == ')' && l2 == '(')||(l1 == '(' && l2 == ')') )){
					//System.out.println("vert bad");
					return;
				}
			}
		}
		
		//System.out.println("vert good");
		symmetry++;
	}
	
	public void checkH(){
		
		//for each line
		for(int y = 0; y < w/2; y++){
			for(int x = 0; x < w; x++){
				
				char l1 = box[x][w/2-1-y];
				char l2 = box[x][w/2+y+odd];
				
				if(l1 != l2 && !( (l1 == '\\' && l2 == '/')||(l1 == '/' && l2 == '\\') )){
					//System.out.println("horiz bad");
					return;
				}
			}
		}
		
		//System.out.println("horiz good");
		symmetry++;
	}
}