package qBoT;

import java.util.Arrays;
import java.util.List;

public enum Moves
{
	U,Ui,U2,D,Di,D2,F,Fi,F2,B,Bi,B2,R,Ri,R2,L,Li,L2,Y,Yi,Y2,Z,Zi,Z2,X,Xi,X2;


	public static  final Moves[] array = Moves.values();
	public static  final List<Moves> list = Arrays.asList(array);
	private static final String[] stringArray = 
	{
		"U","Ui","U2","D","Di","D2","F","Fi","F2","B","Bi","B2","R","Ri","R2","L","Li","L2","Y","Yi","Y2","Z","Zi","Z2","X","Xi","X2"
	};


	public static final Moves[][][] corners =
	{
		{
			{},
			{Ri,F,Ui,R,U2,Fi},
			{R,Li,U2,Ri,U,L},
			{R,U,Ri,Li,Ui,L},
			{Fi,U2,F2,Ui,Fi},
			{R,Li,U,Ri,L},
			{F,L,U,Li,U2,Fi},
			{F,Bi,Ui,Fi,B},
			{L,U,L2,U2,L},
			{F2,R2,F2,R2},
			{Li,B,U2,L,Bi},
			{Ri,F,U2,R,Fi},
			{Ri,F,R,U2,Fi},
			{F,U,Fi},
			{Li,Ui,L},
			{F2,L,F2,Li},
			{U,Li,Ui,L},
			{Li,U,L},
			{L2,Fi,L2,F},
			{F,Ui,Fi},
			{Ui,F,U,Fi},
			{F,Ri,U,Fi,R},
			{Li,U2,L},
			{F,U2,Fi}
		},
		{
			{},
			{R,Ui,Ri,Fi,Ui,F},
			{Fi,U,F,R,U,Ri},
			{R2,B2,R2,B2},
			{R,Bi,U2,Ri,B},
			{Fi,L,U2,Li,F},
			{Fi,B,Ui,Bi,U,F},
			{Fi,B,U,F,Bi},
			{Ri,U2,R2,Ui,Ri},
			{Li,F2,L,F2,L},
			{Ui,R,U,Ri},
			{R,Ui,Ri},
			{R,F,R2,Fi,Ri},
			{Fi,Ui,F},
			{R,U,Ri},
			{R,Bi,U,B,Ri},
			{R,U2,Ri},
			{Fi,U2,F},
			{R,R,F,R2,Fi},
			{Fi,U,F},
			{U,Fi,Ui,F}
		},
		{
			{},
			{L,Ui,Li,Bi,Ui,B},
			{Bi,U,B,L,U,Li},
			{Ri,U,R,L,Ui,Li},
			{B,U,B2,U2,B},
			{Ri,L,Ui,R,Li},
			{F,L2,Fi,L2,Fi},
			{Bi,U,B},
			{U,Bi,Ui,B},
			{Bi,R,Bi,Ri,B2},
			{L,U2,Li},
			{Bi,U2,B},
			{L,B,L2,Bi,Li},
			{Bi,Ui,B},
			{L,U,Li},
			{B,B,Li,B2,L},
			{Ui,L,U,Li},
			{L,Ui,Li}
		},
		{
			{},
			{Ri,U,R,B,U,Bi},
			{B,Ui,Bi,Ri,Ui,R},
			{Ri,F,Ri,Fi,R,R},
			{Ri,U2,R},
			{B,U2,Bi},
			{Fi,R2,F,R2,F},
			{B,Ui,Bi},
			{Ui,B,U,Bi},
			{L,B2,Li,B2,Li},
			{U,Ri,Ui,R},
			{Ri,U,R},
			{Ri,Bi,R2,B,R},
			{B,U,Bi},
			{Ri,Ui,R}
		}
	};
	public static final Moves[][][] edges   =
	{
		{
			{},
			{F,L,F,U,F2,Ui,Li,Ui,Fi},
			{F2,U2,F2,U2,F2},
			{Fi,Ui,Ri,F,R,F},
			{L2,U2,L2,U2,L2},
			{Li,Fi,Li,F,U,L},
			{D,R2,U,Di,F2},
			{Ri,U,Di,Ri,Fi,R,D,R},
			{U,R2,D2,L,D2,R2},
			{B2,D2,Fi,D2,B2},
			{R2,D2,L,D2,R2},
			{U,F2,U2,F,U2,F2},
			{L2,U2,Li,U2,L2},
			{U,F,U,L,Fi,Li,Fi},
			{Ui,L2,U2,L,U2,L2},
			{B2,D2,F,D2,B2}
		},
		{
			{},
			{R,U,F,U,R2,Ui,Ri,Fi,Ri},
			{D,B2,U,Di,R,R},
			{R,D,R,Bi,Ri,U,Di,Ri},
			{R2,U2,R2,U2,R2},
			{R,F,R,Fi,Ui,Ri},
			{U,R2,U2,R,U2,R2},
			{Ri,D2,Fi,L,F,D2,R},
			{R2,U2,R,U2,R2},
			{R,U,Ri,Ui,Fi,Ui,F},
			{R2,U2,Ri,U2,R2},
			{R,U2,Ri,U2,Fi,Ui,F},
			{U,R2,U2,Ri,U2,R2},
			{R,Bi,Ri,Di,Ri,D,B}
		},
		{
			{},
			{Ri,Ui,Bi,U,B,R2,B2,Ri,B2},
			{B2,U2,B2,U2,B2},
			{B,U,R,Bi,Ri,Bi},
			{Bi,Ui,B,U,L,U,Li},
			{B2,U2,Bi,U2,B2},
			{Fi,L2,Ui,Li,U,L2,F},
			{U,B2,U2,B,U2,B2},
			{R,D,B2,Di,R2,U,R},
			{U,B2,U2,Bi,U2,B2},
			{Bi,U2,B,U2,L,U,Li},
			{B2,U2,B,U2,B2}
		},
		{
			{},
			{Ri,U,Ri,U2,Bi,R2,B,U2,R2},
			{R,Bi,Ri,B,Ri,Ui,R},
			{F,R2,U,R2,Ui,R2,Fi},
			{Li,B2,Ui,B2,U,B2,L},
			{Ri,U,R,U,B,Ui,Bi},
			{F,R2,U,R,Ui,R2,Fi},
			{Ri,U2,R,U2,B,U,Bi},
			{B,U2,Bi,U2,Ri,Ui,R},
			{R,U2,F,Ri,Fi,U2,Ri}
		}
	};
	public static final Moves[][]   OLL     =
	{
		{}
	};
	public static final Moves[][]   PLL     =
	{
		{}
	};


	public static Moves   getMove(String move)
	{
		move.replaceAll("'","i");
		for(int i=0;i<stringArray.length;i++)
			if(move.equals(stringArray[i]))
				return array[i];
		return null;
	}
	public static Moves[] getMoves(String moves)
	{
		String[] tokens = moves.split(" ");
		Moves[] newMoves = new Moves[tokens.length];
		for(int i=0;i<tokens.length;i++)
			newMoves[i] = getMove(tokens[i]);
		if(Arrays.asList(newMoves).contains(null))
			return null;
		return newMoves;
	}

	public static String getString(Moves... moves)
	{
		String newString = "";
		for(Moves move:moves)
			newString+=stringArray[list.indexOf(move)]+" ";
		return newString;
	}
}