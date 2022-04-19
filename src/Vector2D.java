
public class Vector2D {
	double x;
	double y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static Vector2D addVectors(Vector2D v1, Vector2D v2) {
		double newX = v1.x + v2.x;
		double newY = v1.y + v2.y;
		return new Vector2D(newX, newY);
	}
	
	public static Vector2D scaleVector(Vector2D v, double scalar) {
		double newX = v.x * scalar;
		double newY = v.y * scalar;
		return new Vector2D(newX, newY);
	}
}
