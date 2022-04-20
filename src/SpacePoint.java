
public class SpacePoint extends Vector2D{
	private Arrow arrow;
	private Vector2D field;
	
	

	@Override
	public String toString() {
		return "SpacePoint [arrow=" + arrow + ", field=" + field + ", x=" + x + ", y=" + y + ", magnitude=" + magnitude
				+ "]";
	}

	public SpacePoint(double x, double y) {
		super(x, y);
		field = new Vector2D(0, 0);
	}
	
	public void draw() {
		arrow = new Arrow(x, y, field.magnitude, Vector2D.scaleVector(field, field.magnitude));
		arrow.draw();
	}
	
	public void resetField() {
		field = new Vector2D(0, 0);
	}
	
	public void addFieldComponent (Vector2D fieldComponent) {
		field = Vector2D.addVectors(fieldComponent, field);
	}
	
	public Arrow getArrow() {
		return arrow;
	}

	public void setArrow(Arrow arrow) {
		this.arrow = arrow;
	}

	public Vector2D getField() {
		return field;
	}

	public void setField(Vector2D field) {
		this.field = field;
	}


}
