
public class MathRecursion {

	public static void main(String[] args) {
		new MathRecursion();
	}

	MathRecursion(){
		System.out.print(("ham").substring(3));
	}
	
	public int factorial(int n){
		if(n == 1){
			return 1;
		}
		else{
			return n*factorial(n-1);
		}
	}
	
	public int sum(int n){
		if(n == 4){
			return 2;
		}
		else{
			return n-2 + sum(n-2);
		}
	}
	
	public int t(int term){
		if (term < 1){
			throw new RuntimeException("Invalid parameter");
		}
		else if(term == 1)
			return 2;
		else{
			return 3*t(term-1)+1;
		}
	}
	
	public int gcd(int a, int b){
		if(a == b){
			System.out.println("= "+a+" by rule 1");
			return a;
		}
		
		if(a > b){
			System.out.println("= gcd("+b+","+(a-b)+") by rule 2");
			return gcd(b, a-b);
		}
		
		if(a < b){
			System.out.println("= gcd("+b+","+a+") by rule 3");
			return gcd(b, a);
		}
		
		return -1;
	}
	
	public String reverse(String word){
		if(word.length() == 0)
		return word;
		else
		return reverse(word.substring(1)) + word.charAt(0);
	}
	
	/*
	public String reverse(String word){
		if(word.length() > 0)
		return (word.charAt(word.length()-1)+reverse(word.substring(0,word.length()-1)));
		else
		return "";
	}*/
}
