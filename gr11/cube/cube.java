import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.lang.*;

public
class cube extends Applet implements MouseMotionListener{

Image workspace;
Graphics offscreen;
private Image myImage;

	public void init() {
	
	addMouseMotionListener(this);
        workspace = createImage(300, 300);
        offscreen = workspace.getGraphics();
	myImage = getImage(getCodeBase(), "clouds.jpg");

	}

Color colList[] = new Color[120];

public double Xv[] = new double[9];
public double Yv[] = new double[9];
public double Zv[] = new double[9];

public double Xn[] = new double[9];
public double Yn[] = new double[9];
public double Zn[] = new double[9];

public double Ln[] = new double[9];

public double Va[] = new double[9];

public int colorVal[] = new int[9];

public int startX = 0;
public int startY = 0;

private double Xd = 0;
private double Yd = 0;

public int side=50;
public int i, j;

public double Xrot;
public double Yrot;
public double Zrot;

public double X2double;
public double Y2double;
public double Z2double;

public double R11;
public double R12;
public double R13;

public double R21;
public double R22;
public double R23;

public double R31;
public double R32;
public double R33;

long X2long;
long Y2long;
long Z2long;

public double X1[]={0,-side,side,side,-side,side,-side,-side,side};
public double Y1[]={0,side,side,-side,-side,side,side,-side,-side};
public double Z1[]={0,-side,-side,-side,-side,side,side,side,side};

public double X1t[]={0,-side,side,side,-side,-side,side,side,-side};
public double Y1t[]={0,side,side,-side,-side,side,side,-side,-side};
public double Z1t[]={0,-side,-side,-side,-side,side,side,side,side};

public int X2[]=new int[9];
public int Y2[]=new int[9];
public int Z2[]=new int[9];

public int face[][]={
	{0,0,0,0,0},
	{0,1,2,3,4},
	{0,2,5,8,3},
	{0,5,6,7,8},
	{0,6,1,4,7},
	{0,4,3,8,7},
	{0,6,5,2,1},
};

public int Xs[][]=new int[7][5];
public int Ys[][]=new int[7][5];

public int colormatrix=0;

public int V1, V2, N;

public void destroy() {
  removeMouseMotionListener(this);
}

public void mouseDragged(MouseEvent e) {
  Graphics g = e.getComponent().getGraphics();

if (colormatrix == 0) {
	colormatrix = 1;
	for (i=0;i<20;i++)
	   {
		colList[i]=new Color(i*6,84+i*9,84+i*9);		// Cyan
		colList[i+20]=new Color(i*6,i*6,84+i*9);			// Blue
		colList[i+40]=new Color(84+i*9,i*5,i*5);			// Red
		colList[i+60]=new Color(i*6,84+i*9,i*6);			// Green
		colList[i+80]=new Color(84+i*9,84+i*9,i*6);		    // Yellow
		colList[i+100]=new Color(84+i*9,55+i*8,i*3);		// Orange		
	   }
}
	offscreen.drawImage(myImage,0,0,this);
	super.paint(offscreen);

//******************************************************************
  Xd = startX - e.getX();
  Yd = startY - e.getY();

  Xrot = -Yd/100;
  Yrot = Xd/100;
  Zrot=0;

  for (i=1;i<9;i++)
  {

R11 = Math.cos(Yrot) * Math.cos(Zrot);
R12 = -Math.cos(Yrot) * Math.sin(Zrot);
R13 = Math.sin(Yrot);

R21 = Math.cos(Xrot) * Math.sin(Zrot) + Math.sin(Xrot) * Math.sin(Yrot) * Math.cos(Zrot);
R22 = Math.cos(Xrot) * Math.cos(Zrot) - Math.sin(Xrot) * Math.sin(Yrot) * Math.sin(Zrot);
R23 = -Math.sin(Xrot) * Math.cos(Yrot);

R31 = Math.sin(Xrot) * Math.sin(Zrot) - Math.cos(Xrot) * Math.sin(Yrot) * Math.cos(Zrot);
R32 = Math.sin(Xrot) * Math.cos(Zrot) + Math.cos(Xrot) * Math.sin(Yrot) * Math.sin(Zrot);
R33 = Math.cos(Xrot) * Math.cos(Yrot);

X1t[i] = X1[i] * R11 + Y1[i] * R12 + Z1[i] * R13;
Y1t[i] = X1[i] * R21 + Y1[i] * R22 + Z1[i] * R23;
Z1t[i] = X1[i] * R31 + Y1[i] * R32 + Z1[i] * R33;

X1[i] = X1t[i];
Y1[i] = Y1t[i];
Z1[i] = Z1t[i];

// Vertices need to be integer for the drawLine function
// A double needs to be rounded to long data type before it can be
// rounded to integer data type.

    X2[i]=Math.round(Math.round(X1[i]));
    Y2[i]=Math.round(Math.round(Y1[i]));
    Z2[i]=Math.round(Math.round(Z1[i]));

    X2[i] = X2[i] + 150;
    Y2[i] = Y2[i] + 150;

  }
//******************************************************************
	for (i=1;i<7;i++) {
	V1=face[i][3];
	V2=face[i][1];
	 N=face[i][2];

	Xv[V1]=X1[V1]-X1[N];
	Yv[V1]=Y1[V1]-Y1[N];
	Zv[V1]=Z1[V1]-Z1[N];

	Xv[V2]=X1[V2]-X1[N];
	Yv[V2]=Y1[V2]-Y1[N];
	Zv[V2]=Z1[V2]-Z1[N];

	Xn[N]=Yv[V1]*Zv[V2]-Zv[V1]*Yv[V2];
	Yn[N]=-Xv[V1]*Zv[V2]-Zv[V1]*Xv[V2];
	Zn[N]=Xv[V1]*Yv[V2]-Yv[V1]*Xv[V2];

	Ln[N]=Math.sqrt(Xn[N]*Xn[N]+Yn[N]*Yn[N]+Zn[N]*Zn[N]);

	Va[i]=Math.acos(-Zn[N]/Ln[N]);

	colorVal[i]=(i-1)*20+19-Math.round(Math.round(Va[i]/.083));
	}
//******************************************************************
	for (i=1;i<7;i++) {
	for (j=0;j<4;j++) {
	Xs[i][j]=X2[face[i][j+1]];
	Ys[i][j]=Y2[face[i][j+1]];
	}
	}

	for (i=1;i<7;i++) {
	if (Va[i] < 1.57) {
	offscreen.setColor(colList[colorVal[i]]);
	offscreen.fillPolygon(Xs[i],Ys[i],4);
	}
	}

	int Xdisp = X2[1]-150;
	int Ydisp = Y2[1]-150;

        g.drawImage(workspace, 0, 0, this);
	super.paint(g);

		startX=e.getX();
		startY=e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		startX=e.getX();
		startY=e.getY();

	}

}