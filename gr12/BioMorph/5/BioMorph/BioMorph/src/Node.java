/*
*/

//Nodes for use in the biomorph
	class Node
	{
		private Organism parent;
		private int[] genes;
		private int depth;
		private double xPos, yPos;
		private Node leftChild, rightChild;
		
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
		}
		
		//method for updating dimensions of the organism
		public void updateMaxMin(double x, double y){
			double[] d = parent.getDimensions();
			if(-x < d[0])d[0]=-x;//min X : special case, since we are reflecting right side to left
			if(y < d[1])d[1]=y;//min Y
			if(x > d[2])d[2]=x;//max X
			if(y > d[3])d[3]=y;//max Y
		}
		
		public int getDepth()
		{
			return(depth);
		}
			
		public void setX(int forX)
		{
			xPos = forX;
		}
		
		public void setY(int forY)
		{
			yPos = forY;
		}
		
		public double getX()
		{
			return(xPos);
		}
		
		public double getY()
		{
			return(yPos);
		}
		
		public Node getRightChild()
		{
			return(rightChild);
		}
		
		public Node getLeftChild()
		{
			return(leftChild);
		}
	}