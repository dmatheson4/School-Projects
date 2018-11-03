/* Dan Matheson
 * 4/18/17
 * This program will be able to add numbers to a binary tree depending on whether it is greater, less, or equal to the number it is being compared to.
 * It will also allow a user to search for a object in the tree, and find out how many leaf nodes there are. 
 */
public class SimpleBinaryTree {
	private BTNode root;

	public SimpleBinaryTree()
	{
		root = null;
	}

	public void addObject(Object obj)
	{
		/*This method builds the tree for us*/
		//If the root is null, simply set root to obj
		if(root == null)
		{
			root = new BTNode(obj);
		}else
		{
			//assume value is an integer
			int value1 = Integer.parseInt((String)obj);
			//Create a traverse pointer
			BTNode trav = root;
			while(true)
			{
				//get the value of the object pointed to by trav
				int value2 = Integer.parseInt((String)trav.getObject());

				//if the value of the current node has a value greater than the obj go left
				if(value1<value2)
					if(trav.getLeft() == null)
					{
						//if left is null, create the new node and set it there
						trav.setLeft(new BTNode(obj));
						return;
					}else
					{
						//else have trav go left;
						trav = trav.getLeft();
					}
				else
					if(trav.getRight() == null)
					{
						//if right is null, create the new node and set it there
						trav.setRight(new BTNode(obj));
						return;
					}else
					{
						//else have trav go right;
						trav = trav.getRight();
					}
			}			
		}
	}

	public int countLeafNodes()
	{
		/* A leaf node is defined as having no children (.getRight and .getLeft are null)
		 */
		//Use a recursive function countLN that traverses all nodes and counts them
		return countLN(root);
	}

	private int countLN(BTNode trav)
	{
		/**************This function must be recursive********************/


		//Terminating cases
		if(trav==null)
			return 0;
		if((trav.getLeft()==null)&&(trav.getRight()==null))
		{
			//child node!
			return 1;
		}
		int count;
		
		//This will see if the left is null, then go right
		if(trav.getLeft()==null){
			count = countLN(trav.getRight());
		}
		
		//This will just go left until it reaches null
		else{
			count = countLN(trav.getLeft());
			//This will check if there is another leaf to the right that has to be found
			if(trav.getRight()!=null){
				count = count + countLN(trav.getRight());//Add count to the leaf on the right
			}
		}
		return count;
	}

	public boolean containsObject(Object obj)
	{
		BTNode trav = root;
		int value1 = Integer.parseInt((String)obj);

		//This will search for the object until it returns either true or false
		while(true){

			//Get the value of the object pointed to by the traverse pointer
			int value2 = Integer.parseInt((String)trav.getObject());

			//If the value of the current node has a value greater than the object, go left
			if(value1<value2){
				
				//This will return false if the left pointer is null
				if(trav.getLeft() == null)
					return false;
				
				//Have trav go to the left
				trav = trav.getLeft();
			}
			//If the value of the current node has a value less than or equal to the object, go right or return true
			else{
				
				//This will return true if the value is found
				if(value1 == value2){
					return true;
				}
				
				//This will return false if the right pointer is null
				if(trav.getRight() == null)
					return false;
				
				//If the value is not found, it will go to the right
				else{
					//Have trav go to the right
					trav = trav.getRight();
				}
			}
		}			
	}
}
