import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S5 {
	
	boolean[][] b = new boolean[5000][5000];
	int x, y;
	long ans;
	
	public static void main(String[] args)throws Exception {
		new S5();
	}
	
	S5()throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		String[] s = null;
		
		for(int i = 0; i < num; i++){
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int c = Integer.parseInt(s[1]);
			b[a][c] = true;
		}
		
		//printMap();
		
		num = Integer.parseInt(br.readLine())-1;
		
		s = br.readLine().split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		
		for(int i = 0; i < num; i++){
			
			s = br.readLine().split(" ");
			int xf = Integer.parseInt(s[0]);
			int yf = Integer.parseInt(s[1]);
			//System.out.println("Im at: "+x+", "+y);
			//System.out.println("going to: "+xf+", "+yf);
			
			if(x == xf){
				if(y > yf){
					for(;y >= yf; y--){
						if(b[x][y]){
							//ystem.out.println(x+", "+y);
							ans++;
							
						}
					}
					y++;
				}
				else{
					for(;y <= yf; y++){
						if(b[x][y]){
							ans++;
							
							//System.out.println(x+", "+y);
						}
					}
					y--;
				}
			}else{
				if(x > xf){
					for(;x >= xf; x--){
						if(b[x][y]){
							ans++;
							
							//System.out.println(x+", "+y);
						}
					}
					x++;
				}else{
					for(;x <= xf; x++){
						if(b[x][y]){
							ans++;
							
							//System.out.println(x+", "+y);
						}
					}
					x--;
				}
			}
			
		}//end for loop
		
		System.out.println(ans);
	}

	
	public void printMap(){
		System.out.println("");
		for(int y = 0; y<b.length;y++){
			for(int x = 0; x<b.length;x++){
				if(b[x][y])System.out.print("O");
				else System.out.print("*");
			}
			System.out.println("");
		}
	}
}