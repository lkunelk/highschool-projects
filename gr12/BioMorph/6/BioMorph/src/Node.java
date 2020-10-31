/*
Nodes for use in the biomorph
*/

//Start of Node Class
	class Node
	{
		//Class Variables
		private Organism parent;
		private int[] genes;
		private int depth;
		private double xPos, yPos;
		private Node leftChild, rightChild;
		
		//Start of Constructor
		//Pre-Condition: Node is created with double x, double y, int depth and an organism for the parent
		Node(double forXPos, double forYPos, int depth, Organism o)
		{
			parent = o;
			genes = parent.getGenes();
			this.depth = depth;
			xPos = forXPos;
			yPos = forYPos;
			
			updateMaxMin(xPos, yPos);
			
			//------------------------------------------
			double ratio = (100.0-depth*20)/100;
			//------------------------------------------
			
			//when should it stop
			if(depth<genes[0])
			{
				//ignore leftchild at depth 0
				if(depth!=0)
				{
					if(depth%2==0)
					{
						//even stuff
						leftChild = new Node(xPos-genes[6]*ratio, yPos+genes[5]*ratio, depth+1, parent);
					}
					else
					{
						//odd stuff
						leftChild = new Node(xPos-genes[8]*ratio, yPos+genes[7]*ratio, depth+1, parent);
					}
				}
				//for rightChild
				if(depth%2==0)
				{
					//even stuff
					rightChild = new Node(xPos+genes[2]*ratio, yPos+genes[1]*ratio, depth+1, parent);
				}
				else
				{
					//odd stuff
					rightChild = new Node(xPos+genes[4]*ratio, yPos+genes[3]*ratio, depth+1, parent);
				}
			}
		}//End of Constructor
		//Post-Conditions: sets x, y, genes, depth and children (if there are any)
		
		//UpdateMaxMin Method - Purpose: For updating dimensions of the organism
		//Pre-Condition: Method was called
		public void updateMaxMin(double x, double y)
		{
			double[] d = parent.getDimensions();
			if(-x < d[0])d[0]=-x;//min X : special case, since we are reflecting right side to left
			if(y < d[1])d[1]=y;//min Y
			if(x > d[2])d[2]=x;//max X
			if(y > d[3])d[3]=y;//max Y
		}//Post-Condition: organism's dimentions (x and y) are reset to new updated values
		
		//getDepth Method - Purpose: returns int depth
		//Pre-Condition: Method was called
		public int getDepth()
		{
			return(depth);
		}//Post-Condition: returns int depth
		
		//SetX Method - Purpose: To change the value of int x
		//Pre-Condition: Method was called with integer value
		public void setX(int forX)
		{
			xPos = forX;
		}//Post-Condition: Sets x to int value
		
		//SetY Method - Purpose: To change the value of int y
		//Pre-Condition: Method was called with integer value
		public void setY(int forY)
		{
			yPos = forY;
		}//Post-Condition: Sets y to int value
		
		//getX Method - Purpose: return int x
		//Pre-Condition: Method was called
		public double getX()
		{
			return(xPos);
		}//Post-Condition: Returns int x
		
		//getY Method - Purpose: return int y
		//Pre-Condition: Method was called
		public double getY()
		{
			return(yPos);
		}//Post-Condition: Returns int y
		
		//getRightChild Method - Purpose: Return rightChild Node
		//Pre-Condition: Method was called
		public Node getRightChild()
		{
			return(rightChild);
		}//Post-Condition: Returns Node rightChild
		
		//getLeftChild Method - Purpose: Return leftChild Node
		//Pre-Condition: Method was called
		public Node getLeftChild()
		{
			return(leftChild);
		}//Post-Condition: Returns Node leftChild
	}//End of Node Class