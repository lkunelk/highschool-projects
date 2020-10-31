package qBoT;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeXThreeXThree
{
	public char up = 'y',down = 'w',front = 'o',back  = 'r',right = 'b',left  = 'g';
	public char[] state = new char[54];
	private char[] solved = 
	{
		up,    up,    up,    up,    up,    up,    up,    up,    up,
		down,  down,  down,  down,  down,  down,  down,  down,  down,
		front, front, front, front, front, front, front, front, front,
		back,  back,  back,  back,  back,  back,  back,  back,  back,
		right, right, right, right, right, right, right, right, right,
		left,  left,  left,  left,  left,  left,  left,  left,  left
	};

	private char[][] corners = 
	{
		{17,24,53},
		{24,53,17},
		{53,17,24},
		{15,42,26},
		{26,15,42},
		{42,26,15},
		{11,51,35},
		{35,11,51},
		{51,35,11},
		{ 9,33,44},
		{33,44, 9},
		{44, 9,33},
		{ 6,47,18},
		{18, 6,47},
		{47,18, 6},
		{ 8,20,36},
		{20,36, 8},
		{36, 8,20},
		{ 0,29,45},
		{29,45, 0},
		{45, 0,29},
		{ 2,38,27},
		{27, 2,38},
		{38,27, 2}
	};
	private char[][] edges = 
	{
		{21,50},
		{50,21},
		{23,39},
		{39,23},
		{32,48},
		{48,32},
		{30,41},
		{41,30},
		{ 7,19},
		{19, 7},
		{ 3,46},
		{46, 3},
		{ 5,37},
		{37, 5},
		{ 1,28},
		{28, 1}
	};

	public static final int SOLVED_STATE = 0;
	public static final int RANDOM_STATE = 1;

	ThreeXThreeXThree()
	{
		this(SOLVED_STATE);
	}
	ThreeXThreeXThree(int state)
	{
		setState(state);
	}
	ThreeXThreeXThree(char[] initialPosition)
	{
		state = initialPosition;
	}
	ThreeXThreeXThree(Moves... initialMoves)
	{
		setState(SOLVED_STATE);
		doMoves(initialMoves);
	}


	public Moves[] solve(String... methods)
	{
		ArrayList<Moves> solution = new ArrayList<Moves>();
		for(String method:methods)
		{
			Moves[] alg = null;
			if(method.equals("Cross"))
				alg = Methods.cross(this);
			else if(method.equals("Corner"))
				alg = Methods.corner(this);
			else if(method.equals("Edge"))
				alg = Methods.edge(this);
			else if(method.equals("Top Edge Orientation"))
				alg = Methods.topEdgeOrientation(this);
			else if(method.equals("Top Edge Permutation"))
				alg = Methods.topEdgePermutation(this);
			else if(method.equals("Top Corner Permutation"))
				alg = Methods.topCornerPermutation(this);
			else if(method.equals("Top Corner Orientation"))
				alg = Methods.topCornerOrientation(this);
			else if(method.equals("OLL"))
				alg = Methods.OLL(this);
			else if(method.equals("PLL"))
				alg = Methods.PLL(this);
			if(alg!=null)
			{
				doMoves(alg);
				solution.addAll(Arrays.asList(alg));
			}
		}
		return solution.toArray(new Moves[solution.size()]);
	}


	public void setState(int state)
	{
		if(state == SOLVED_STATE)
			this.state = solved;
		else if(state == RANDOM_STATE)
			scramble();
		else
			throw new IllegalArgumentException("state must be one of: SOLVED_STATE or RANDOM_STATE");
	}


	public Moves[] scramble()
	{
		return scramble(100);
	}
	public Moves[] scramble(final int SCRAMBLE_LENGTH)
	{
		setState(SOLVED_STATE);
		Moves[] scramble = new Moves[SCRAMBLE_LENGTH];
		scramble[0] = Moves.array[(int)(Math.random()*18)];
		for(int i=1;i<SCRAMBLE_LENGTH;i++)
		{
			scramble[i] = Moves.array[(int)(Math.random()*18)];
			if(Moves.list.indexOf(scramble[i])/3 == Moves.list.indexOf(scramble[i-1])/3)
				i--;
		}
		doMoves(scramble);
		return scramble;
	}


	public void doMoves(Moves... moves)
	{
		for(Moves move:moves)
		{
			char[] temp = state.clone();
			switch(move)
			{
				case U:
					state[ 0] = temp[ 6];
					state[ 1] = temp[ 3];
					state[ 2] = temp[ 0];
					state[ 3] = temp[ 7];
					state[ 5] = temp[ 1];
					state[ 6] = temp[ 8];
					state[ 7] = temp[ 5];
					state[ 8] = temp[ 2];
					state[18] = temp[36];
					state[19] = temp[37];
					state[20] = temp[38];
					state[27] = temp[45];
					state[28] = temp[46];
					state[29] = temp[47];
					state[36] = temp[27];
					state[37] = temp[28];
					state[38] = temp[29];
					state[45] = temp[18];
					state[46] = temp[19];
					state[47] = temp[20];
					break;
				case Ui:
					doMoves(Moves.U,Moves.U,Moves.U);
					break;
				case U2:
					doMoves(Moves.U,Moves.U);
					break;
				case D:
					state[ 9] = temp[15];
					state[10] = temp[12];
					state[11] = temp[ 9];
					state[12] = temp[16];
					state[14] = temp[10];
					state[15] = temp[17];
					state[16] = temp[14];
					state[17] = temp[11];
					state[24] = temp[51];
					state[25] = temp[52];
					state[26] = temp[53];
					state[33] = temp[42];
					state[34] = temp[43];
					state[35] = temp[44];
					state[42] = temp[24];
					state[43] = temp[25];
					state[44] = temp[26];
					state[51] = temp[33];
					state[52] = temp[34];
					state[53] = temp[35];
					break;
				case Di:
					doMoves(Moves.D,Moves.D,Moves.D);
					break;
				case D2:
					doMoves(Moves.D,Moves.D);
					break;
				case F:
					state[18] = temp[24];
					state[19] = temp[21];
					state[20] = temp[18];
					state[21] = temp[25];
					state[23] = temp[19];
					state[24] = temp[26];
					state[25] = temp[23];
					state[26] = temp[20];
					state[ 6] = temp[53];
					state[ 7] = temp[50];
					state[ 8] = temp[47];
					state[15] = temp[36];
					state[16] = temp[39];
					state[17] = temp[42];
					state[36] = temp[ 6];
					state[39] = temp[ 7];
					state[42] = temp[ 8];
					state[47] = temp[17];
					state[50] = temp[16];
					state[53] = temp[15];
					break;
				case Fi:
					doMoves(Moves.F,Moves.F,Moves.F);
					break;
				case F2:
					doMoves(Moves.F,Moves.F);
					break;
				case B:
					state[27] = temp[33];
					state[28] = temp[30];
					state[29] = temp[27];
					state[30] = temp[34];
					state[32] = temp[28];
					state[33] = temp[35];
					state[34] = temp[32];
					state[35] = temp[29];
					state[ 0] = temp[38];
					state[ 1] = temp[41];
					state[ 2] = temp[44];
					state[ 9] = temp[51];
					state[10] = temp[48];
					state[11] = temp[45];
					state[38] = temp[ 9];
					state[41] = temp[10];
					state[44] = temp[11];
					state[45] = temp[ 2];
					state[48] = temp[ 1];
					state[51] = temp[ 0];
					break;
				case Bi:
					doMoves(Moves.B,Moves.B,Moves.B);
					break;
				case B2:
					doMoves(Moves.B,Moves.B);
					break;
				case R:
					state[36] = temp[42];
					state[37] = temp[39];
					state[38] = temp[36];
					state[39] = temp[43];
					state[41] = temp[37];
					state[42] = temp[44];
					state[43] = temp[41];
					state[44] = temp[38];
					state[ 2] = temp[20];
					state[ 5] = temp[23];
					state[ 8] = temp[26];
					state[ 9] = temp[27];
					state[12] = temp[30];
					state[15] = temp[33];
					state[20] = temp[15];
					state[23] = temp[12];
					state[26] = temp[ 9];
					state[27] = temp[ 8];
					state[30] = temp[ 5];
					state[33] = temp[ 2];
					break;
				case Ri:
					doMoves(Moves.R,Moves.R,Moves.R);
					break;
				case R2:
					doMoves(Moves.R,Moves.R);
					break;
				case L:
					state[45] = temp[51];
					state[46] = temp[48];
					state[47] = temp[45];
					state[48] = temp[52];
					state[50] = temp[46];
					state[51] = temp[53];
					state[52] = temp[50];
					state[53] = temp[47];
					state[ 0] = temp[35];
					state[ 3] = temp[32];
					state[ 6] = temp[29];
					state[11] = temp[24];
					state[14] = temp[21];
					state[17] = temp[18];
					state[18] = temp[ 0];
					state[21] = temp[ 3];
					state[24] = temp[ 6];
					state[29] = temp[11];
					state[32] = temp[14];
					state[35] = temp[17];
					break;
				case Li:
					doMoves(Moves.L,Moves.L,Moves.L);
					break;
				case L2:
					doMoves(Moves.L,Moves.L);
					break;
				case Y:
					doMoves(Moves.U,Moves.Di);
					state[21] = temp[39];
					state[22] = temp[40];
					state[23] = temp[41];
					state[30] = temp[48];
					state[31] = temp[49];
					state[32] = temp[50];
					state[39] = temp[30];
					state[40] = temp[31];
					state[41] = temp[32];
					state[48] = temp[21];
					state[49] = temp[22];
					state[50] = temp[23];
					front     = temp[40];
					back      = temp[49];
					right     = temp[31];
					left      = temp[22];
					break;
				case Yi:
					doMoves(Moves.Y,Moves.Y,Moves.Y);
					break;
				case Y2:
					doMoves(Moves.Y,Moves.Y);
					break;
				case Z:
					doMoves(Moves.F,Moves.Bi);
					state[ 3] = temp[52];
					state[ 4] = temp[49];
					state[ 5] = temp[46];
					state[12] = temp[37];
					state[13] = temp[40];
					state[14] = temp[43];
					state[37] = temp[ 3];
					state[40] = temp[ 4];
					state[43] = temp[ 5];
					state[46] = temp[14];
					state[49] = temp[13];
					state[52] = temp[12];
					up        = temp[49];
					down      = temp[40];
					right     = temp[ 4];
					left      = temp[13];
					break;
				case Zi:
					doMoves(Moves.Z,Moves.Z,Moves.Z);
					break;
				case Z2:
					doMoves(Moves.Z,Moves.Z);
					break;
				case X:
					doMoves(Moves.R,Moves.Li);
					state[ 1] = temp[19];
					state[ 4] = temp[22];
					state[ 7] = temp[25];
					state[10] = temp[28];
					state[13] = temp[31];
					state[16] = temp[34];
					state[19] = temp[16];
					state[22] = temp[13];
					state[25] = temp[10];
					state[28] = temp[ 7];
					state[31] = temp[ 4];
					state[34] = temp[ 1];
					up        = temp[22];
					down      = temp[31];
					front     = temp[13];
					back      = temp[ 4];
					break;
				case Xi:
					doMoves(Moves.X,Moves.X,Moves.X);
					break;
				case X2:
					doMoves(Moves.X,Moves.X);
					break;
			}
			solved = new char[]
			{
				up,    up,    up,    up,    up,    up,    up,    up,    up,
				down,  down,  down,  down,  down,  down,  down,  down,  down,
				front, front, front, front, front, front, front, front, front,
				back,  back,  back,  back,  back,  back,  back,  back,  back,
				right, right, right, right, right, right, right, right, right,
				left,  left,  left,  left,  left,  left,  left,  left,  left,
			};
		}
	}


	public int getPosition(char one,char two)
	{
		for(int i=0;i<16;i++)
			if(state[edges[i][0]]==one&&state[edges[i][1]]==two)
				return i;
		return -1;
	}
	public int getPosition(char one,char two,char three)
	{
		for(int i=0;i<24;i++)
			if(state[corners[i][0]]==one&&state[corners[i][1]]==two&&state[corners[i][2]]==three)
				return i;
		return -1;
	}
}