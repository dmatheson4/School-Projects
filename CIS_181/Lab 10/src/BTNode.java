
public class BTNode {
	private BTNode left;
	private BTNode right;
	private Object obj;
	
	private BTNode()
	{
		//Don't allow null value objects to be created.
	}
	
	public BTNode(Object o)
	{
		left = null;
		right = null;
		obj = o;
	}
	
	public Object getObject()
	{
		return obj;
	}
	

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

}
