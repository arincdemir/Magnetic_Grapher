import java.util.ArrayList;

public class InputHandler {
	static ArrayList<SourceWire> sourceWires;
	
	public static void initializeHandler(ArrayList<SourceWire> sw) {
		sourceWires = sw;
	}
	
	public static void handleInputs() {
		if (StdDraw.isMousePressed()) {
			mousePressed();
		}
		else {
			mouseNotPressed();
		}
		
		
		
	}
	
	private static SourceWire attachedWire = null;
	private static boolean attached = false;
	
	
	private static void mouseNotPressed() {
		if (attached) {
			attachedWire.x = StdDraw.mouseX();
			attachedWire.y = StdDraw.mouseY();
		}
		
	}

	private static void mousePressed() {
		if (attached) {
			attached = false;
			attachedWire = null;
		}
		else {
			Vector2D mousePos = new Vector2D(StdDraw.mouseX(), StdDraw. mouseY());
			
			for (SourceWire sourceWire : sourceWires) {
				if (Vector2D.substractVectors(sourceWire, mousePos).magnitude <= SourceWire.radius) {
					attached = true;
					attachedWire = sourceWire;
				}
			}
			
		}
	}
	
	
	
}
