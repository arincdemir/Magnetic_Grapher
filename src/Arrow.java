import java.awt.Color;

public class Arrow {

	static Color color = Color.white;
	static double maxScale = 0.4;
	static Vector2D[] verticesRelativeToUnitVectors = { new Vector2D(-0.2, -1), new Vector2D(0.2, -1),
			new Vector2D(0.2, 1), new Vector2D(0.4, 1), new Vector2D(0, 1.5), new Vector2D(-0.4, 1),
			new Vector2D(-0.2, 1) };

	private Vector2D[] vertices = new Vector2D[verticesRelativeToUnitVectors.length];
	private double[] xOfVertices = new double[vertices.length];
	private double[] yOfVertices = new double[vertices.length];

	private double scale;
	private Vector2D midPoint;

	public Vector2D unitVector;
	public Vector2D perpendicularVector;

	public Arrow() {
		this(0.5, 0.5, 0.1, new Vector2D(0.707, 0.707));
	}

	public Arrow(double x, double y, double scale, Vector2D unitVector) {
		midPoint = new Vector2D(x, y);
		this.scale = scale;
		this.unitVector = unitVector;
		this.perpendicularVector = new Vector2D(unitVector.y, -unitVector.x);
		createVertices();
	}

	private void createVertices() {
		for (int i = 0; i < verticesRelativeToUnitVectors.length; i++) {
			double x = verticesRelativeToUnitVectors[i].x * perpendicularVector.x
					+ verticesRelativeToUnitVectors[i].y * unitVector.x;
			double y = verticesRelativeToUnitVectors[i].x * perpendicularVector.y
					+ verticesRelativeToUnitVectors[i].y * unitVector.y;
			vertices[i] = Vector2D.addVectors(midPoint, Vector2D.scaleVector(new Vector2D(x, y), scale));
		}

		for (int i = 0; i < vertices.length; i++) {
			xOfVertices[i] = vertices[i].x;
			yOfVertices[i] = vertices[i].y;

		}
	}

	public void draw() {
		if (scale < maxScale) {
			StdDraw.setPenColor(color);
			StdDraw.filledPolygon(xOfVertices, yOfVertices);
		}
	}

	public double getX() {
		return midPoint.x;
	}

	public double getY() {
		return midPoint.y;
	}

	@Override
	public String toString() {
		return "Arrow [scale=" + scale + ", midPoint=" + midPoint + ", unitVector=" + unitVector + "]";
	}

}
