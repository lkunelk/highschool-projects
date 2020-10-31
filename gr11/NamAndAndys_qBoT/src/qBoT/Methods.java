package qBoT;

import java.util.ArrayList;
import java.util.Arrays;

class Methods
{
	public  static Moves[] cross(ThreeXThreeXThree cube)
	{
		up            = cube.up;
		down          = cube.down;
		front         = cube.front;
		back          = cube.back;
		right         = cube.right;
		left          = cube.left;
		edgeState[ 0] = cube.state[ 1];
		edgeState[ 1] = cube.state[ 3];
		edgeState[ 2] = cube.state[ 5];
		edgeState[ 3] = cube.state[ 7];
		edgeState[ 4] = cube.state[10];
		edgeState[ 5] = cube.state[12];
		edgeState[ 6] = cube.state[14];
		edgeState[ 7] = cube.state[16];
		edgeState[ 8] = cube.state[19];
		edgeState[ 9] = cube.state[21];
		edgeState[10] = cube.state[23];
		edgeState[11] = cube.state[25];
		edgeState[12] = cube.state[28];
		edgeState[13] = cube.state[30];
		edgeState[14] = cube.state[32];
		edgeState[15] = cube.state[34];
		edgeState[16] = cube.state[37];
		edgeState[17] = cube.state[39];
		edgeState[18] = cube.state[41];
		edgeState[19] = cube.state[43];
		edgeState[20] = cube.state[46];
		edgeState[21] = cube.state[48];
		edgeState[22] = cube.state[50];
		edgeState[23] = cube.state[52];
		crossTemp = edgeState.clone();
		if(crossSolved())
			return addCrossRotation(new Moves[]{});
		for(int a=0;a<18;a++)
			if(crossSolved(a))
				return addCrossRotation(new Moves[]{Moves.array[a]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				if(a/3!=b/3&&crossSolved(a,b))
					return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				for(int c=0;a/3!=b/3&&c<18;c++)
					if(b/3!=c/3&&crossSolved(a,b,c))
						return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b],Moves.array[c]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				for(int c=0;a/3!=b/3&&c<18;c++)
					for(int d=0;b/3!=c/3&&d<18;d++)
						if(c/3!=d/3&&crossSolved(a,b,c,d))
							return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b],Moves.array[c],Moves.array[d]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				for(int c=0;a/3!=b/3&&c<18;c++)
					for(int d=0;b/3!=c/3&&d<18;d++)
						for(int e=0;c/3!=d/3&&e<18;e++)
							if(d/3!=e/3&&crossSolved(a,b,c,d,e))
								return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b],Moves.array[c],Moves.array[d],Moves.array[e]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				for(int c=0;a/3!=b/3&&c<18;c++)
					for(int d=0;b/3!=c/3&&d<18;d++)
						for(int e=0;c/3!=d/3&&e<18;e++)
							for(int f=0;d/3!=e/3&&f<18;f++)
								if(e/3!=f/3&&crossSolved(a,b,c,d,e,f))
									return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b],Moves.array[c],Moves.array[d],Moves.array[e],Moves.array[f]});
		for(int a=0;a<18;a++)
			for(int b=0;b<18;b++)
				for(int c=0;a/3!=b/3&&c<18;c++)
					for(int d=0;b/3!=c/3&&d<18;d++)
						for(int e=0;c/3!=d/3&&e<18;e++)
							for(int f=0;d/3!=e/3&&f<18;f++)
								for(int g=0;e/3!=f/3&&g<18;g++)
									if(f/3!=g/3&&crossSolved(a,b,c,d,e,f,g))
										return addCrossRotation(new Moves[]{Moves.array[a],Moves.array[b],Moves.array[c],Moves.array[d],Moves.array[e],Moves.array[f],Moves.array[g]});
		return null;
	}
	private static char    up,down,front,back,right,left;
	private static char[]  edgeState = new char[24];
	private static char[]  crossTemp = new char[24];
	private static boolean crossSolved(int... moves)
	{
		doCrossMoves(moves);
		if((edgeState[ 0]==up   &&edgeState[ 1]==up   &&edgeState[ 2]==up    &&edgeState[ 3]==up   &&
			edgeState[ 8]==front&&edgeState[12]==back &&edgeState[16]==right)||
		   (edgeState[ 4]==down &&edgeState[ 5]==down &&edgeState[ 6]==down  &&edgeState[ 7]==down &&
			edgeState[11]==front&&edgeState[15]==back &&edgeState[19]==right)||
		   (edgeState[ 8]==front&&edgeState[ 9]==front&&edgeState[10]==front &&edgeState[11]==front&&
			edgeState[ 3]==up   &&edgeState[ 7]==down &&edgeState[17]==right)||
		   (edgeState[12]==back &&edgeState[13]==back &&edgeState[14]==back  &&edgeState[15]==back &&
			edgeState[ 0]==up   &&edgeState[ 4]==down &&edgeState[18]==right)||
		   (edgeState[16]==right&&edgeState[17]==right&&edgeState[18]==right &&edgeState[19]==right&&
			edgeState[ 2]==up   &&edgeState[ 5]==down &&edgeState[10]==front)||
		   (edgeState[20]==left &&edgeState[21]==left &&edgeState[22]==left  &&edgeState[23]==left &&
			edgeState[ 1]==up   &&edgeState[ 6]==down &&edgeState[ 9]==front))
				return true;
		edgeState = crossTemp.clone();
		return false;
	}
	private static void    doCrossMoves(int... moves)
	{
		for(int move:moves)
		{
			char[] temp = edgeState.clone();
			switch(move)
			{
				case 0://U
					edgeState[ 0] = temp[ 1];
					edgeState[ 1] = temp[ 3];
					edgeState[ 2] = temp[ 0];
					edgeState[ 3] = temp[ 2];
					edgeState[ 8] = temp[16];
					edgeState[12] = temp[20];
					edgeState[16] = temp[12];
					edgeState[20] = temp[ 8];
					break;
				case 1://U'
					edgeState[ 0] = temp[ 2];
					edgeState[ 1] = temp[ 0];
					edgeState[ 2] = temp[ 3];
					edgeState[ 3] = temp[ 1];
					edgeState[ 8] = temp[20];
					edgeState[12] = temp[16];
					edgeState[16] = temp[ 8];
					edgeState[20] = temp[12];
					break;
				case 2://U2
					edgeState[ 0] = temp[ 3];
					edgeState[ 1] = temp[ 2];
					edgeState[ 2] = temp[ 1];
					edgeState[ 3] = temp[ 0];
					edgeState[ 8] = temp[12];
					edgeState[12] = temp[ 8];
					edgeState[16] = temp[20];
					edgeState[20] = temp[16];
					break;
				case 3://D
					edgeState[ 4] = temp[ 5];
					edgeState[ 5] = temp[ 7];
					edgeState[ 6] = temp[ 4];
					edgeState[ 7] = temp[ 6];
					edgeState[11] = temp[23];
					edgeState[15] = temp[19];
					edgeState[19] = temp[11];
					edgeState[23] = temp[15];
					break;
				case 4://D'
					edgeState[ 4] = temp[6];
					edgeState[ 5] = temp[4];
					edgeState[ 6] = temp[7];
					edgeState[ 7] = temp[5];
					edgeState[11] = temp[19];
					edgeState[15] = temp[23];
					edgeState[19] = temp[15];
					edgeState[23] = temp[11];
					break;
				case 5://D2
					edgeState[ 4] = temp[ 7];
					edgeState[ 5] = temp[ 6];
					edgeState[ 6] = temp[ 5];
					edgeState[ 7] = temp[ 4];
					edgeState[11] = temp[15];
					edgeState[15] = temp[11];
					edgeState[19] = temp[23];
					edgeState[23] = temp[19];
					break;
				case 6://F
					edgeState[ 8] = temp[ 9];
					edgeState[ 9] = temp[11];
					edgeState[10] = temp[ 8];
					edgeState[11] = temp[10];
					edgeState[ 3] = temp[22];
					edgeState[ 7] = temp[17];
					edgeState[17] = temp[ 3];
					edgeState[22] = temp[ 7];
					break;
				case 7://F'
					edgeState[ 8] = temp[10];
					edgeState[ 9] = temp[ 8];
					edgeState[10] = temp[11];
					edgeState[11] = temp[ 9];
					edgeState[ 3] = temp[17];
					edgeState[ 7] = temp[22];
					edgeState[17] = temp[ 7];
					edgeState[22] = temp[ 3];
					break;
				case 8://F2
					edgeState[ 8] = temp[11];
					edgeState[ 9] = temp[10];
					edgeState[10] = temp[ 9];
					edgeState[11] = temp[ 8];
					edgeState[ 3] = temp[ 7];
					edgeState[ 7] = temp[ 3];
					edgeState[17] = temp[22];
					edgeState[22] = temp[17];
					break;
				case 9://B
					edgeState[12] = temp[13];
					edgeState[13] = temp[15];
					edgeState[14] = temp[12];
					edgeState[15] = temp[14];
					edgeState[ 0] = temp[18];
					edgeState[ 4] = temp[21];
					edgeState[18] = temp[ 4];
					edgeState[21] = temp[ 0];
					break;
				case 10://B'
					edgeState[12] = temp[14];
					edgeState[13] = temp[12];
					edgeState[14] = temp[15];
					edgeState[15] = temp[13];
					edgeState[ 0] = temp[21];
					edgeState[ 4] = temp[18];
					edgeState[18] = temp[ 0];
					edgeState[21] = temp[ 4];
					break;
				case 11://B2
					edgeState[12] = temp[15];
					edgeState[13] = temp[14];
					edgeState[14] = temp[13];
					edgeState[15] = temp[12];
					edgeState[ 0] = temp[ 4];
					edgeState[ 4] = temp[ 0];
					edgeState[18] = temp[21];
					edgeState[21] = temp[18];
					break;
				case 12://R
					edgeState[16] = temp[17];
					edgeState[17] = temp[19];
					edgeState[18] = temp[16];
					edgeState[19] = temp[18];
					edgeState[ 2] = temp[10];
					edgeState[ 5] = temp[13];
					edgeState[10] = temp[ 5];
					edgeState[13] = temp[ 2];
					break;
				case 13://R'
					edgeState[16] = temp[18];
					edgeState[17] = temp[16];
					edgeState[18] = temp[19];
					edgeState[19] = temp[17];
					edgeState[ 2] = temp[13];
					edgeState[ 5] = temp[10];
					edgeState[10] = temp[ 2];
					edgeState[13] = temp[ 5];
					break;
				case 14://R2
					edgeState[16] = temp[19];
					edgeState[17] = temp[18];
					edgeState[18] = temp[17];
					edgeState[19] = temp[16];
					edgeState[ 2] = temp[ 5];
					edgeState[ 5] = temp[ 2];
					edgeState[10] = temp[13];
					edgeState[13] = temp[10];
					break;
				case 15://L
					edgeState[20] = temp[21];
					edgeState[21] = temp[23];
					edgeState[22] = temp[20];
					edgeState[23] = temp[22];
					edgeState[ 1] = temp[14];
					edgeState[ 6] = temp[ 9];
					edgeState[ 9] = temp[ 1];
					edgeState[14] = temp[ 6];
					break;
				case 16://L'
					edgeState[20] = temp[22];
					edgeState[21] = temp[20];
					edgeState[22] = temp[23];
					edgeState[23] = temp[21];
					edgeState[ 1] = temp[ 9];
					edgeState[ 6] = temp[14];
					edgeState[ 9] = temp[ 6];
					edgeState[14] = temp[ 1];
					break;
				case 17://L2
					edgeState[20] = temp[23];
					edgeState[21] = temp[22];
					edgeState[22] = temp[21];
					edgeState[23] = temp[20];
					edgeState[ 1] = temp[ 6];
					edgeState[ 6] = temp[ 1];
					edgeState[ 9] = temp[14];
					edgeState[14] = temp[ 9];
					break;
			}
		}
	}
	private static Moves[] addCrossRotation(Moves[] alg)
	{
		if(edgeState[4]==down&&edgeState[5]==down&&edgeState[6]==down&&edgeState[7]==down&&edgeState[11]==front&&edgeState[15]==back&&edgeState[19]==right)
			return alg;
		Moves[] newAlg = Arrays.copyOf(alg,alg.length+1);
		if(edgeState[0]==up&&edgeState[1]==up&&edgeState[2]==up&&edgeState[3]==up&&edgeState[8]==front&&edgeState[12]==back&&edgeState[16]==right)
			newAlg[alg.length] = Moves.X2;
		else if(edgeState[8]==front&&edgeState[9]==front&&edgeState[10]==front&&edgeState[11]==front&&edgeState[3]==up&&edgeState[7]==down&&edgeState[17]==right)
		   	newAlg[alg.length] = Moves.Xi;
		else if(edgeState[12]==back&&edgeState[13]==back&&edgeState[14]==back&&edgeState[15]==back&&edgeState[0]==up&&edgeState[4]==down&&edgeState[18]==right)
			newAlg[alg.length] = Moves.X;
		else if(edgeState[16]==right&&edgeState[17]==right&&edgeState[18]==right&&edgeState[19]==right&&edgeState[2]==up&&edgeState[5]==down&&edgeState[10]==front)
			newAlg[alg.length] = Moves.Z;
		else if(edgeState[20]==left&&edgeState[21]==left&&edgeState[22]==left&&edgeState[23]==left&&edgeState[1]==up&&edgeState[6]==down&&edgeState[9]==front)
			newAlg[alg.length] = Moves.Zi;
		return newAlg;
	}


	public static Moves[] corner(ThreeXThreeXThree cube)
	{
		if(cube.state[17]!=cube.down||cube.state[24]!=cube.front||cube.state[53]!=cube.left)
			return Moves.corners[0][cube.getPosition(cube.down,cube.front,cube.left)];
		if(cube.state[15]!=cube.down||cube.state[26]!=cube.front||cube.state[42]!=cube.right)
			return Moves.corners[1][cube.getPosition(cube.down,cube.right,cube.front)-3];
		if(cube.state[11]!=cube.down||cube.state[35]!=cube.back||cube.state[51]!=cube.left)
			return Moves.corners[2][cube.getPosition(cube.down,cube.left,cube.back)-6];
		if(cube.state[9]!=cube.down||cube.state[33]!=cube.back||cube.state[44]!=cube.right)
			return Moves.corners[3][cube.getPosition(cube.down,cube.back,cube.right)-9];
		return new Moves[]{};
	}


	public static Moves[] edge(ThreeXThreeXThree cube)
	{
		if(cube.state[21]!=cube.front||cube.state[50]!=cube.left)
			return Moves.edges[0][cube.getPosition(cube.front,cube.left)];
		if(cube.state[23]!=cube.front||cube.state[39]!=cube.right)
			return Moves.edges[1][cube.getPosition(cube.front,cube.right)-2];
		if(cube.state[32]!=cube.back||cube.state[48]!=cube.left)
			return Moves.edges[2][cube.getPosition(cube.back,cube.left)-4];
		if(cube.state[30]!=cube.back||cube.state[41]!=cube.right)
			return Moves.edges[3][cube.getPosition(cube.back,cube.right)-6];
		return new Moves[]{};
	}


	public static Moves[] topEdgeOrientation(ThreeXThreeXThree cube)
	{
		for(int i=0;i<4;i++)
		{
			if(cube.state[1]!=cube.up&&cube.state[3]!=cube.up&&cube.state[5]!=cube.up&&cube.state[7]!=cube.up)
				return addSetUp(cube,i,new Moves[]{Moves.F,Moves.R,Moves.U,Moves.Ri,Moves.Ui,Moves.Fi,
												 Moves.B,Moves.U,Moves.L,Moves.Ui,Moves.Li,Moves.Bi},0);
			if(cube.state[1]!=cube.up&&cube.state[3]==cube.up&&cube.state[5]==cube.up&&cube.state[7]!=cube.up)
				return addSetUp(cube,i,new Moves[]{Moves.F,Moves.R,Moves.U,Moves.Ri,Moves.Ui,Moves.Fi},0);
			if(cube.state[1]!=cube.up&&cube.state[3]!=cube.up&&cube.state[5]==cube.up&&cube.state[7]==cube.up)
				return addSetUp(cube,i,new Moves[]{Moves.B,Moves.U,Moves.L,Moves.Ui,Moves.Li,Moves.Bi},0);
			cube.doMoves(Moves.U);
		}
		return addSetUp(cube,4,new Moves[]{},0);
	}


	public static Moves[] topEdgePermutation(ThreeXThreeXThree cube)
	{
		for(int i=0;i<4;i++)
		{
			if(cube.state[28]==cube.back)
			{
				if(cube.state[37]==cube.right&&cube.state[46]==cube.left)
					return addSetUp(cube,i,new Moves[]{},0);
				if(cube.state[37]==cube.right)
					return addSetUp(cube,i,new Moves[]{Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.R,Moves.U2,Moves.Ri,Moves.U},0);
				if(cube.state[46]==cube.left)
					return addSetUp(cube,i,new Moves[]{Moves.U,Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.R,Moves.U2,Moves.Ri},0);
				if(cube.state[19]==cube.front)
					return addSetUp(cube,i,new Moves[]{Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.R,Moves.U2,Moves.Ri,Moves.Ui,
													 Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.R,Moves.U2,Moves.Ri,Moves.U2},0);
				if(cube.state[37]==cube.left)
					return addSetUp(cube,i,new Moves[]{Moves.Ri,Moves.U2,Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.R},0);
				if(cube.state[46]==cube.right)
					return addSetUp(cube,i,new Moves[]{Moves.Ri,Moves.Ui,Moves.R,Moves.Ui,Moves.Ri,Moves.U2,Moves.R},0);
			}
			cube.doMoves(Moves.U);
		}
		return addSetUp(cube,4,new Moves[]{},0);
	}


	public static Moves[] topCornerPermutation(ThreeXThreeXThree cube)
	{
		for(int i=0;i<4;i++)
		{
			final int UFL_POSITION = cube.getPosition(cube.up,cube.left, cube.front)/3;
			final int UFR_POSITION = cube.getPosition(cube.up,cube.front,cube.right)/3;
			final int UBL_POSITION = cube.getPosition(cube.up,cube.back, cube.left)/3;
			final int UBR_POSITION = cube.getPosition(cube.up,cube.right,cube.back)/3;
			if(UFL_POSITION==4&&UFR_POSITION==5&&UBL_POSITION==6&&UBR_POSITION==7)
				return addSetUp(cube,i,new Moves[]{},15);
			if(UFL_POSITION==7&&UBR_POSITION==4)
				return addSetUp(cube,i,new Moves[]{Moves.R2,Moves.U2,Moves.R,Moves.U2,Moves.R2,Moves.U2,Moves.R2,Moves.U2,Moves.R,Moves.U2,Moves.R2,Moves.U2},15);
			if(UFL_POSITION==5&&UFR_POSITION==4)
				return addSetUp(cube,i,new Moves[]{Moves.Ui,Moves.R,Moves.U,Moves.Ri,Moves.U,Moves.Ri,Moves.Ui,Moves.R,Moves.Fi,Moves.R,Moves.U,Moves.Ri,Moves.Ui,
												   Moves.Ri,Moves.F,Moves.R2,Moves.Ui,Moves.R2,Moves.U,Moves.R},15);
			if(UFR_POSITION==5&&UFL_POSITION==6)
				return addSetUp(cube,i,new Moves[]{Moves.U,Moves.R,Moves.Ui,Moves.Li,Moves.U,Moves.Ri,Moves.Ui,Moves.L},15);
			if(UFR_POSITION==5&&UFL_POSITION==7)
				return addSetUp(cube,i,new Moves[]{Moves.Li,Moves.U,Moves.R,Moves.Ui,Moves.L,Moves.U,Moves.Ri,Moves.Ui},15);
			cube.doMoves(Moves.Y);
		}
		return addSetUp(cube,4,new Moves[]{},15);
	}


	public static Moves[] topCornerOrientation(ThreeXThreeXThree cube)
	{
		ArrayList<Moves> alg = new ArrayList<Moves>();
		for(int i=0;i<4;i++)
		{
			if(cube.state[20]==cube.up)
				alg.addAll(Arrays.asList(new Moves[]{Moves.Di,Moves.Ri,Moves.D,Moves.R,Moves.Di,Moves.Ri,Moves.D,Moves.R}));
			else if(cube.state[36]==cube.up)
				alg.addAll(Arrays.asList(new Moves[]{Moves.Ri,Moves.Di,Moves.R,Moves.D,Moves.Ri,Moves.Di,Moves.R,Moves.D}));
			cube.doMoves(Moves.U);
			alg.add(Moves.U);
		}
		return alg.toArray(new Moves[0]);
	}


	public static Moves[] OLL(ThreeXThreeXThree cube)
	{
		byte[] face = new byte[8];
		face[0] = (byte)(cube.state[0]==cube.up?0:cube.state[29]==cube.up?1:2);
		face[1] = (byte)(cube.state[1]==cube.up?0:1);
		face[2] = (byte)(cube.state[2]==cube.up?0:cube.state[27]==cube.up?1:2);
		face[3] = (byte)(cube.state[3]==cube.up?0:1);
		face[4] = (byte)(cube.state[5]==cube.up?0:1);
		face[5] = (byte)(cube.state[6]==cube.up?0:cube.state[18]==cube.up?1:2);
		face[6] = (byte)(cube.state[7]==cube.up?0:1);
		face[7] = (byte)(cube.state[8]==cube.up?0:cube.state[20]==cube.up?1:2);
		byte[][] faces = 
		{
			{0,0,0,0,0,0,0,0},
			{2,1,0,0,0,2,1,0},
			{2,0,1,0,1,2,1,1},
			{1,0,1,0,0,1,0,1},
			{0,0,2,0,1,0,1,2},
			{2,0,2,1,1,1,0,1},
			{0,0,0,0,1,1,1,1},
			{1,0,2,1,0,1,1,2},
			{0,0,1,1,0,1,1,2},
			{1,0,0,0,1,2,1,1},
			{}
		};
		for(int i=0;i<faces.length;i++)
			if(Arrays.equals(faces[i],face))
				return Moves.OLL[i];
		return null;
	}


	public static Moves[] PLL(ThreeXThreeXThree cube)
	{
		char up = cube.up, down = cube.down, front = cube.front, back = cube.back, right = cube.right, left = cube.left;
		char[] side = new char[12];
		side[ 0] = cube.state[18];
		side[ 1] = cube.state[19];
		side[ 2] = cube.state[20];
		side[ 3] = cube.state[27];
		side[ 4] = cube.state[28];
		side[ 5] = cube.state[29];
		side[ 6] = cube.state[36];
		side[ 7] = cube.state[37];
		side[ 8] = cube.state[38];
		side[ 9] = cube.state[45];
		side[10] = cube.state[46];
		side[11] = cube.state[47];
		char[][] sides = 
		{
			{front,front,front,back,back,back,right,right,right,left,left,left},
			{}
		};
		for(int i=0;i<sides.length;i++)
			if(Arrays.equals(sides[i],side))
				return Moves.PLL[i];
		return null;
	}


	private static Moves[] addSetUp(ThreeXThreeXThree cube,int rotations,Moves[] alg,int setUp)
	{
		if(rotations==0)
			return alg;
		for(int i=0;i<rotations;i++)
			cube.doMoves(Moves.array[setUp+1]);
		if(rotations==4)
			return alg;
		Moves[] newAlg = new Moves[alg.length+1];
		for(int i=0;i<alg.length;i++)
			newAlg[i+1] = alg[i];
		switch(rotations)
		{
			case 1:
				newAlg[0] = Moves.array[setUp];
				break;
			case 2:
				newAlg[0] = Moves.array[setUp+2];
				break;
			case 3:
				newAlg[0] = Moves.array[setUp+1];
				break;
		}
		return newAlg;
	}
}