
public class Arrow {
	
	private Vector2D midPoint;
	
	
	public double[] unitVector;
	
	
	
	public Arrow() {
		this(0.5, 0.5);
	}
	
	public Arrow(double x, double y) {
		midPoint = new Vector2D(x, y);
	}
	
	public double getX() {
		return midPoint.x;
	}
	
	public double getY() {
		return midPoint.y;
	}
}
