
/**
 * Here's the really cool thing about interfaces. Any methods that we specify
 * that must be implemented here do not have to implemented in an abstract 
 * class that implement this interface, but they *do* have to be implemented
 * by a class that inherits from that abstract class.
 */
public interface GameInterface {
	public int calculateEarnings();
}
