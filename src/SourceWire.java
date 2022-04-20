
public class SourceWire extends Vector2D{
	private double current;
	static double fieldConstant = 0.15;
	static double fieldExponent = 1.3;
	

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
		Vector2D fieldVector = Vector2D.scaleVector(perpVector, current * fieldConstant / Math.pow(perpVector.magnitude, fieldExponent));
		return fieldVector;
	}
	
	
	public double getCurrent() {
		return current;
	}

	public void setCurrent(double current) {
		this.current = current;
	}
	
}
