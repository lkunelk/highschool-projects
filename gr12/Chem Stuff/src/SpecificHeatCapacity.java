/*
 * for checking my chem answers from the lab on finding specififc heat cpacity
 * by using calorimetry
 * date: 11/feb/2015
 */

public class SpecificHeatCapacity {

	double actualC = 0.385;
	
	double tBoiling = 95;
	double tInitial = 20;
	double tFinal = 25;
	
	//metal
	double mMetal = 39.6;
	double tMetal = tFinal - tBoiling;
	
	//cup
	double mCup = 7.1;
	double cCup = 1.3;
	double tCup = tFinal - tInitial;
	
	//water
	double mWater = 54;
	double cWater = 4.186;
	double tWater = tFinal - tInitial;
	
	public static void main(String[] args) {
		new SpecificHeatCapacity();
	}

	SpecificHeatCapacity(){
		double qMetal = mMetal*tMetal;
		double qCup = mCup*tCup*cCup;
		double qWater = mWater*tWater*cWater;
		
		double C = (-(qCup+qWater)/qMetal);
		
		System.out.println("qMetal "+qMetal);
		System.out.println("qCup "+qCup);
		System.out.println("qWater "+qWater);
		System.out.println("the specific heat cap is = "+C);
		System.out.println("percent error = "+( ((actualC - C) / actualC)*100 )+"%") ;
	}
}
