import java.awt.Color;

public class SourceWire extends Vector2D {
	private double current;
	static double fieldConstant = 0.0002;
	static double fieldExponent = 1;
	static double radius = 0.03;
	static Color color = Color.blue;

	@Override
	public String toString() {
		return "SourceWire [current=" + current + ", x=" + x + ", y=" + y + ", magnitude=" + magnitude + "]";
	}

	public SourceWire(double x, double y) {
		this(x, y, 1);
	}

	public SourceWire(double x, double y, double current) {
		super(x, y);
		this.current = current;
	}

	public Vector2D fieldOfPoint(Vector2D point) {
		Vector2D r = Vector2D.substractVectors(point, this);
		Vector2D perpVector = new Vector2D(r.y, -r.x);
		Vector2D fieldVector = Vector2D.scaleVector(perpVector.getUnitVector(),
				current * fieldConstant / Math.pow(r.magnitude, fieldExponent));
		return fieldVector;
	}

	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}

	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, radius);
	}

}
