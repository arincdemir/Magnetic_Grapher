

public class Vector2D {
	double x;
	double y;
	double magnitude;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
		this.magnitude = Math.sqrt(x*x + y*y);
	}

	public static Vector2D addVectors(Vector2D v1, Vector2D v2) {
		double newX = v1.x + v2.x;
		double newY = v1.y + v2.y;
		return new Vector2D(newX, newY);
	}
	
	public static Vector2D substractVectors(Vector2D minuend, Vector2D subtrahend) {
		double newX = minuend.x - subtrahend.x;
		double newY = minuend.y - subtrahend.y;
		return new Vector2D(newX, newY);
	}
	

	public static Vector2D scaleVector(Vector2D v, double scalar) {
		double newX = v.x * scalar;
		double newY = v.y * scalar;
		return new Vector2D(newX, newY);
	}

	@Override
	public String toString() {
		return "Vector2D [x=" + x + ", y=" + y + "]";
	}
}
