
/**
 * @author Clint Rogers
 * 
 * This class does not need to be changed
 *
 */
public class mainExecutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleBinaryTree sbt = new SimpleBinaryTree();
		sbt.addObject(new String("10"));
		sbt.addObject(new String("106"));
		sbt.addObject(new String("1"));
		sbt.addObject(new String("-10"));
		sbt.addObject(new String("64"));
		sbt.addObject(new String("65"));
		sbt.addObject(new String("85"));
		sbt.addObject(new String("-20"));
		sbt.addObject(new String("200"));
		sbt.addObject(new String("9"));
		sbt.addObject(new String("63"));
		
		if(sbt.containsObject(new String("85")))
			System.out.println("Correct, it does contain 85");
		else
			System.out.println("Incorrect, it does contain 85");
		
		if(sbt.containsObject(new String("87")))
			System.out.println("Incorrect, it does not contain 87");
		else
			System.out.println("Correct, it does not contain 87");
				
		System.out.println("Leaf count is: "+sbt.countLeafNodes());
	}

}
